package UniversalApp.LogIn.Service;

import UniversalApp.LogIn.Model.User;

import java.util.List;

public interface IUserService {
    List<User> listarUsuarios();
    List<User> logInUser(String username);
    User saveUser(User user);
}
