package UniversalApp.LogIn.Controller;

import UniversalApp.LogIn.DTO.ResponseDTO;
import UniversalApp.LogIn.Model.User;
import UniversalApp.LogIn.Security.JwtService;
import UniversalApp.LogIn.Service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    JwtService jwtService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    AuthenticationManager authenticationManager;


    public List<User> ListarUsuarios(){
        List<User> ListaUsusarios = new ArrayList<>();
        ListaUsusarios = userService.listarUsuarios();
        return ListaUsusarios;
    }

    public ResponseDTO saveUser(User user){
        User newUser = user;
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            newUser = userService.saveUser(newUser);
            String token= jwtService.getToken(user);
            ResponseDTO response = new ResponseDTO(token);
            return response;
        }catch (Exception e){
            return  new ResponseDTO(e.getMessage());

        }



    }

    public ResponseDTO Login(User loginuser) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginuser.getUsername(), loginuser.getPassword()));
            UserDetails user=userService.getUserByUsername(loginuser.getUsername());
            String token=jwtService.getToken(user);
            return new ResponseDTO(token);
        }catch(Exception e) {
            System.out.println(e);
            return new ResponseDTO(e.getMessage());
        }



    }
}
