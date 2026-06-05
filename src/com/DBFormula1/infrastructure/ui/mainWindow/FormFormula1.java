package com.DBFormula1.infrastructure.ui.mainWindow;

import com.DBFormula1.domain.entitiesDao.PilotF1DAO;
import com.DBFormula1.domain.entities.PilotF1;
import com.DBFormula1.infrastructure.export.ExportExcel;
import com.DBFormula1.infrastructure.ui.components.BackgroundImage;
import com.DBFormula1.infrastructure.ui.components.InterfaceController;
import com.DBFormula1.infrastructure.ui.components.UiFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Metodo para la creacion del panel de formulario y extension a la clase padre para poner el fondo
public class FormFormula1 extends BackgroundImage {
    //Definiciones basicas para el uso
    private InterfaceController controler;
    private Map<String, JComponent> componentsForm;
    private JScrollPane tableScrollNow = null;
    private List<PilotF1> nowTable = null;

    public FormFormula1 (InterfaceController controler) {
        super("sources/Image/Base/NuevoPiloto.jpg");
        this.controler = controler;

        setLayout(null);

        // Definicion de colores
        Color greyF1 = new Color(42, 40, 53);
        Color greyDarkF1 = new Color(27, 27, 39);
        Color redSelectionF1 = new Color(104, 21, 31);
        Color redF1 = new Color(209, 7, 5);


        //Creacion del map al cual se le definiran las columnas de nuestra Base de datos y los respectivos datos que estas reciben para la tabla
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        fields.put("año", Integer.class);
        fields.put("equipo", String.class);
        fields.put("nombre", String.class);
        fields.put("n_Piloto", Integer.class);
        fields.put("pilotoPrincipal", Boolean.class);
        fields.put("ganadorMundial", Boolean.class);
        fields.put("posicionCampeonato", Integer.class);
        fields.put("puntosCampeonato", Integer.class);
        fields.put("victorias", Integer.class);
        fields.put("poles", Integer.class);
        fields.put("N_campeonatos", Integer.class);
        fields.put("total_Carreras", Integer.class);

        //La creacion del formulario con el metodo el cual incluye el boton y el guardado de los datos directamente un objecto el cual tiene todos los datos del formualrio
        componentsForm = UiFactory.CrearFormularioInteligente(this, fields, 28, 180, 388, 420,"Guardar", DatePilotF1 -> {

            //If activa el metodo insertar al pasarle el objecto resultante de nuestro Formulario que tambien verifica que si se logro el guardado de los datos del formulario y la comunicacion con la base de datos
            if ( PilotF1DAO.insertPilot(DatePilotF1) == true) {

                //Creacion de la lista que contendra todos los datos
                List<PilotF1> resultDB = new java.util.ArrayList<>();

                //En este caso que solo es la operacion de añadir DatePilotF1 solo se añadira al DatePilotF1 que se inserto en la base de datos
                resultDB.add(DatePilotF1);

                //Metodo encargo para la eliminacion de tablas anteriores
                if (tableScrollNow != null) {
                    remove(tableScrollNow);
                }

                //Se guarda la tabla actual para el uso posterior en el exportamiento
                nowTable = resultDB;

                //Creacion de la nueva tabla
                tableScrollNow = UiFactory.createTable(resultDB, 440, 350, 798, 248);

                //Se añade la nueva table y se redibuja y revalida los datos en esta misma
                add(tableScrollNow);
                revalidate();
                repaint();

                //Boton que le verifica al usuario que fue un exito el agregar al neuvo DatePilotF1
                JOptionPane.showMessageDialog(this, "Piloto " + DatePilotF1.getNombre() + " guardado");
            }
            else {
                //Boton que le verifica al usuario que fue no se pudo el agregar al nuevo DatePilotF1
                JOptionPane.showMessageDialog(this, "Fallo el guardado del DatePilotF1 " + DatePilotF1.getNombre() + " revisa la peticion");
            };
        });

        //Url de donde se guardara los archivos excel
        String excelURL = "ExcelDB/Reporte_Pilotos_F1.xlsx";

        //Creacion del boton encargo de la exportacion de la lista
        JButton exportButton = UiFactory.createButtonImage("sources/Image/LogoTeams/WilliamsLogo.png", 870, 0, 395, 55, greyF1, greyDarkF1, redSelectionF1, redF1);


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
        JButton homeButton = UiFactory.createButtonColor("⌂", 60, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton findButton = UiFactory.createButtonColor("\uD83D\uDD0D", 110, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton formButton = UiFactory.createButtonColor("\uD83C\uDFCE\uFE0F", 160, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton testButton = UiFactory.createButtonColor("\uD83D\uDE99", 210, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);
        JButton exitButton = UiFactory.createButtonColor("\uD83C\uDFC1", 260, 631, 50, 50, new Color(41, 43, 58), Color.WHITE, Color.WHITE, Color.black);

        //Añadir los iconos al panel para que se puedan visualizar
        add(homeButton);
        add(findButton);
        add(formButton);
        add(testButton);
        add(exitButton);
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
        homeButton.addActionListener(e -> controler.panelChange("StartPanel"));
        formButton.addActionListener(e -> controler.panelChange("FormPanel") );
        findButton.addActionListener(e -> controler.panelChange("FindPanel") );
        exitButton.addActionListener(e -> System.exit(0));
    }
}
