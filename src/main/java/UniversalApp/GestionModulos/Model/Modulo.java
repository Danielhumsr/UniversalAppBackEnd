package UniversalApp.GestionModulos.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODULOS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Modulo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE_MODULO")
    private String nombreModulo;

    @Column(name = "DESCRIPCION_MODULO")
    private String descripcionModulo;

    @Column(name = "URL")
    private String url;
}
