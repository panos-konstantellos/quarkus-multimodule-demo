package gr.devnt.quarkus.demo.data;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
final class UserRepository implements PanacheRepositoryBase<UserEntity, String> {
}
