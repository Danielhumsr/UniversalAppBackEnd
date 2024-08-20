package UniversalApp.GestionModulos.Service;

import UniversalApp.GestionModulos.Model.Modulo;
import UniversalApp.GestionModulos.Repository.ModulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService implements IModuloService {

    @Autowired
    ModulosRepository modulosRepository;


    public List<Modulo> listarModulos() {
        return modulosRepository.findAll();
    }
}
