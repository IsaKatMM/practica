package microservicio.Microservicio_SprinBoot;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin("*")   // Para evitar problemas de CORS
public class RecetasController {

    private final RecetaService recetaService;

    public RecetasController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    // GET - Obtener todas las recetas
    @GetMapping
    public List<Recetas> obtenerRecetas() {
        return recetaService.obtenerRecetas();
    }

    // POST - Crear una nueva receta
    @PostMapping
    public Recetas crearReceta(@RequestBody Recetas receta) {
        return recetaService.crearReceta(receta);
    }

    // PUT - Actualizar una receta por ID
    @PutMapping("/{id}")
    public Recetas actualizarReceta(@PathVariable Long id, @RequestBody Recetas receta) {
        return recetaService.actualizarReceta(id, receta);
    }

    // DELETE - Eliminar una receta por ID
    @DeleteMapping("/{id}")
    public String eliminarReceta(@PathVariable Long id) {
        recetaService.eliminarReceta(id);
        return "Receta eliminada con éxito";
    }
}
