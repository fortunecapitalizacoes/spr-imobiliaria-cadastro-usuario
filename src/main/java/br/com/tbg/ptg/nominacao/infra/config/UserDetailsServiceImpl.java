package br.com.tbg.ptg.nominacao.infra.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tbg.ptg.nominacao.domain.models.User;
import br.com.tbg.ptg.nominacao.domain.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar o usuário no banco de dados
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
        }

        // Converter para UserDetails do Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // Certifique-se de que está criptografada
                .roles(user.getRoles().toArray(new String[0])) // Converte lista para array
                .build();
    }
}
