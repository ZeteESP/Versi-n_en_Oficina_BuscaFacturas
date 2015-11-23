/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorfacturas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel {


    public static void LeerExcel(Buscafacturas athis) {
        try {
            FileInputStream file = new FileInputStream(new File(athis.excelRename));
            // Crear el objeto que tendra el libro de Excel
            XSSFWorkbook workbook = null;

            try {
                workbook = new XSSFWorkbook(file);
                /*
                 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
                 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
                 * que nos permite recorrer cada una de las filas que contiene.
                 */
            } catch (IOException ex) {
                Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
            }

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            Row row;

            // Recorremos todas las filas para mostrar el contenido de cada celda
            while (rowIterator.hasNext()) {

                row = rowIterator.next();

                // Obtenemos el iterator que permite recorres todas las celdas de una fila
                Iterator<Cell> cellIterator = row.cellIterator();

                Cell celda;

                while (cellIterator.hasNext()) {

                    celda = cellIterator.next();

                    // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                    switch (celda.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:

                            if (DateUtil.isCellDateFormatted(celda)) {

                                System.out.println(celda.getDateCellValue());

                            } else {

                                System.out.println(celda.getNumericCellValue());

                            }

                            break;

                        case Cell.CELL_TYPE_STRING:

                            System.out.println(celda.getStringCellValue());

                            break;

                        case Cell.CELL_TYPE_BOOLEAN:

                            System.out.println(celda.getBooleanCellValue());

                            break;

                    }

                }

            }

            try {
                // cerramos el libro excel

                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFileChooser chooser;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(athis) == JFileChooser.APPROVE_OPTION) {
            athis.carpetaRename = chooser.getSelectedFile().getAbsolutePath();
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }
}
