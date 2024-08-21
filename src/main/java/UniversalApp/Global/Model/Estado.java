package UniversalApp.Global.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ESTADO")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Estado {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ESTADO")
    private String estado;


}
