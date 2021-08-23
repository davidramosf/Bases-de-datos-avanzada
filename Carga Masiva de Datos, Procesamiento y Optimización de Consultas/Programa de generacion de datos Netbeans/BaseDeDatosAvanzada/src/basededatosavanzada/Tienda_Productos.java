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
public class Tienda_Productos {

    ArrayList<String> listaTienda;
    ArrayList<String> listaProducto;
    ArrayList<String> listaAux;

    public Tienda_Productos(ArrayList<String> tienda, ArrayList<String> producto) {
        listaTienda = tienda;
        listaProducto = producto;
        listaAux = new ArrayList<String>();
    }

    public void generarDatos(int numeroRegistros) throws IOException {
        int contador = 1;
        int contador2 = 1;
        FileWriter escribir = new FileWriter("datos_Tienda_Productos.txt", true);
        Random rand = new Random();
        int min = 10;
        int max = 200;

        while (contador2 <= numeroRegistros) {
            String aux = Integer.toString(contador);
            listaAux.clear();
            for (int i = 0; i < listaProducto.size(); i++) {
                listaAux.add((String) listaProducto.get(i));
            }
            int productosTienda = 100;
            while (productosTienda > 0 & !listaAux.isEmpty() & !listaTienda.isEmpty()& contador2<=numeroRegistros) {
                int nAleatorio = rand.nextInt((listaAux.size()));
                escribir.write(listaTienda.get(contador - 1) + ";" + listaAux.get(nAleatorio) + ";" + (rand.nextInt((max - min) + 1) + min));
                escribir.write("\r\n");
                listaAux.remove(nAleatorio);
                productosTienda -= 1;
                contador2 += 1;
            }
            contador += 1;
        }
        escribir.close();
    }
}
