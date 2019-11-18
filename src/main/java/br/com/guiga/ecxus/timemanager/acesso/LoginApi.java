package br.com.guiga.ecxus.timemanager.acesso;

import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.timemanager.usuario.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/registro")
public class LoginApi {

    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    public LoginApi(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public Usuario novo(@RequestParam final String nome, @RequestParam final String login, @RequestParam final String senha) {
        Usuario u = new Usuario(nome, login, passwordEncoder.encode(senha), Usuario.Papel.USUARIO);
        return repository.save(u);
    }

    @PostMapping("/validarLogin")
    public  Boolean loginExiste(@RequestParam String login) {
        return repository.existsByLogin(login);
    }
}
