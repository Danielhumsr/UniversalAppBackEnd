package UniversalApp.LogIn.Service;

import UniversalApp.LogIn.Model.User;
import UniversalApp.LogIn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listarUsuarios(){
        return(List<User>) userRepository.findAll();
    }

    public List<User> logInUser(String username){
        return(List<User>) userRepository.getUserByUsername(username);
    }


}
