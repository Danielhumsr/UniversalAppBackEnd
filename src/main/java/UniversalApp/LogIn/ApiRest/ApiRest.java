package UniversalApp.LogIn.ApiRest;

import UniversalApp.LogIn.Controller.UserController;
import UniversalApp.LogIn.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    //URL: /logIn/logIn?userLogin=angee
    @GetMapping("/logIn")
    public User logIn(@RequestParam String userLogin){
       return userController.Login(userLogin);
    }

    //URL: /logIn/insertarUsuario
    @PostMapping("/insertarUsuario")
    public String insertarUsuario(@RequestBody User user){
       User newUser = new User();
       newUser =  userController.saveUser(user);
       return newUser.toString();
    }
}
