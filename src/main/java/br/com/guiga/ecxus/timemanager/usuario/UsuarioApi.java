package br.com.guiga.ecxus.timemanager.usuario;

import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.timemanager.geral.ApiContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(ApiContants.USUARIO)
public class UsuarioApi {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void salvar(final UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        this.usuarioRepository.save(usuario);
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
