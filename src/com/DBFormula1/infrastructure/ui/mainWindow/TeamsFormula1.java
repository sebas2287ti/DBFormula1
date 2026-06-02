package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.infrastructure.ui.components.BackgroundImage;
import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.BackgroundVideo;
import com.DBFormula1.infrastructure.ui.components.UiFactory;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class TeamsFormula1 extends JPanel {
    private final InterfaceController CONTROLER;
    private final BackgroundVideo backgroundVideo;

    public TeamsFormula1 (InterfaceController controller) {
        this.CONTROLER = controller;

        setPreferredSize(new Dimension(1280, 720));
        super.setLayout(new BorderLayout());

        this.backgroundVideo = new BackgroundVideo();
        Component videoComponent = backgroundVideo.getComponenteVisual();


        add(videoComponent, BorderLayout.CENTER);

        JPanel glassPanel = new JPanel();
        glassPanel.setLayout(null);
        glassPanel.setOpaque(false);

        glassPanel.setBounds(850, 400, 300, 100);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */
        JButton homeButton = UiFactory.createButton("⌂", 870, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton findButton = UiFactory.createButton("\uD83D\uDD0D", 870 + 50, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton formButton = UiFactory.createButton("\uD83C\uDFCE", 870 + 50 * 2, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton testButton = UiFactory.createButton("\uD83D\uDE99", 870 + 50 * 3, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);
        JButton exitButton = UiFactory.createButton("\uD83C\uDFC1", 870 + 50 * 4, 415, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.red, Color.black);

        setLayout(null);
        videoComponent.setBounds(0, 0, 1280, 720);

        //Añadir los iconos al panel para que se puedan visualizar
        add(homeButton);
        add(findButton);
        add(formButton);
        add(testButton);
        add(exitButton);
        add(videoComponent);


        //Funciones de los botones (Salir, Cambiar de panel mediante el panelChange)
        homeButton.addActionListener(_ -> {
                this.backgroundVideo.startVideo("sources/Video/VideoTeams/MCLAREN.mp4");
            SwingUtilities.invokeLater(() -> {
                videoComponent.setVisible(false);
                videoComponent.setVisible(true);
            });
            });

        findButton.addActionListener(_ -> {
            this.backgroundVideo.startVideo("sources/Video/VideoTeams/Ferrari SF-25 REVEALED! First Look at Ferrari’s 2025 F1 Car - Ferrari (720p, h264).mp4");
            SwingUtilities.invokeLater(() -> {
                videoComponent.setVisible(false);
                videoComponent.setVisible(true);
            });
        });

        exitButton.addActionListener(_ -> {
            backgroundVideo.killResources();
            System.exit(0);
        });
    }

}
