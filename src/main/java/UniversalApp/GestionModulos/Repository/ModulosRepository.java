package UniversalApp.GestionModulos.Repository;

import UniversalApp.GestionModulos.Model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulosRepository extends JpaRepository<Modulo, Long> {
}
