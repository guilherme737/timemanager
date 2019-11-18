package br.com.guiga.ecxus.timemanager.usuario;

import br.com.guiga.ecxus.infra.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);
    Boolean existsByLogin(String login);
}
