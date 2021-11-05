package poolconexiones.manejo01jdbc.datos;

import poolconexiones.manejo01jdbc.domain.PersonaDTO02;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao02 {

    public List<PersonaDTO02> select() throws SQLException;

    public int insert(PersonaDTO02 personaDTO02) throws SQLException;

    public int update(PersonaDTO02 personaDTO02) throws SQLException;

    public int delete(PersonaDTO02 personaDTO02) throws SQLException;

}
