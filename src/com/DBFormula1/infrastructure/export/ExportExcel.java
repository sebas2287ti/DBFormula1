package com.DBFormula1.infrastructure.export;

import com.DBFormula1.domain.entities.PilotF1;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//clase en la que se pondra el metodo para exportar el excel
public class ExportExcel {

    //Metodo que crea una hoja de excel y llena los datos apartir de la lista de resultados que devuelve la base de datos o los que ingreso el usuario
    public static void exportExcel (List<PilotF1> nowTable, String URLExcel) {
        //Crea el libro de excel
        try (Workbook excelDB = new XSSFWorkbook()) {

            //Creacion de la hoja dentro del libro
            Sheet formulaF1 = excelDB.createSheet("Pilotos F1");

            //Todas las columnas que contendra la tabla
            String[] columnas = {"ID", "Año", "Equipo", "Nombre", "N° Piloto", "Piloto Principal", "Ganador Mundial", "Posición", "Puntos", "Victorias", "Poles", "N° Campeonatos", "Total Carreras"
            };

            //Modificacion de los titulos de mi hoja formula 1
            Row headerRow = formulaF1.createRow(0);
            CellStyle headerCellStyle = excelDB.createCellStyle();
            Font headerFont = excelDB.createFont();

            //Modificacion de la letra mas exactamente poner en negrilla con el true
            headerFont.setBold(true);
            headerCellStyle.setFont(headerFont);

            //Aplicar en las columnas todos los nombres de la estas mismas con el array de strings
            for (int i = 0; i < columnas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerCellStyle);
            }

            //Definimos en que fila se empezara a guardar todos los datos (en la 1 por que en la 0 estaba los titulos)
            int numFila = 1;

            for (PilotF1 piloto : nowTable) {
                Row row = formulaF1.createRow(numFila++);

                //Llenado de toda la hoja de excel (Literalmente un gran reciclaje del llenado de la tabla) con los get del pilotf1
                row.createCell(0).setCellValue(piloto.getId() != null ? piloto.getId() : 0);
                row.createCell(1).setCellValue(piloto.getAño() != null ? piloto.getAño() : 0);
                row.createCell(2).setCellValue(piloto.getEquipo() != null ? piloto.getEquipo() : "");
                row.createCell(3).setCellValue(piloto.getNombre() != null ? piloto.getNombre() : "");
                row.createCell(4).setCellValue(piloto.getN_Piloto() != null ? piloto.getN_Piloto() : 0);
                row.createCell(5).setCellValue(piloto.getPilotoPrincipal() ? "Sí" : "No");
                row.createCell(6).setCellValue(piloto.getGanadorMundial() ? "Sí" : "No");
                row.createCell(7).setCellValue(piloto.getPosicionCampeonato() != null ? piloto.getPosicionCampeonato() : 0);
                row.createCell(8).setCellValue(piloto.getPuntosCampeonato() != null ? piloto.getPuntosCampeonato() : 0.0);
                row.createCell(9).setCellValue(piloto.getVictorias() != null ? piloto.getVictorias() : 0);
                row.createCell(10).setCellValue(piloto.getPoles() != null ? piloto.getPoles() : 0);
                row.createCell(11).setCellValue(piloto.getN_campeonatos() != null ? piloto.getN_campeonatos() : 0);
                row.createCell(12).setCellValue(piloto.getTotal_Carreras() != null ? piloto.getTotal_Carreras() : 0);
            }

            //Pasar por todas las columnas y ejecutar el comando autoSize para que se adapta las columnas deacuerdo al texto
            for (int i = 0; i < columnas.length; i++) {
                formulaF1.autoSizeColumn(i);
            }

            //Exportacion // escritura del excel ya final
            try (FileOutputStream outExcel = new FileOutputStream(URLExcel)) {
                excelDB.write(outExcel);
            }

        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
