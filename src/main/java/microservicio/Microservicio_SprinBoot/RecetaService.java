package microservicio.Microservicio_SprinBoot;

import java.util.List;

public interface RecetaService {

    // GET - obtener todas las recetas
    List<Recetas> obtenerRecetas();

    // GET - obtener una receta por id
    Recetas obtenerPorId(Long id);

    // POST - crear receta
    Recetas crearReceta(Recetas receta);

    // PUT - actualizar receta
    Recetas actualizarReceta(Long id, Recetas recetaActualizada);

    // DELETE - borrar receta
    void eliminarReceta(Long id);
}
