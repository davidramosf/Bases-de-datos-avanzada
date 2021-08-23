/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosavanzada;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Productos {

    ArrayList<String> listaPkProductos = new ArrayList<String>();
    
    public Productos() {
      
    }

    public void generarDatos(int numeroRegistros) throws IOException {
        int contador = 1;
        FileWriter escribir = new FileWriter("datos_productos.txt", true);
        Random rand = new Random();
        int min = 50;
        int max = 1000;
        while (contador <= numeroRegistros) {
            String aux = Integer.toString(contador);
            listaPkProductos.add("CB" + aux);
            escribir.write("CB" + aux + ";" + "nombre" + aux +";"+ "tipo" + aux + ";" + "descripcion" + aux + ";" + (rand.nextInt((max - min) + 1) + min));
            escribir.write("\r\n");
            contador += 1;
        }
        escribir.close();
    }

    public ArrayList getListaProductos() {
        return listaPkProductos;
    }

}
