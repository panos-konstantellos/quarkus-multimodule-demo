package gr.devnt.quarkus.demo.data;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
class UserServiceTest {
    @Inject
    UserService userService;

    @InjectMock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Mockito
                .when(userRepository.findByIdOptional("1"))
                .thenReturn(Optional.of(User.builder()
                        .id("1")
                        .username("test")
                        .email("test@test.org")
                        .build()));
    }

    @Test
    void testGetUser() {
        var user = userService.get("1");

        Assertions.assertNotNull(user);
    }
}