package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

	    public Users findUserByUsername(String username);

	
	}
