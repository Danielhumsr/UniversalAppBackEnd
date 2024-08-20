package UniversalApp.GestionModulos.Service;

import UniversalApp.GestionModulos.Model.Modulo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IModuloService {

    List<Modulo> listarModulos();
}
