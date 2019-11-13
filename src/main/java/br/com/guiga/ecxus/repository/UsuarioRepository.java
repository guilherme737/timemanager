package br.com.guiga.ecxus.repository;

import br.com.guiga.ecxus.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
