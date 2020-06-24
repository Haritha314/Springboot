package springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springsecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
