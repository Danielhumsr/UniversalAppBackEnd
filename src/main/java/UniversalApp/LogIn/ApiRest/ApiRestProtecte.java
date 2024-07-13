package UniversalApp.LogIn.ApiRest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/module/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestProtecte {

    @GetMapping("/listar")
    public String listar() {
        return "Lista de usuarios";
    }
}
