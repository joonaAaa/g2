package restController;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import models.Users;
import services.UserServiceImpl;

@RestController
@AllArgsConstructor
public class usuarioApliRestController {
	

	    private final UserServiceImpl userServiceImpl;


	    @RequestMapping("/obtener/usuario")
	    public Optional<Users> obtenerUsuario(@RequestParam(value="id",required = true) Long id) {
	        try {
				return UserServiceImpl.getUserById(id);
	        }

	}
}

