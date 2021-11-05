package manejo00jdbc.datos;

import manejo00jdbc.domain.Persona00;
import java.sql.*;
import java.util.*;

public class PersonaJDBC {

    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona;";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido= ?, email= ?, telefono = ? WHERE id_persona = ?;";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?;";

    public PersonaJDBC() {
    }

    public PersonaJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona00> seleccionar() throws SQLException {
        Connection conn = null;
        /* PreparedStatement tiene más eficiencia para trabajar con querys */
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona00 persona = null;
        List<Persona00> personas = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion00.getConection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona00(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } finally {
            try {
                Conexion00.close(rs);
                Conexion00.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion00.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(Persona00 persona) throws SQLException {
       Connection conn = null;
       PreparedStatement stmt = null;
       int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion00.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Conexion00.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion00.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public int actualizar(Persona00 persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion00.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Conexion00.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion00.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public int eliminar(Persona00 persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion00.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Conexion00.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion00.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }
}
