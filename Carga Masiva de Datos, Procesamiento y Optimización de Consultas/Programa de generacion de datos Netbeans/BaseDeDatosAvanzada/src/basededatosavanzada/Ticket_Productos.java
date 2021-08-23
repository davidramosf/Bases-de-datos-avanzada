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
public class Ticket_Productos {
    
     ArrayList<String> listaTicket;
     ArrayList<String> listaProducto;
    ArrayList<String> listaAux;
    public Ticket_Productos(ArrayList<String> ticket, ArrayList<String> producto) {
        listaTicket = ticket;
        listaProducto = producto;
        listaAux = new ArrayList<String>();
    }

    public void generarDatos(int numeroRegistros) throws IOException {
        int contador = 1;
        FileWriter escribir = new FileWriter("datos_Ticket_Productos.txt", true);
        Random rand = new Random();
        int min = 1;
        int max = 10;       
        while (contador <= numeroRegistros) {
            String aux = Integer.toString(contador);
            listaAux.clear();
            for (int i = 0; i < listaProducto.size(); i++) {
                listaAux.add((String) listaProducto.get(i));
            }
            int productosTienda = rand.nextInt(9)+1;
            while (productosTienda > 0 & !listaAux.isEmpty() & !listaTicket.isEmpty()) {
                int nAleatorio = rand.nextInt((listaAux.size()));
                escribir.write(listaTicket.get(contador - 1) + ";" + listaAux.get(nAleatorio) + ";" + (rand.nextInt((max - min) + 1) + min));
                escribir.write("\r\n");
                listaAux.remove(nAleatorio);
                productosTienda -= 1;

            }
            contador += 1;
        }
        escribir.close();
    }
}
