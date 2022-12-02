package services;

import java.util.Optional;

import models.Users;

public interface UserService  {

    public Optional<Users> getUserById(Long id);

}


