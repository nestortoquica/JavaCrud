/*
 Clase donde estbleceremos todos los metodos de Consulta
 */
package Clases;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Consultas extends Conexion {

    //Metodo para insertar/registrar un nuevo elemento en la tabla persona en nuestra Base de Datos
    public boolean registrar(Persona per) {
        PreparedStatement p = null;
        Connection cnx = Conexion();
        //Cadena de consulta a la Base de datos
        String sql = "INSERT INTO persona (Id_persona, Nombre, Apellido, Email, Telefono) VALUES (?,?,?,?,?)";
        try {
            p = cnx.prepareStatement(sql);
            p.setString(1, per.getId_persona());
            p.setString(2, per.getNombre());
            p.setString(3, per.getApellido());
            p.setString(4, per.getEmail());
            p.setString(5, per.getTelefono());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar nueva persona" + e);
            return false;
        } finally { //Cerramos la conexion
            try {
                cnx.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    //Metodo para editar un elemento de la tabla persona en nuestra Base de Datos
    public boolean editar(Persona per) {
        PreparedStatement p = null;
        Connection cnx = Conexion();
        //Cadena de consulta a la Base de datos
        String sql = "UPDATE persona SET Id_persona=?, Nombre=?, Apellido=?, Email=?, Telefono=? WHERE Id=?";
        try {
            p = cnx.prepareStatement(sql);
            p.setString(1, per.getId_persona());
            p.setString(2, per.getNombre());
            p.setString(3, per.getApellido());
            p.setString(4, per.getEmail());
            p.setString(5, per.getTelefono());
            p.setInt(6, per.getId());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al editar el registro" + e);
            return false;
        } finally { //Cerramos la conexion
            try {
                cnx.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    //Metodo para eliminar
    public boolean eliminar(Persona per) {
        PreparedStatement p = null;
        Connection cnx = Conexion();
        //Cadena de consulta a la Base de datos
        String sql = "DELETE FROM persona WHERE Id=?";

        try {
            p = cnx.prepareStatement(sql);
            p.setInt(1, per.getId());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro" + e);
            return false;
        } finally { //Cerramos la conexion
            try {
                cnx.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    //Metodo para buscar
    public boolean consultar(Persona per) {
        PreparedStatement p = null;
        ResultSet rs=null;
        Connection cnx = Conexion();
        //Cadena de consulta a la Base de datos
        String sql = "SELECT * FROM persona WHERE Id_persona=?";
        try {
            p = cnx.prepareStatement(sql);
            p.setString(1, per.getId_persona());
            rs=p.executeQuery();
            if(rs.next()){
                per.setId(Integer.parseInt(rs.getString("Id")));
                per.setId_persona(rs.getString("Id_persona"));
                per.setNombre(rs.getString("Nombre"));
                per.setApellido(rs.getString("Apellido"));
                per.setEmail(rs.getString("Email"));
                per.setTelefono(rs.getString("Telefono"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error al consultar en la base de datos" + e);
            return false;
        } finally { //Cerramos la conexion
            try {
                    cnx.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
            
        }
    }
}
