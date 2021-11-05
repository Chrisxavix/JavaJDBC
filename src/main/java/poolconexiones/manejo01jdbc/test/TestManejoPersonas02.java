package poolconexiones.manejo01jdbc.test;

import poolconexiones.manejo01jdbc.datos.Conexion02;
import poolconexiones.manejo01jdbc.datos.PersonaDAOJDBC02;
import poolconexiones.manejo01jdbc.datos.PersonaDao02;
import poolconexiones.manejo01jdbc.domain.PersonaDTO02;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas02 {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion02.getConection();
            /* Para que la conexión no haga autocomit/commit automáticamente */
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDao02 personaDao02 = new PersonaDAOJDBC02(conexion);
            List<PersonaDTO02> personas = personaDao02.select();
            for(PersonaDTO02 persona: personas) {
                System.out.println("Persona: " + persona);
            }
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
