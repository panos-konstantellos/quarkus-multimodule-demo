package gr.devnt.quarkus.demo.data;

import gr.devnt.quarkus.demo.domain.User;
import gr.devnt.quarkus.demo.domain.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
final class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> get(String id) {
        return this.userRepository.findByIdOptional(id).map(userEntity -> User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .build());
    }

    @Transactional
    public User persist(User user) {
        if (user.getId() == null || user.getId().isBlank()) {
            user.setId(UUID.randomUUID().toString());
        }

        var userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());

        this.userRepository.persist(userEntity);

        return this.get(userEntity.getId()).orElseThrow();
    }
}
