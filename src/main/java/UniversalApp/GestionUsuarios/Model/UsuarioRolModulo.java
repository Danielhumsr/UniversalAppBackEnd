package UniversalApp.GestionUsuarios.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIO_ROL_MODULO")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UsuarioRolModulo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ID_USUARIO")
    private long idUsuario;

    @Column(name = "ID_ROL")
    private long idRol;

    @Column(name = "ID_MODULO")
    private long idModulo;
}
