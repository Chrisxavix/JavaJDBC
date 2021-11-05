package manejo00jdbc.test;

import manejo00jdbc.datos.*;
import manejo00jdbc.domain.Persona00;
import java.sql.*;

public class TestManejoPersonas00 {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion00.getConection();
            /* Para que la conexión no haga autocomit/commit automáticamente */
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            /* Usando los setters, en vez de los constructores:
               Persona00 persona = new Persona00(1, "Chris", "Punk", "wos@gamil.com", "5644"); */
            Persona00 personaActualizar = new Persona00();
            personaActualizar.setIdPersona(2);
            personaActualizar.setNombre("Chris");
            personaActualizar.setApellido("Daniels");
            personaActualizar.setEmail("cdan@gmail.com");
            personaActualizar.setTelefono("789456");
            /* Actualizar */
            personaJDBC.actualizar(personaActualizar);

            Persona00 personaInsertar = new Persona00();
            personaInsertar.setNombre("Gazir");
            personaInsertar.setApellido("Mc");
            personaInsertar.setEmail("gazir@gmail.com");
            personaInsertar.setTelefono("12345");
            /* Insertar */
            personaJDBC.insertar(personaInsertar);

            /* Si todo está bien se hace el commit */
            conexion.commit();
            System.out.println("Se realizó el commit correctamente");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Ingresa a rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
