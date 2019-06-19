/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportadatos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
class EntradaSalida {
static final int INSERTAR=1;
static final int MYSQL2CSV=1;
static final int CSV2MYSQL=2;
static final int SALIR=3;

    static int mostrarMenu() {
        Scanner sc=new Scanner(System.in);
        System.out.println(MYSQL2CSV+"-Exportar de MySQL a CSV");
        System.out.println(CSV2MYSQL+"-Expotar de CSV a MySQL");
 
        System.out.println(SALIR+"-Salir");
        int opcion=sc.nextInt();
        return opcion;
    }

   
    static String pedirNombreUsuario()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nombre");
        String nombre=sc.nextLine();
        return nombre;
    }

   
    static Contacto pedirContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nombre:");
        String nombre=sc.nextLine();
        System.out.println("Introduzca el apellido:");
        String apellido=sc.nextLine();
        System.out.println("Introduzca el email:");
        String email=sc.nextLine();
        Contacto c=new Contacto(nombre, apellido, email);
        return c;
        
        
    }

    static void mostrarContactos(ArrayList<Contacto> lista) {
        if (lista.size()==0)
        {
            System.out.println("No se han encontrado datos");
        }
        else
        {
            for(Contacto c: lista)
            {
                System.out.println(c);
            }
        }
    }
    
}