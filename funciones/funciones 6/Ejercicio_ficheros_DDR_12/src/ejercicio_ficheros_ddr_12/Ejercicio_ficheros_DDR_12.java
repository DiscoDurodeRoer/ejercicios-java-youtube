package ejercicio_ficheros_ddr_12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ejercicio_ficheros_DDR_12 {

    public static void main(String[] args) {

        try {
            //abrimos el XSSFWorkbook
            FileInputStream f = new FileInputStream("datos.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);

            //seleccionamos la primera hoja
            XSSFSheet hoja = libro.getSheetAt(0);

            //Cogemos todas las filas de esa hoja
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila;
            Cell celda;
            //recorremos las filas
            while (filas.hasNext()) {

                //Cogemos la siguiente fila
                fila = filas.next();

                //Cogemos todas las celdas de esa fila
                celdas = fila.cellIterator();

                //REcorremos todas las celdas
                while (celdas.hasNext()) {

                    //Cogemos la siguiente fila
                    celda = celdas.next();

                    //Segun el tipo de celda, usaremos uno u otra funcion
                    switch (celda.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:

                            System.out.println(celda.getNumericCellValue());

                            break;
                        case Cell.CELL_TYPE_STRING:

                            System.out.println(celda.getStringCellValue());

                            break;

                    }

                }
            }

            //cerramos el libro
            f.close();
            libro.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
