package don616.apitarot.repository;

import don616.apitarot.model.entity.Arcano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArcanoRepository extends JpaRepository<Arcano,Integer> {
    Arcano findByNumero(Integer numero);
}
