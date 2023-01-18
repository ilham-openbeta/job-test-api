package id.web.ilham.dmp.service.auth;

import id.web.ilham.dmp.entity.Role;
import id.web.ilham.dmp.entity.User;
import id.web.ilham.dmp.entity.UserRole;
import id.web.ilham.dmp.model.auth.PostRegisterRequest;
import id.web.ilham.dmp.repository.RoleRepository;
import id.web.ilham.dmp.repository.UserRepository;
import id.web.ilham.dmp.repository.UserRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostRegisterService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRolesRepository userRolesRepository;

    private final PasswordEncoder encoder;

    @Transactional
    public void execute(PostRegisterRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException();
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException();
        }

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(RuntimeException::new);

        userRepository.save(user);
        UserRole userRole = UserRole.builder()
                .id(UUID.randomUUID().toString())
                .userId(user.getId())
                .roleId(role.getId())
                .build();

        userRolesRepository.save(userRole);
    }
}
