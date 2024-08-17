package UniversalApp.GestionModulos.ApiRest;

import UniversalApp.LogIn.DTO.ObjetResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials= "true")
@RestController
@RequestMapping(value = "/prueba", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestModulos {

    // url: /prueba/prueba
    @GetMapping("/prueba")
    public ResponseEntity prueba() {
        return new ResponseEntity<>(new ObjetResponseDTO("paso La Prueba", null), HttpStatus.OK);
    }

}
