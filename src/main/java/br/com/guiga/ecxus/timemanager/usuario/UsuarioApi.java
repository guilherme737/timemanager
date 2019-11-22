package br.com.guiga.ecxus.timemanager.usuario;

import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.infra.error.EntidadeNaoEncontradaException;
import br.com.guiga.ecxus.timemanager.geral.ApiContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(ApiContants.USUARIO)
public class UsuarioApi {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @PreAuthorize("!hasAuthority('USUARIO')")
    public void inserir(final UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getLogin(), usuarioDto.getSenha(), usuarioDto.getHorasDeTrabalhoPreferidasPorDia(), Usuario.Papel.USUARIO);
        this.usuarioRepository.save(usuario);
    }

    @PutMapping("/{usuarioId}")
    //@PreAuthorize("!hasRole('USUARIO') || #usuarioId == authentication.")
    public void alterar(@PathVariable("usuarioId") final Long usuarioId) {
        Usuario usuario = this.usuarioRepository.findById(usuarioId).get();
        this.usuarioRepository.save(usuario);
    }

    @GetMapping("/buscar-por-login")
    @PreAuthorize("!hasAuthority('USUARIO') || (authentication.principal == #login)")
    public Usuario buscarPorLogin(@RequestParam String login, OAuth2Authentication authentication) {
        return usuarioRepository.findByLogin(login).orElseThrow(() -> new EntidadeNaoEncontradaException(Usuario.class, "login", login));
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id).get();
    }

    @GetMapping("/")
    public List<Usuario> buscarTodos() {
        return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
