/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosavanzada;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Tienda {
 ArrayList<String> listaPkTiendas = new ArrayList<String>();
    ArrayList<String> listaProvincias = new ArrayList<String>(Arrays.asList("Alava","Albacete","Alicante","Almeria","Asturias","Avila","Badajoz","Barcelona","Burgos","Caceres","Cadiz","Cantabria","Castellon","Ceuta","Ciudad Real", "Cordoba","Cuenca","Gerona","Granada","Guadalajara","Guipuzcua","Huelva","Huesca","Isla Baleares","Jaen","La Coruña", "La Rioja","Las Palmas","Leon","Lerida","Lugo","Madrid","Malaga","Melilla","Murcia","Navarra","Orense","Palencia","Pontevedra","Salamanca","Segovia","Sevilla","Soria","Tarragona","Tenerife","Teruel","Toledo","Valencia","Valladoliz","Vizcaya","Zamora","Zaragoza"));
    public Tienda() {
      
    }
 public void generarDatos(int numeroRegistros) throws IOException{
        int contador = 1;
        FileWriter escribir = new FileWriter("datos_tienda.txt", true);
        Random rand= new Random();
        while (contador <= numeroRegistros) {
            String aux = Integer.toString(contador);
             listaPkTiendas.add(aux);
            escribir.write(aux + ";" + "nombre" + aux + ";" + "ciudad" + aux + ";" + "barrio" + aux + ";" + listaProvincias.get(rand.nextInt(listaProvincias.size())));
            escribir.write("\r\n"); 
            contador+=1;
        }
        escribir.close();
    }

    public ArrayList getListaTiendas() {
        return listaPkTiendas;
    }
 
}
