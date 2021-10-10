package test;

import java.sql.*;

public class TestMysqlJDBC {
    public static void main(String[] args) {
        /* Enlace para la conexión */
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona;";
            ResultSet resultado = instruccion.executeQuery(sql);
            /* El .next indica si todavía tiene elementos a iterar */
            while(resultado.next()) {
                System.out.println("Id Persona: " + resultado.getInt("id_persona"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Email: " + resultado.getString("email"));
                System.out.println("Telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
