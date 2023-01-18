package id.web.ilham.dmp.service;

import id.web.ilham.dmp.entity.User;
import id.web.ilham.dmp.model.UserDetailsImpl;
import id.web.ilham.dmp.repository.UserRepository;
import id.web.ilham.dmp.repository.UserRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    private final UserRolesRepository userRolesRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        List<String> roles = userRolesRepository.findRoles(user.getId());

        return UserDetailsImpl.build(user, roles);
    }

}