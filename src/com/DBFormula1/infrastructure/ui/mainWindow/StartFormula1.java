package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.BackgroundVideo;
import com.DBFormula1.infrastructure.ui.components.UiFactory;
import com.DBFormula1.infrastructure.ui.components.BackgroundImage;
import java.awt.*;
import javax.swing.*;


public class StartFormula1 extends JPanel  {
    private final InterfaceController CONTROLER;
    private final BackgroundVideo backgroundVideo;
    private final JLayeredPane layeredPane;
    private String videoActual = "";

    public StartFormula1 (InterfaceController controller) {
        this.CONTROLER = controller;

        setPreferredSize(new Dimension(1280, 720));
        super.setLayout(new BorderLayout());
        this.setOpaque(false);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 720);
        add(layeredPane);

        //inicializacion de los componentes y definicion del tamaño para el video
        this.backgroundVideo = new BackgroundVideo();
        Component videoComponent = backgroundVideo.getComponenteVisual();
        videoComponent.setBounds(0, 0, 1280, 720);

        //inicializacion del fondo principal y definicion del tamaño
        BackgroundImage fondoInicial = new BackgroundImage("sources/Image/Fondo/FormulaPantallaInicio.jpeg");
        fondoInicial.setBounds(0, 0, 1280, 720);

        //Definicion de los video
        String startVideo = "sources/Video/Fondo/F1Opening.mp4";

        // Definicion de colores
        Color greyF1 = new Color(42, 40, 53);
        Color greyDarkF1 = new Color(27, 27, 39);
        Color redSelectionF1 = new Color(104, 21, 31);
        Color redF1 = new Color(209, 7, 5);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */

        JButton startButton = UiFactory.createButtonColor("Empezar la busquedad", 874, 435, 250, 35, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);

        layeredPane.add(videoComponent, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(fondoInicial, JLayeredPane.DEFAULT_LAYER);

        //Añadir los iconos al panel para que se puedan visualizar
        layeredPane.add(startButton, JLayeredPane.PALETTE_LAYER);

        //Funciones que ejecuta cuando le click al boton
            startButton.addActionListener(_ -> {
                this.backgroundVideo.pauseVideo();
                videoActual = "";
                this.CONTROLER.panelChange("TeamsPanel");
            });

        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != startVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(startVideo);
                    startButton.setBounds(950, 20, 250, 35);

                    //
                    videoActual = startVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

    }


}
