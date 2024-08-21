package UniversalApp.GestionModulos.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ROL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Rol {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE_ROL")
    private String nombreRol;

    @Column(name = "DESCRIPCION")
    private String descripcionRol;
}
