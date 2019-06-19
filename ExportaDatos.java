/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportadatos;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ExportaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion=EntradaSalida.mostrarMenu();
        AccesoBD.conectar();
        while(opcion!=EntradaSalida.SALIR)
        {
            switch (opcion)
            {
                case EntradaSalida.CSV2MYSQL:
                    ArrayList<Contacto> lista=AccesoFichero.recuperarContactos();
                    int numero_registros=AccesoBD.grabarContactos(lista);
                    System.out.println("Se han grabado "+numero_registros+" regisros en MySQL");
                    break;
                case EntradaSalida.MYSQL2CSV:
                    ArrayList<Contacto> contactos=AccesoBD.recuperarContactos(null);
                    int n_registros=AccesoFichero.grabarContactos(contactos);
                    System.out.println("Se han grabado "+n_registros+" registros en el fichero");
                    break;
                    
                    
            }
            opcion=EntradaSalida.mostrarMenu();
        }
    }
    
}
