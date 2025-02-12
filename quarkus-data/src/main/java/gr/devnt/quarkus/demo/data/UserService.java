package gr.devnt.quarkus.demo.data;

import java.util.Optional;

public interface UserService {
    Optional<User> get(String id);

    void persist(User user);
}
