/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosavanzada;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Ticket {

    ArrayList<String> listaTrabajadores;
    ArrayList<String> listaPkTicket = new ArrayList<String>();

    ;

    public Ticket(ArrayList<String> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
public String fechaAleatoria(){
    String fecha;   
    GregorianCalendar gc = new GregorianCalendar();
        int year = 2019;
        gc.set(gc.YEAR, year);
        int dayOfYear = 1 + (int)Math.round(Math.random() * ( gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        
    return fecha = gc.get(gc.DAY_OF_MONTH)+ "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.YEAR)   ;
}
    public void generarDatos(int numeroRegistros) throws IOException {
        int contador = 1;
        FileWriter escribir = new FileWriter("datos_ticket.txt", true);
        Random rand = new Random();
        int min = 100;
        int max = 10000;
        while (contador <= numeroRegistros) {
            String aux = Integer.toString(contador);
            listaPkTicket.add(aux);
            escribir.write(aux + ";" +(rand.nextInt((max - min) + 1) + min)+";"+ fechaAleatoria() + ";" + listaTrabajadores.get(rand.nextInt(listaTrabajadores.size())));
            escribir.write("\r\n");
            contador += 1;
        }
        escribir.close();
    }

    public ArrayList getListaTickets() {
        return listaPkTicket;
    }
}
