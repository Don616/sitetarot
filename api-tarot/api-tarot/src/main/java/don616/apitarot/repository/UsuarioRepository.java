package don616.apitarot.repository;

import don616.apitarot.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByGenero(Character genero);
    Optional<Usuario> findByDataNascimento(Character dataNascimento);


}