package patrondiseno.manejo01jdbc.datos;

import patrondiseno.manejo01jdbc.domain.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {

    public List<PersonaDTO> select() throws SQLException;

    public int insert(PersonaDTO personaDTO) throws SQLException;

    public int update(PersonaDTO personaDTO) throws SQLException;

    public int delete(PersonaDTO personaDTO) throws SQLException;

}
