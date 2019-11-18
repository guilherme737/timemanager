package br.com.guiga.ecxus.timemanager.ponto;

import br.com.guiga.ecxus.infra.entity.Ponto;
import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.timemanager.geral.ApiContants;
import br.com.guiga.ecxus.timemanager.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiContants.PONTO)
public class PontoApi {

    @Autowired
    private PontoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void salvar(final PontoDto pontoDto) {
        Optional<Usuario> usuario = usuarioRepository.findById(pontoDto.getCodigoDoUsuario());
        Ponto ponto = new Ponto(pontoDto.getData(), pontoDto.getHorasTrabalhadas(), usuario.get());
        this.repository.save(ponto);
    }

    @PutMapping("/{pontoId}")
    public void alterar(@PathVariable("pontoId") final Long pontoId, @RequestBody final PontoDto pontoDto) {
        Optional<Usuario> usuario = usuarioRepository.findById(pontoDto.getCodigoDoUsuario());
        Ponto ponto = this.repository.findById(pontoId).get();
        ponto.setData(pontoDto.getData());
        ponto.setHorasTrabalhadas(pontoDto.getHorasTrabalhadas());
        this.repository.save(ponto);
    }

    @DeleteMapping("/{pontoId}")
    public void excluir(@PathVariable final Long pontoId) {
        this.repository.deleteById(pontoId);
    }
}
