package com.DBFormula1.infrastructure.ui.components;

import com.DBFormula1.infrastructure.ui.mainWindow.TeamsFormula1;
import com.DBFormula1.infrastructure.ui.mainWindow.StartFormula1;

import javax.swing.*;
import java.awt.*;

public class InterfaceController {
    private final CardLayout CARDLAYOUT;
    private final JPanel CONTAINER;

    //Creacion del controlador de la interfaz
    public InterfaceController(JFrame windowMain) {
        this.CARDLAYOUT = new CardLayout();
        this.CONTAINER = new JPanel(CARDLAYOUT);

        //Inicializacion de los paneles con este controlador

        // Creacion del objecto panel example  -- StartPanel startPanel =  new StartPanel(this);
        TeamsFormula1 teamsFormula1 = new TeamsFormula1(this);
        StartFormula1 startFormula1 = new StartFormula1(this);

        //Agregar los paneles inicializados al panel container el cual los contendra a todos

        // Se agregan al contenedor del cardlayoud para su carga y almacenaje -- CONTAINER.add(startPanel, "StartPanel");
        CONTAINER.add(startFormula1, "StartPanel");
        CONTAINER.add(teamsFormula1, "TeamsPanel");

        //Agregar el panel contenedor a la ventana principal donde se mostrara
        windowMain.add(CONTAINER);
        windowMain.setVisible(true);
    }

    //Metodo que permite cambiar entre paneles visibles y no visibles en la ventana Principal
    public void panelChange(String panelName) {
        CARDLAYOUT.show(CONTAINER, panelName);
    }
}