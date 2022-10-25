package don616.apitarot.repository;

import don616.apitarot.entity.Arcano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArcanoRepository extends JpaRepository<Arcano,Integer> {

    Arcano findByNumero(Integer numero);

    List<Arcano> findByNomeContains(String nome);

    List<Arcano> findByCategoriaContains(String value);


    List<Arcano> findByNomeContainsAndCategoriaContains(String nome, String categoria);

    List<Arcano> findByNaipeContains(String naipe);


    List<Arcano> findByLetraHebraicaContains(String letraHebraica);

    List<Arcano> findByRunaNordicaContains(String runaNordica);

    List<Arcano> findByCorrespondenciaAstrologicaContains(String correspondenciaAstrologica);


    List<Arcano> findByCorrespondenciaAstrologicaContainsAndCategoriaContains(String correspondenciaAstrologica, String categoria);

    List<Arcano> findByCorrespondenciaAstrologicaContainsAndNaipeContains(String correspondenciaAstrologica, String naipe);

    List<Arcano> findByTituloContains(String titulo);


}
