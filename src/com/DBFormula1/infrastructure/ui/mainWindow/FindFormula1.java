package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.domain.entities.PilotF1;
import com.DBFormula1.domain.entitiesDao.PilotF1DAO;
import com.DBFormula1.infrastructure.ui.components.BackgroundImage;
import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.UiFactory;
import com.DBFormula1.infrastructure.export.ExportExcel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindFormula1 extends BackgroundImage {
    private InterfaceController controller;
    private Map<String, JComponent> componentesBuscador;
    private JScrollPane tableScrollNow = null;
    private List<PilotF1> nowTable = null;

    //Metodo el cual fabrica el Jpanel encargado del buscador
    public FindFormula1 (InterfaceController controller) {
        //llamar a la clase padre para que pinte el fondo
        super("sources/Image/Base/Buscador.jpg");
        this.controller = controller;

        setLayout(null);

        // Definicion de colores
        Color greyF1 = new Color(42, 40, 53);
        Color greyDarkF1 = new Color(27, 27, 39);
        Color redSelectionF1 = new Color(21, 104, 101);
        Color redF1 = new Color(5, 209, 168);

        //Url de donde se guardara los archivos excel
        String excelURL = "ExcelDB/Reporte_Pilotos_F1.xlsx";

        //Creacion del map al cual se le definiran las columnas de nuestra Base de datos y los respectivos datos que estas reciben para la tabla
        Map<String, Class<?>> campos = new LinkedHashMap<>();
        campos.put("id", Integer.class);
        campos.put("año", Integer.class);
        campos.put("equipo", String.class);
        campos.put("nombre", String.class);
        campos.put("n_Piloto", Integer.class);
        campos.put("pilotoPrincipal", Boolean.class);
        campos.put("ganadorMundial", Boolean.class);
        campos.put("posicionCampeonato", Integer.class);
        campos.put("puntosCampeonato", Integer.class);
        campos.put("victorias", Integer.class);
        campos.put("poles", Integer.class);
        campos.put("N_campeonatos", Integer.class);
        campos.put("total_Carreras", Integer.class);

        //La creacion del formulario con el metodo el cual incluye el boton y el guardado de los datos directamente un objecto el cual tiene todos los datos del formualrio
        componentesBuscador = UiFactory.CrearFormularioInteligente(this, campos, 28, 180, 388, 420,"Buscar", piloto -> {

            //Se procede a crear la lista la cual contendra todos los resultados devuelvos por el motodo BuscarPilotF1
            List<PilotF1> resultados = PilotF1DAO.BuscarPilotF1(piloto);

            //Eliminacion de seguridad de tablas anteriores
            if (tableScrollNow != null) {
                remove(tableScrollNow);
            }

            //Guardamos la tabla en general para el uso posterior en la exportacion
            nowTable = resultados;

            //Creacion de la tabla la cual contendra todos los resultados devuelvos por la base de datos
            tableScrollNow = UiFactory.createTable(resultados, 440, 350, 798, 248);

            //Se agrega la tabla actual y se revalida y se repinta
            add(tableScrollNow);
            revalidate();
            repaint();

            //Mensaje que informa la cantidad de pilotos que se encontraron con un size a la lista
            JOptionPane.showMessageDialog(this, "Se encontraron " + resultados.size() + " pilotos.");

        });

        //Creacion del boton encargo de la exportacion de la lista
        JButton exportButton = UiFactory.createButtonImage("sources/Image/Base/BotonExportar.png", 870, 0, 395, 55, greyF1, greyDarkF1, redSelectionF1, redF1);

        //Creacion de la listas de imagenes (Pilotos 1 y 2, Circuitos)
        ArrayList imagePilots1 = new ArrayList<>();
        imagePilots1.add("sources/Image/Pilots/AA.png");
        imagePilots1.add("sources/Image/Pilots/CL.png");
        imagePilots1.add("sources/Image/Pilots/CS.png");
        imagePilots1.add("sources/Image/Pilots/DR.png");
        imagePilots1.add("sources/Image/Pilots/EO.png");
        imagePilots1.add("sources/Image/Pilots/FA.png");
        imagePilots1.add("sources/Image/Pilots/GR.png");
        imagePilots1.add("sources/Image/Pilots/GZ.png");
        imagePilots1.add("sources/Image/Pilots/KM.png");
        imagePilots1.add("sources/Image/Pilots/LH.png");

        ArrayList imagePilots2 = new ArrayList<>();
        imagePilots2.add("sources/Image/Pilots/LN.png");
        imagePilots2.add("sources/Image/Pilots/LS.png");
        imagePilots2.add("sources/Image/Pilots/LSA.png");
        imagePilots2.add("sources/Image/Pilots/MV.png");
        imagePilots2.add("sources/Image/Pilots/OP.png");
        imagePilots2.add("sources/Image/Pilots/PG.png");
        imagePilots2.add("sources/Image/Pilots/SP.png");
        imagePilots2.add("sources/Image/Pilots/VB.png");
        imagePilots2.add("sources/Image/Pilots/YT.png");

        ArrayList imageCircuits = new ArrayList<>();
        imageCircuits.add("sources/Image/F1Moments/1.jpg");
        imageCircuits.add("sources/Image/F1Moments/2.jpg");
        imageCircuits.add("sources/Image/F1Moments/3.jpg");
        imageCircuits.add("sources/Image/F1Moments/4.jpg");
        imageCircuits.add("sources/Image/F1Moments/5.jpg");
        imageCircuits.add("sources/Image/F1Moments/6.jpg");
        imageCircuits.add("sources/Image/F1Moments/7.jpg");
        imageCircuits.add("sources/Image/F1Moments/8.jpg");
        imageCircuits.add("sources/Image/F1Moments/9.jpg");
        imageCircuits.add("sources/Image/F1Moments/10.jpg");


        //Creacion de todas los carruseles de imagenes
        JPanel imagesCircuits = new UiFactory().imageCreate(850, 87, 383,244, imageCircuits);
        JPanel imagesPilots1 = new UiFactory().imageCreate(440, 90, 180,240, imagePilots1);
        JPanel imagesPilots2 = new UiFactory().imageCreate(645, 90, 180,240, imagePilots2);

        //Se Agregan todos los Jpanel que contienes los carruseles de imagenes
        add(imagesCircuits);
        add(imagesPilots2);
        add(imagesPilots1);

        /*
        Creacion de los botones mediante el metodo de creacion en el UiFactory bajo la regla de creacion:
        (Icono, Cordenadas x y, Ancho, Alto, Color del fondo, Color del Icono, Color de la margen, Color del icono al pasar encima de el)
        */

        JButton botonHome = UiFactory.createButtonColor("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonBuscar = UiFactory.createButtonColor("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton botonFormulario = UiFactory.createButtonColor("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton Boton2 = UiFactory.createButtonColor("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton BotonExit = UiFactory.createButtonColor("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        //Añadir los iconos al panel para que se puedan visualizar
        add(botonHome);
        add(botonBuscar);
        add(botonFormulario);
        add(Boton2);
        add(BotonExit);
        add(exportButton);

        //Funcion de exportacion solo funcionara cuando la tabla no sea nula es decir el usuario busco algun elemento valido en la DataBase
        exportButton.addActionListener(e -> { if (nowTable !=null) {
            ExportExcel.exportExcel((List<PilotF1>) nowTable, excelURL);
            JOptionPane.showMessageDialog(this, "Se creo exitomasamente el archivo excel en " + excelURL);
        }
        else {
            JOptionPane.showMessageDialog(this, "Primero tienes que realizar una busquedad o guardar un piloto para guardar los datos en un excel");
        }
        });

        //Funciones de los botones (Salir, Cambiar de panel mediante el panelChange)
        botonHome.addActionListener(e -> controller.panelChange("StartPanel"));
        botonFormulario.addActionListener(e -> controller.panelChange("FormPanel") );
        botonBuscar.addActionListener(e -> controller.panelChange("FindPanel") );
        BotonExit.addActionListener(e -> System.exit(0));
    }
}