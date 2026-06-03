package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.BackgroundVideo;
import com.DBFormula1.infrastructure.ui.components.UiFactory;

import java.awt.*;
import javax.swing.*;


public class TeamsFormula1 extends JPanel  {
    private final InterfaceController CONTROLER;
    private final BackgroundVideo backgroundVideo;
    private final JLayeredPane layeredPane;
    private String videoActual = "";

    public TeamsFormula1 (InterfaceController controller) {
        this.CONTROLER = controller;

        setPreferredSize(new Dimension(1280, 720));
        super.setLayout(new BorderLayout());
        this.setOpaque(false);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 720);
        add(layeredPane);

        this.backgroundVideo = new BackgroundVideo();
        Component videoComponent = backgroundVideo.getComponenteVisual();
        videoComponent.setBounds(0, 0, 1280, 720);
        //Definicion de los videos de los equipos
        String mclarenVideo = "sources/Video/VideoTeams/MCLAREN.mp4";
        String redbullVideo = "";
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

        layeredPane.add(videoComponent, JLayeredPane.DEFAULT_LAYER);

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

        //Funciones que ejecuta el video apenas el mouse pasa encima
        mclarenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != mclarenVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(mclarenVideo);

                    //
                    videoActual = mclarenVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        mclarenButton.addActionListener(_ -> {
        });

        redbullButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != redbullVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(redbullVideo);

                    //
                    videoActual = redbullVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        redbullButton.addActionListener(_ -> {
        });

        ferrariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != ferrariVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(ferrariVideo);

                    //
                    videoActual = ferrariVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        ferrariButton.addActionListener(_ -> {
        });

        mercedesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != mercedesVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(mercedesVideo);

                    //
                    videoActual = mercedesVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        mercedesButton.addActionListener(_ -> {
        });

        racingbullsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != racingbullsVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(racingbullsVideo);

                    //
                    videoActual = racingbullsVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        racingbullsButton.addActionListener(_ -> {
        });

        astonmartinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != astonmartinVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(astonmartinVideo);

                    //
                    videoActual = astonmartinVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        astonmartinButton.addActionListener(_ -> {
        });

        alpineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != alpineVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(alpineVideo);

                    //
                    videoActual = alpineVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        alpineButton.addActionListener(_ -> {
        });

        cadillacButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != cadillacVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(cadillacVideo);

                    //
                    videoActual = cadillacVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        cadillacButton.addActionListener(_ -> {
        });

        audiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != audiVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(audiVideo);

                    //
                    videoActual = audiVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        audiButton.addActionListener(_ -> {
        });

        williamsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != williamsVideo) {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo(williamsVideo);

                    //
                    videoActual = williamsVideo;

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
        });

        williamsButton.addActionListener(_ -> {
        });

        /*
        findButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (videoActual != "sources/Video/VideoTeams/Ferrari SF-25 REVEALED! First Look at Ferrari’s 2025 F1 Car - Ferrari (720p, h264).mp4") {
                    // Ejecuta el video usando la variable global de la clase
                    backgroundVideo.startVideo("sources/Video/VideoTeams/Ferrari SF-25 REVEALED! First Look at Ferrari’s 2025 F1 Car - Ferrari (720p, h264).mp4");

                    //
                    videoActual = "sources/Video/VideoTeams/Ferrari SF-25 REVEALED! First Look at Ferrari’s 2025 F1 Car - Ferrari (720p, h264).mp4";

                    // Refrescamos el contenedor de capas para que se vea el cambio inmediatamente
                    SwingUtilities.invokeLater(() -> {
                        layeredPane.repaint();
                    });
                }
            }
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
        */
    }

}
