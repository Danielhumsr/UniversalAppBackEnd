package UniversalApp.LogIn.Service;

import UniversalApp.LogIn.Model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserService {
    List<User> listarUsuarios();
    User getUserByUsername(String username);
    User saveUser(User user);
}
