package UniversalApp.LogIn.ApiRest;

import UniversalApp.LogIn.Controller.UserController;
import UniversalApp.LogIn.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//https://www.baeldung.com/spring-cors
@CrossOrigin(origins = "http://localhost:3000", allowCredentials= "true")
@RestController
@RequestMapping(value = "/logIn", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestLogIn {
    @Autowired
    UserController userController;

    //URL: /logIn/listar
   @GetMapping("/listar")
    public ResponseEntity listar(){
       return userController.ListarUsuarios();
    }

    //URL: /logIn/prueba
    @PostMapping("/prueba")
    public ResponseEntity prueba(@RequestBody String prueba){
           return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    //URL: /logIn/logIn
    @PostMapping("/logIn")
    public ResponseEntity logIn(@RequestBody User userLogin){
       return userController.Login(userLogin);
    }

    //URL: /logIn/insertarUsuario
    @PostMapping("/insertarUsuario")
    public ResponseEntity insertarUsuario(@RequestBody User user){
       return  userController.saveUser(user);
    }
}
