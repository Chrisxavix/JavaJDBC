package patrondiseno.manejo01jdbc.test;

import patrondiseno.manejo01jdbc.datos.Conexion01;
import patrondiseno.manejo01jdbc.datos.PersonaDAOJDBC;
import patrondiseno.manejo01jdbc.datos.PersonaDao;
import patrondiseno.manejo01jdbc.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas01 {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion01.getConection();
            /* Para que la conexión no haga autocomit/commit automáticamente */
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDao personaDao = new PersonaDAOJDBC(conexion);
            List<PersonaDTO> personas = personaDao.select();
            for(PersonaDTO persona: personas) {
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
