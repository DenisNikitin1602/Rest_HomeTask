package ru.netology.springBootDemo;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, String> users = Map.of(
            "admin", "admin123",
            "user", "pass"
    );

    private final Map<String, List<Authorities>> permissions = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return permissions.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}
