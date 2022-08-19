
package Tienda.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    //metodo para conectar a la database
    protected void conectarBase() throws ClassNotFoundException, SQLException{
        try {//intenta hacer el siguiente bloque de codigo, si falla ejecuta el catch
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false"; 
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    //metodo para desconectar de la base de datos
    protected void desconectarBase() throws Exception{
     //Si al desconectar alguno NO esta vacio, lo cierra
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //metodo para cambiar la base de datos
    protected void insertarModificarEliminar(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();//prepara la sentencia
            sentencia.executeUpdate(sql);//ejecuta la sentencia SQL enviada por parametro
        } catch (SQLException | ClassNotFoundException e) {
            //conexion.rollback(); 
            //El rollback omite todo lo hecho en caso de que el catch atrape una excepcion
            System.out.println(e.toString());
        }finally{
            desconectarBase();
        }
    }
    //metodo para consultar con SELECT en la base de datos
    protected void consultarBase(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
}
