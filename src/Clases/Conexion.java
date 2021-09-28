//Clase para conectar a la Base de Datos
package Clases;

//Librerias necesarias para la conexion
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Objeto de la clase Connection
    private static Connection cnx;
    //Cadena para hacer referencia al Driver importado de conexion con MySql
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    //Usuario en motor de Base de datos
    private static final String user = "root";
    /*Password en motor de Base de datos, sino tienen password 
    se debe hacer la referencia igualmente con el campo vacio (password="")*/
    private static final String password = "admin";
    //Referencia alojamiento de Base de datos
    /*  jdbc:mysql: - Uso del driver  */
    /* //localhost:3306 - Puerto con el cual ahremos la conexion al servidor local */
    /* /nombrebase - Nombre de la base de datos creada */
    private static final String url = "jdbc:mysql://localhost:3306/personas?serverTimezone=UTC";

    
    /*Metodo contructor para capturar error si hay error en codigo de conexion*/
    public Connection Conexion() {
        cnx = null;
        //Para capturar erorr en codigo de conexion
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, password);
            if (cnx != null) {
                System.out.println("Conexion Exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }
        return cnx;
    }

}
