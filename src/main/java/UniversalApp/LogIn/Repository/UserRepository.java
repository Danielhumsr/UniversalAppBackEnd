package UniversalApp.LogIn.Repository;

import UniversalApp.LogIn.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findUsersByUsername(String username);

}
