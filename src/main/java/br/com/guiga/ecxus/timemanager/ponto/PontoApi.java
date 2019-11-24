package br.com.guiga.ecxus.timemanager.ponto;

import br.com.guiga.ecxus.infra.entity.Ponto;
import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.timemanager.geral.ApiContants;
import br.com.guiga.ecxus.timemanager.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(ApiContants.PONTO)
public class PontoApi {

    @Autowired
    private PontoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void salvar(@RequestBody final PontoDto pontoDto) {
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

    @GetMapping("/{id}")
    public Ponto buscarPorId(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/")
    public List<Ponto> buscarTodos() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
