package manejojdbc.datos;

import manejojdbc.domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* DAO: Patrón de Diseño, Data Access Object */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona;";

    public List<Persona> seleccionar() {
        Connection conn = null;
        /* PreparedStatement tiene más eficiencia para trabajar con querys */
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persoona = null;
        List<Persona> personas = new ArrayList<>();
        /* https://www.udemy.com/course/universidad-java-especialista-en-java-desde-cero-a-master/learn/lecture/21401192#content */
        return null;
    }
}
