package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import models.UserDTO;
import models.Users;
import repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	
	
	@Autowired
	private UserRepository userRepository;
	
	
	 public Users findUserByUsername(String username) {
	        return  userRepository.findUserByUsername(username);
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Users user = userRepository.findUserByUsername(username);
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	    }

	    private Collection<? extends GrantedAuthority> getAuthorities(Users users) {
	        String role = users.getRole().toString();
	        return List.of(new SimpleGrantedAuthority("Role_"+role));
	    }


	    public Users save(UserDTO user) {
	        Users newUser = new Users();
	        newUser.setUsername(user.getUsername());
	        newUser.setPassword(user.getPassword());
	        return userRepository.save(newUser);
	    }
}
