package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.BackgroundVideo;
import com.DBFormula1.infrastructure.ui.components.UiFactory;
import com.DBFormula1.infrastructure.ui.components.BackgroundImage;
import java.awt.*;
import javax.swing.*;


public class TeamsFormula1 extends JPanel  {
    private final InterfaceController CONTROLER;
    private final BackgroundVideo backgroundVideo;
    private final JLayeredPane layeredPane;
    private String nowVideo = "";

    public TeamsFormula1 (InterfaceController controller) {
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
        BackgroundImage fondoInicial = new BackgroundImage("sources/Image/Fondo/FondoTeams.jpg");
        fondoInicial.setBounds(0, 0, 1280, 720);

        //Definicion de los videos de los equipos
        String mclarenVideo = "sources/Video/VideoTeams/MCLAREN.mp4";
        String redbullVideo = "sources/Video/VideoTeams/redbull.mp4";
        String ferrariVideo = "sources/Video/VideoTeams/Ferrari SF-25 REVEALED! First Look at Ferrari’s 2025 F1 Car - Ferrari (720p, h264).mp4";
        String mercedesVideo = "sources/Video/VideoTeams/Before Lights Out, a W11 Light Show \uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D - Mercedes-AMG Petronas Formula One Team (720p, h264).mp4";
        String racingbullsVideo = "sources/Video/VideoTeams/VCARB 01 - Entering Our New Era - Visa Cash App RB F1 Team (720p, h264).mp4";
        String astonmartinVideo = "sources/Video/VideoTeams/AMR24 Reveal  Hyper-focus - Aston Martin Aramco Formula One™ Team (720p, h264).mp4";
        String alpineVideo = "sources/Video/VideoTeams/alpine.mp4";
        String cadillacVideo = "sources/Video/VideoTeams/Cadillac Formula 1® Team 2026 Livery Reveal  The Mission Begins - Cadillac Formula 1® Team (720p, h264).mp4";
        String audiVideo = "sources/Video/VideoTeams/Audi Motorsport Icons Progress beyond the finish line  The Audi R26 Concept, designed for racing - Audi (720p, h264).mp4";
        String williamsVideo = "sources/Video/VideoTeams/2026 Livery Reveal  Atlassian Williams F1 Team - Atlassian Williams F1 Team (720p, h264).mp4";

        // Definicion de colores
        Color greyF1 = new Color(42, 40, 53);
        Color greyDarkF1 = new Color(27, 27, 39);
        Color redSelectionF1 = new Color(104, 21, 31);
        Color redF1 = new Color(209, 7, 5);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */
        JButton mclarenButton = UiFactory.createButtonImage("sources/Image/LogoTeams/MclarenLogo.png", 16, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton redbullButton = UiFactory.createButtonImage("sources/Image/LogoTeams/RedBullLogo.png", 140, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton ferrariButton = UiFactory.createButtonImage("sources/Image/LogoTeams/FerrariLogo.png", 264, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton mercedesButton = UiFactory.createButtonImage("sources/Image/LogoTeams/MercedesLogo.png", 388, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton racingbullsButton = UiFactory.createButtonImage("sources/Image/LogoTeams/RacingBullsLogo.png", 512, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton astonmartinButton = UiFactory.createButtonImage("sources/Image/LogoTeams/AstonMartinLogo.png", 636, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton alpineButton = UiFactory.createButtonImage("sources/Image/LogoTeams/AlpineLogo.png", 760, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton cadillacButton = UiFactory.createButtonImage("sources/Image/LogoTeams/CadillacLogo.png", 884, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton audiButton = UiFactory.createButtonImage("sources/Image/LogoTeams/AudiLogo.png", 1008, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);
        JButton williamsButton = UiFactory.createButtonImage("sources/Image/LogoTeams/WilliamsLogo.png", 1132, 575, 116, 85, greyF1, greyDarkF1, redSelectionF1, redF1);

        JButton returnButton = UiFactory.createButtonImage("sources/Image/Fondo/returnButton.jpg", 20, 20, 45, 45, greyF1, greyDarkF1, redSelectionF1, redF1);

        layeredPane.add(videoComponent, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(fondoInicial, JLayeredPane.DEFAULT_LAYER);

        //Añadir los iconos al panel para que se puedan visualizar
        layeredPane.add(mclarenButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(redbullButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(ferrariButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mercedesButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(racingbullsButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(astonmartinButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(alpineButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(cadillacButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(audiButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(williamsButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(returnButton, JLayeredPane.PALETTE_LAYER);

        //Funciones que ejecuta el video apenas el mouse pasa encima
        mclarenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != mclarenVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(mclarenVideo);

                    //
                    nowVideo = mclarenVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        mclarenButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        redbullButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != redbullVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(redbullVideo);

                    //
                    nowVideo = redbullVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        redbullButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        ferrariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != ferrariVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(ferrariVideo);

                    //
                    nowVideo = ferrariVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        ferrariButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        mercedesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != mercedesVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(mercedesVideo);

                    //
                    nowVideo = mercedesVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        mercedesButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        racingbullsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != racingbullsVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(racingbullsVideo);

                    //
                    nowVideo = racingbullsVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        racingbullsButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        astonmartinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != astonmartinVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(astonmartinVideo);

                    //
                    nowVideo = astonmartinVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        astonmartinButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        alpineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != alpineVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(alpineVideo);

                    //
                    nowVideo = alpineVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        alpineButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        cadillacButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != cadillacVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(cadillacVideo);

                    //
                    nowVideo = cadillacVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        cadillacButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        audiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != audiVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(audiVideo);

                    //
                    nowVideo = audiVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        audiButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        williamsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (nowVideo != williamsVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(williamsVideo);

                    //
                    nowVideo = williamsVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        williamsButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            controller.panelChange("FindPanel");
        });

        //Funciones que ejecuta cuando le click al boton
        returnButton.addActionListener(_ -> {
            this.backgroundVideo.pauseVideo();
            nowVideo = "";
            this.CONTROLER.panelChange("StartPanel");
        });

    }
}

