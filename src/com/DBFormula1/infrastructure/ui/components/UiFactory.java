package com.DBFormula1.infrastructure.ui.components;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.AlphaComposite;

import static javax.swing.UIManager.getIcon;

public class UiFactory {

    //Metodo de creacion de botones apartir de (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
    public static JButton createButtonColor(String symbol, int x, int y, int w, int h, Color background, Color text, Color border, Color reColorText) {
        JButton button = new JButton(symbol);

        //Definicion de las caracteristicas del boton (posicion, color de fondo, color de borde)
        button.setBounds(x, y, w, h);
        button.setBackground(background);
        button.setFont(new Font("SansSerif", Font.BOLD, 24));
        button.setForeground(text);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(border, 1));

        //Creacion de eventos cuando el mouse esta encima del boton y cuando no
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(border);
                button.setForeground(reColorText);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(background);
                button.setForeground(text);
            }
        });

        //retorno del boton totalmente creado para el uso
        return button;
    }

    public static JButton createButtonImage(String URLImage, int x, int y, int w, int h, Color background, Color border, Color backgroundMouse, Color borderMouse) {
        JButton button = new JButton();

        //Definicion de las caracteristicas del boton (posicion, color de fondo, color de borde)
        button.setBounds(x, y, w, h);
        button.setBackground(background);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(border, 3));

        ImageIcon originalIcon = new ImageIcon(URLImage);
        Image imageFix = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(imageFix));

        //Creacion de eventos cuando el mouse esta encima del boton y cuando no
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(backgroundMouse);
                button.setBorder(BorderFactory.createLineBorder(borderMouse, 3));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(background);
                button.setBorder(BorderFactory.createLineBorder(border, 3));
            }
        });

        //retorno del boton totalmente creado para el uso
        return button;
    }
}


