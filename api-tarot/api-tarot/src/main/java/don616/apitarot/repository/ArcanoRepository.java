package don616.apitarot.repository;

import don616.apitarot.entity.ArcanoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArcanoRepository extends JpaRepository<ArcanoEntity,Integer> {

    ArcanoEntity findByNumero(Integer numero);

    List<ArcanoEntity> findByNomeContains(String nome);

    List<ArcanoEntity> findByCategoriaContains(String value);


    List<ArcanoEntity> findByNomeContainsAndCategoriaContains(String nome, String categoria);

    List<ArcanoEntity> findByNaipeContains(String naipe);


    List<ArcanoEntity> findByLetraHebraicaContains(String letraHebraica);

    List<ArcanoEntity> findByRunaNordicaContains(String runaNordica);

    List<ArcanoEntity> findByCorrespondenciaAstrologicaContains(String correspondenciaAstrologica);


    List<ArcanoEntity> findByCorrespondenciaAstrologicaContainsAndCategoriaContains(String correspondenciaAstrologica, String categoria);

    List<ArcanoEntity> findByCorrespondenciaAstrologicaContainsAndNaipeContains(String correspondenciaAstrologica, String naipe);

    List<ArcanoEntity> findByTituloContains(String titulo);


}
