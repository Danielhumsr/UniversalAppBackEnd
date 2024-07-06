package UniversalApp.LogIn.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASWORD")
    private String password;
}
