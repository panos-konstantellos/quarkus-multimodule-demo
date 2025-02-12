package gr.devnt.quarkus.demo.domain;

import java.util.Optional;

public interface UserService {
    Optional<User> get(String id);

    User persist(User user);
}
