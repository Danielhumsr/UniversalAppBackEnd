package UniversalApp.LogIn.Controller;

import UniversalApp.Global.DTO.ObjetListResponseDTO;
import UniversalApp.Global.DTO.ObjetResponseDTO;
import UniversalApp.LogIn.Model.User;
import UniversalApp.LogIn.Security.JwtService;
import UniversalApp.LogIn.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public ResponseEntity ListarUsuarios(){
        List<User> listaUsusarios = new ArrayList<>();
        listaUsusarios = userService.listarUsuarios();
        ObjetListResponseDTO objetListResponseDTO = new ObjetListResponseDTO("OK", Collections.singletonList(listaUsusarios));
        return  new ResponseEntity<>(objetListResponseDTO, HttpStatus.OK);
    }

    public ResponseEntity saveUser(User user){
        User newUser = user;
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            newUser = userService.saveUser(newUser);
            String token= jwtService.getToken(newUser);
            ObjetResponseDTO response = new ObjetResponseDTO(token, user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  new ResponseEntity<>(new ObjetResponseDTO("Problemas con el servicio", null) , HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity Login(User loginuser) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginuser.getUsername(), loginuser.getPassword()));
            UserDetails user=userService.getUserByUsername(loginuser.getUsername());
            String token=jwtService.getToken(user);
            ObjetResponseDTO response =  new ObjetResponseDTO(token, loginuser);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ObjetResponseDTO("Problemas para hacer el LogIn", null) , HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity ValidateToken(String tokenRequiest) {
        User user = new User();
        String token = tokenRequiest.substring(7);
        String userFronToken = jwtService.getUsernameFromToken(token);
        //System.out.println(userFronToken+"------------------- Usuario from Token");
        user.setUsername(userFronToken);
        ObjetResponseDTO response =  new ObjetResponseDTO("Token Valido", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
