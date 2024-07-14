package UniversalApp.LogIn.ApiRest;

import UniversalApp.LogIn.Controller.UserController;
import UniversalApp.LogIn.DTO.ObjetResponseDTO;
import UniversalApp.LogIn.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials= "true")
@RestController
@RequestMapping(value = "/module/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestProtecte {

    @Autowired
    UserController userController;

    // url: /module/user/listar
    @GetMapping("/listar")
    public ResponseEntity listar() {
        return userController.ListarUsuarios();
    }

    // url: /module/user/listar
    @GetMapping("/prueba")
    public ResponseEntity prueba() {
        return new ResponseEntity<>(new ObjetResponseDTO("paso La Prueba", null), HttpStatus.OK);
    }

    // URL: /module/user/ValidateToken
    @PostMapping("/ValidateToken")
    public ResponseEntity validateToken(@RequestBody User user) {
        System.out.println(user.getUsername()+"-------------------------------------------------------");
        ObjetResponseDTO responseDTO = new ObjetResponseDTO("Token Valido", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
