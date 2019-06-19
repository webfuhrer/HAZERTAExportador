/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportadatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
class AccesoBD {
static String ruta_mysql="jdbc:mysql://localhost:3306/bd_agenda";
static String usuario="root";
static String password="";
static Connection c=null;
static void conectar()
{
    try {
        c=DriverManager.getConnection(ruta_mysql, usuario, password);
    } catch (SQLException ex) {
        Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    static boolean grabarContacto(Contacto x) {
        String nombre=x.getNombre();
        String apellido=x.getApellido();
        String email=x.getEmail();
        String sql="INSERT INTO contactos VALUES(1, '"+nombre+"', '"+apellido+"', '"+email+"')";
    try {
        //INSERT INTO contactos VALUES ('pepe', 'perez','pepe@mail.com')
        
        Statement stmt=c.createStatement();
        stmt.executeUpdate(sql);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex);
        
    }
 
 
    return false;
      
    }

    static ArrayList<Contacto> recuperarContactos(String contacto_buscado) {
        //Si el contacto_buscado es null, el usuario quiere TODOS los contactos.
        //Si contacto_buscado es distinto de null, el usuario quiere solo los que se llamen así
        
        String sql=null;
        if (contacto_buscado==null)
        {
            sql="SELECT * FROM contactos";
        }
        else
        {
            sql="SELECT * FROM contactos WHERE nombre='"+contacto_buscado+"'";
        }
        
        ArrayList<Contacto> lista_contactos=null;
    try {
        
        lista_contactos=new ArrayList();
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next())
        {
            String nombre=rs.getString("nombre");
            String apellido=rs.getString("apellido");
            String email=rs.getString("email");
            Contacto c=new Contacto(nombre, apellido, email);
            lista_contactos.add(c);
        }
        } catch (SQLException ex) {
        Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
    }
        return lista_contactos;
    }

    static int grabarContactos(ArrayList<Contacto> lista) {
        int i=0;
        for (Contacto c : lista) {
            boolean todo_ok=grabarContacto(c);
            if(todo_ok)
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
