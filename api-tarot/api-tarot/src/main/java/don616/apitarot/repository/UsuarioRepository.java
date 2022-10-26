package don616.apitarot.repository;

import don616.apitarot.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    Optional<UsuarioEntity> findByEmail(String email);
    Optional<UsuarioEntity> findByNome(String nome);
    Optional<UsuarioEntity> findByGenero(Character genero);
    Optional<UsuarioEntity> findByDataNascimento(Character dataNascimento);


}
