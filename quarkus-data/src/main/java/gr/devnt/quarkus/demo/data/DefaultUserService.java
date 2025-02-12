package gr.devnt.quarkus.demo.data;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
final class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> get(String id) {
        return this.userRepository.findByIdOptional(id);
    }

    public void persist(User user) {
        if (user.getId().isBlank() || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }

        this.userRepository.persist(user);
    }
}
