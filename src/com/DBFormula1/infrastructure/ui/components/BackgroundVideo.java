package com.DBFormula1.infrastructure.ui.components;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import java.awt.*;
import java.io.File;

public class BackgroundVideo {
    //Creacion del Componente que permetira la vizualizacion del video
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    //Construtor el cual definite que va a ser un nuevo componente de video
    public BackgroundVideo() {
        this.mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
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
            mediaPlayerComponent.mediaPlayer().media().play(URL);
        } else {
            System.out.print("Error video");
        }
    }

    //Cuando se cierra java 25 se necesita eliminar todos los datos que queden en el hilo para eso el KillResources
    public void killResources() {
        mediaPlayerComponent.release();
    }
}
