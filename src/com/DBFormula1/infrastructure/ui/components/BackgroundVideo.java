package com.DBFormula1.infrastructure.ui.components;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundVideo {
    //Creacion del Componente que permetira la vizualizacion del video
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    //Construtor el cual definite que va a ser un nuevo componente de video
    public BackgroundVideo() {
        this.mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        this.mediaPlayerComponent.setVisible(false);

        this.mediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(
                new uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter() {
                    @Override
                    public void finished(uk.co.caprica.vlcj.player.base.MediaPlayer mediaPlayer) {
                        SwingUtilities.invokeLater(() -> {
                            mediaPlayerComponent.setVisible(false);
                        });
                    }
                }
        );
    }

    //Retorna para la vizualizacion el componente el cual sera el que tendra el video dentro
    public Component getComponenteVisual() {
        return this.mediaPlayerComponent;
    }

    //Inicia la creacion del componente de vizualizacion de video mediante la URL
    public void startVideo(String URL) {
        //Crea el archivo con la URL
        File video = new File(URL);

        //Si el archivo si existe crea el video apartir de la url que proporcionamos
        if (video.exists()) {

            if (!mediaPlayerComponent.isVisible()) {
                mediaPlayerComponent.setVisible(true);
            }

            mediaPlayerComponent.mediaPlayer().media().play(URL);
        } else {
            System.out.print("Error video");
        }
    }

    //Cuando se cierra java 25 se necesita eliminar todos los datos que queden en el hilo para eso el KillResources
    public void killResources() {
        mediaPlayerComponent.release();
    }

    //Metodo que pausa el video
    public void pauseVideo() {
        if (mediaPlayerComponent != null && mediaPlayerComponent.mediaPlayer().status().isPlaying()) {
            mediaPlayerComponent.mediaPlayer().controls().pause();
        }
    }

    //metodo que hace continuar el video si estaba pausado
    public void resumeVideo() {
        if (mediaPlayerComponent != null && !mediaPlayerComponent.mediaPlayer().status().isPlaying()) {
            mediaPlayerComponent.mediaPlayer().controls().play();
        }
    }
}
