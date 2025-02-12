package gr.devnt.quarkus.demo.data;


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
