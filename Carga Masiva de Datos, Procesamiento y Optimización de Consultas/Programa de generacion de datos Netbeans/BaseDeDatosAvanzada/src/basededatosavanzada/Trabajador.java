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
public class Trabajador {

    ArrayList<String> listaTienda;
    ArrayList<String> listaPkTrabajadores = new ArrayList<String>();

    ;

    public Trabajador(ArrayList<String> listaTienda) {
        this.listaTienda = listaTienda;
    }
private char calcularLetra(int dni){
          char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
          int resto = dni%23;
          return caracteres[resto];
     }
    public void generarDatos(int numeroRegistros) throws IOException {
        int contador = 1;
        FileWriter escribir = new FileWriter("datos_trabajadores.txt", true);
        Random rand = new Random();
        int min = 1000;
        int max = 5000;
        int numdni;
        String dni = null;
        ArrayList<String> listaDNI= new ArrayList<String>();
        while (listaDNI.size()<=numeroRegistros){
        numdni = rand.nextInt(99999999);
        dni= Integer.toString(numdni)+ calcularLetra(numdni);
        if(!listaDNI.contains(dni)){
            listaDNI.add(dni);
        }
        }
        while (contador <= numeroRegistros) {
            String aux = Integer.toString(contador);
            listaPkTrabajadores.add(aux);
            escribir.write(aux + ";" + listaDNI.get(contador-1)+ ";" + "nombre" + aux + ";" + "apellidos" + aux + ";" + "puesto" + aux + ";" + (rand.nextInt((max - min) + 1)
                    + min) + ";" + listaTienda.get(rand.nextInt(listaTienda.size())));
            escribir.write("\r\n");
            contador += 1;
        }
        escribir.close();
    }

    public ArrayList getListaTrabajadores() {
        return listaPkTrabajadores;
    }

}
