package sistemasuni.asistencia.example.sistemasuni.config;

import sistemasuni.asistencia.example.sistemasuni.model.OurUser;
import sistemasuni.asistencia.example.sistemasuni.repository.OurUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class OurUserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private OurUserRepo ourUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<OurUser> user = ourUserRepo.findByEmail(username);
        return user.map(OurUserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
}
