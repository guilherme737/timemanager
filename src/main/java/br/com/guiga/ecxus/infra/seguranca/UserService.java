package br.com.guiga.ecxus.infra.seguranca;

import br.com.guiga.ecxus.infra.entity.Usuario;
import br.com.guiga.ecxus.timemanager.usuario.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login).orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + login));
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getPermissao().name());
        return new org.springframework.security.core.userdetails.User(usuario.getLogin(), usuario.getSenha(), Arrays.asList(authority));
    }
}
