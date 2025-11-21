package microservicio.Microservicio_SprinBoot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecetaServiceImpl implements RecetaService {

    @Override
    public List<Recetas> obtenerRecetas() {
        return JsonUtil.leerRecetas();
    }

    @Override
    public Recetas obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    public Recetas crearReceta(Recetas receta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearReceta'");
    }

    @Override
    public Recetas actualizarReceta(Long id, Recetas recetaActualizada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarReceta'");
    }

    @Override
    public void eliminarReceta(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarReceta'");
    }
}
