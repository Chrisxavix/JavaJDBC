package manejojdbc.test;

import manejojdbc.datos.PersonaDAO;
import manejojdbc.domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        /* Insertar datos a la base */
        /*System.out.println("Agregar datos a la BD");
        Persona personaInsert = new Persona("Franklin", "Gta", "franklin@gmail.com", "211324");
        int registro = personaDao.insertar(personaInsert);
        System.out.println("Registro: " + registro);*/

        /* Actualizar los datos */
        /*System.out.println("Actualizar datos a la BD");
        Persona personaUpdate = new Persona(4, "Cr7", "Manchester", "cr7manchester@gmail.com", "2480333");
        int registroUpdate = personaDao.actualizar(personaUpdate);
        System.out.println("Registro: " + registroUpdate);*/

        /* Eliminar datos */
        /*System.out.println("Eliminar datos a la BD");
        Persona personaDelete = new Persona(5);
        int registroDelete = personaDao.eliminar(personaDelete);
        System.out.println("Registro: " + registroDelete);*/

        /* Ver los datos creados */
        System.out.println("Consultar datos a la BD");
        List<Persona> personas = personaDao.seleccionar();
        /* Foreach */
        for (Persona persona: personas ) {
            System.out.println("Persona: " + persona);
        }
        /* Items */
        System.out.println("Nombre: " + personas.get(0).getNombre());
        System.out.println("Teléfono: " + personas.get(0).getTelefono());
    }
}
