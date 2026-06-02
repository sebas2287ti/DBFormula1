package com.DBFormula1;


import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import javax.swing.*;

public class DBFormula1 {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {

            //Creacion de la ventana JFrame
            JFrame windowMain = new JFrame("F1 Manager");
            windowMain.setSize(1280, 720);
            windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowMain.setLocationRelativeTo(null);
            windowMain.setResizable(false);

            //Iniciar el controlador de todos los paneles dentro de la ventana principal y volverla visible
            InterfaceController controller = new InterfaceController(windowMain);
            windowMain.setVisible(true);
        });
    }
}
