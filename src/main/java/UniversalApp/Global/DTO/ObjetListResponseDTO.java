package UniversalApp.Global.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ObjetListResponseDTO {

    String respuesta;

    List<Object> ListaObjetoRespuesta;
}
