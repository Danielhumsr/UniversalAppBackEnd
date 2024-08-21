package UniversalApp.GestionModulos.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODULO_ROL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ModuloRol {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_MODULO")
    private long idModulo;

    @Column(name = "ID_ROL")
    private long idrol;
}
