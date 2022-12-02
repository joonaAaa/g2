package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import models.Users;
import repositories.UserRepository;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> getUserById(Long id) {
        Boolean exists = userRepository.existsById(id);

        if (exists) {
            Optional<Users> user = userRepository.findById(id);
            return user;
        }
        return null;
    }
}

