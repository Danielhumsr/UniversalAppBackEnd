package UniversalApp.GestionModulos.Controller;

import UniversalApp.GestionModulos.Model.Modulo;
import UniversalApp.GestionModulos.Service.IModuloService;
import UniversalApp.Global.DTO.ObjetListResponseDTO;
import UniversalApp.Global.DTO.ObjetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ModuloController {
    @Autowired
    IModuloService moduloService;


    public ResponseEntity ListarModulos(){
        List<Modulo> modulos = moduloService.listarModulos();
        ObjetListResponseDTO response = new ObjetListResponseDTO("OK", Collections.singletonList(modulos));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
