/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosavanzada;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class BaseDeDatosAvanzada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*En primer lugar creamos los datos de tienda y productos ya que no dependen de ninguna otra tabla.
        El numero introducido en el metodo generarDatos() es el número de registros que queremos crear*/
        Tienda tienda = new Tienda();
        tienda.generarDatos(200000);

        Productos p = new Productos();
        p.generarDatos(1000000);
        /* A continuación, generamos los datos de tienda_productos. Para ello creamos el objeto tp al cual le pasamos como variables
      un array con las pk de tiendas y otro array con las pk de productos. En el metodo generarDatos() le introducimos el número
      total de registros que queremos crear. En este caso 100 por cada tienda introducida.
         */
        Tienda_Productos tp = new Tienda_Productos(tienda.getListaTiendas(), p.getListaProductos());
        tp.generarDatos(20000000);
        // En el objeto t de la clase Trabajadores le introducimos como atributo un array con las pk de tienda.

        Trabajador t = new Trabajador(tienda.listaPkTiendas);
        t.generarDatos(1000000);
        //En el objeto tick de la clase Ticket le introducimos como atributo un array con las pk de Trabajadores.
        Ticket tick = new Ticket(t.getListaTrabajadores());
        tick.generarDatos(5000000);
        /*Introducimos como atributos del objeto tickp el array de las pk de tickets y el array de las pk de productos. 
         En el metodo generarDatos() introducimos la cantidad de registro que introducimos en ticket, pero el número de registros
         no será, como ocurre en los casos anteriores, los introducidos sino que seran más y no se podrán predecir ya que se generan
         de forma aleatoria.
         */
        Ticket_Productos tickp = new Ticket_Productos(tick.getListaTickets(), p.getListaProductos());
        tickp.generarDatos(5000000);
    }

}
