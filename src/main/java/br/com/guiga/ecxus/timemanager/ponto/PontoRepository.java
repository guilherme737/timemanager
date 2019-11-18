package br.com.guiga.ecxus.timemanager.ponto;

import br.com.guiga.ecxus.infra.entity.Ponto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long> {
}
