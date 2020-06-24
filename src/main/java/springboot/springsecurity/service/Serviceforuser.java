package springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import springboot.springsecurity.model.User;
import springboot.springsecurity.web.dto.UserRegistrationDto;

public interface Serviceforuser extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
