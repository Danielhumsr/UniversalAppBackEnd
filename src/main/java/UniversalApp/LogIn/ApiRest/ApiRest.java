package UniversalApp.LogIn.ApiRest;

import UniversalApp.LogIn.Controller.UserController;
import UniversalApp.LogIn.DTO.ErrorDTO;
import UniversalApp.LogIn.DTO.ResponseDTO;
import UniversalApp.LogIn.Model.User;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//https://www.baeldung.com/spring-cors
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/logIn", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRest {
    @Autowired
    UserController userController;

    //URL: /logIn/listar
   @GetMapping("/listar")
    public List<User> listar(){
       return userController.ListarUsuarios();
    }

    //URL: /logIn/prueba
    @PostMapping("/prueba")
    public ResponseEntity prueba(@RequestBody User user){
       if(user.getPassword().equals("true")){
           return new ResponseEntity<>(user, HttpStatus.OK);
       }else{
           ErrorDTO errorDTO = new ErrorDTO();
           List<String> errors = new ArrayList<>();
           errors.add("Ususario o contraseña invalidos");
           errorDTO.setError(errors);
           return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
       }
    }

    //URL: /logIn/logIn
    @PostMapping("/logIn")
    public ResponseEntity logIn(@RequestBody User userLogin){
       ResponseDTO response = new ResponseDTO();
       response = userController.Login(userLogin);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //URL: /logIn/insertarUsuario
    @PostMapping("/insertarUsuario")
    public ResponseEntity insertarUsuario(@RequestBody User user){
       ResponseDTO response = new ResponseDTO();

        response =  userController.saveUser(user);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
