package UniversalApp.LogIn.Controller;

import UniversalApp.LogIn.Model.User;
import UniversalApp.LogIn.Service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    IUserService userService;

    public List<User> ListarUsuarios(){
        List<User> ListaUsusarios = new ArrayList<>();
        ListaUsusarios = userService.listarUsuarios();
        System.out.println(ListaUsusarios);
        return ListaUsusarios;
    }

    public User Login(String loginuser){
        List<User> ListaUsusarios = ListarUsuarios();
        User userE = new User();
        ListaUsusarios = userService.logInUser(loginuser);
        ListaUsusarios.forEach((user) -> {
            System.out.println(user);
            System.out.println(user.getUsername().equals(loginuser));
            if(user.getUsername().equals(loginuser) ){
                userE.setUsername(user.getUsername());
                userE.setPassword(user.getPassword());
            }
        });
        return userE;
    }
}
