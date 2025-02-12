package gr.devnt.quarkus.demo.domain;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private String id;

    private String username;

    private String email;
}
