package UniversalApp.LogIn.Repository;

import UniversalApp.LogIn.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

    List<User> getUserByUsername(String username);
}
