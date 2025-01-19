package atl.academy.coursemanagementsystem.repo;

import atl.academy.coursemanagementsystem.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Integer> {
    Login findByUsername(String username);

    Boolean existsByUsername(String username);
}
