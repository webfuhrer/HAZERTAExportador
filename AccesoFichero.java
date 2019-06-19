/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportadatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
class AccesoFichero {
static String ruta_salida_csv="D:\\contactos.csv";
static String separador=",";
    static boolean grabarContacto(Contacto c) {
        String aux=c.getNombre()+separador+
                c.getApellido()+separador+c.getEmail()+"\n";
    try {
        FileWriter escritor=new FileWriter(ruta_salida_csv, true);
        escritor.write(aux);
        escritor.close();
        return true;
        
    } catch (IOException ex) {
        Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
        
    }

    static ArrayList<Contacto> recuperarContactos() {
        ArrayList<Contacto> lista_contactos=new ArrayList<>();
    try {
        FileReader fr=new FileReader(ruta_salida_csv);
        BufferedReader br=new BufferedReader(fr);
        String linea=br.readLine();
        while(linea!=null)
        { //pepe,4
            
            String[] datos=linea.split(separador);
            String nombre=datos[0];
            String apellido=datos[1];
            String email=datos[2];
            Contacto c=new Contacto(nombre, apellido, email);
            lista_contactos.add(c);
            linea=br.readLine();
        }
    } catch (IOException ex) {
        Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        
    
    }
    return lista_contactos;
    }

    static int grabarContactos(ArrayList<Contacto> contactos) {
        int i=0;
        for(Contacto x: contactos)
        {
            boolean todo_ok=grabarContacto(x);
            if (todo_ok)
            {
                i++;
            }
            else
            {
                return -1;
            }
        }
        return i;
               
    }
    
}
