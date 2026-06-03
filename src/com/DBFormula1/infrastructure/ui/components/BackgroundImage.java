package com.DBFormula1.infrastructure.ui.components;

import javax.swing.*;
import java.awt.*;


public class BackgroundImage extends JPanel {
    private Image imageBackground;

    //Obtencion de la imagen apartir de la ubicacion en sources
    public BackgroundImage(String locationImage) {

        this.imageBackground = new ImageIcon(locationImage).getImage();
        setOpaque(false);
    }

    //Encargado de pintar la imagen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imageBackground != null) {
            g.drawImage(imageBackground, 0, 0, getWidth(), getHeight(), this);
        } else {

            g.setColor(new Color(22, 27, 46));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
