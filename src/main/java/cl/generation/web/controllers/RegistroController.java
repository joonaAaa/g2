package cl.generation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	
	
	/*http://localhost:8080/registro/usuario GET -> desplegar el jsp
		http://localhost:8080/registro/usuario POST -> capturar los datos en el controlador

		http://localhost:8080/registro/login GET -> desplegar el login.jsp
		http://localhost:8080/registro/login POST -> capturar los datos(email y pasword)  en el controlador
*/
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	//http://localhost:8080/registro/usuario

	
	//Capturar la url 
	@GetMapping("/usuario")
	public String mostrarFormulario() {
		return "Registro.jsp";
	}

	
	
	//desplegar el jsp(controlador)
	//llenamos el formulario(vista)
	//enviamos el formulario(vista) al controlador
	//capturar la url,
	//capturar los parametros
	//http://localhost:8080/registro/formulario
	@PostMapping("/usuario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam("nombre") String nombre,
			@RequestParam("nick") String nick,
			@RequestParam("correo") String correo,
			@RequestParam("pass") String pass,
	        @RequestParam("pass2") String pass2,
	Model model
	){
	
		if(pass.equals(pass2)) {
		//intanciar up objeto a usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setCorreo(correo);
		usuario.setPassword(pass);
		usuario.setPassword2(pass2);
		usuario.setNick(nick);
		Boolean resultado =usuarioServiceImpl.guardarUsuario(usuario);
		if (resultado) {
			model.addAttribute("msgOk", "Registro exitoso");
			return "login.jsp";
		}else { model.addAttribute("msgError", "Email ya registrado");
		return "Registro.jsp";
		}
	}else{//El model model nos permite pasar infromacion del backend al froned
		model.addAttribute("msgError", "Password distintos");
		return "Registro.jsp";
	}
		
}


	//desplegar el jsp
		@GetMapping("/login")
		public String login() {
			return "login.jsp";
		}

		//capturar el email y password
		@PostMapping("/login")
		public String ingresoUsuario(@RequestParam("email") String correo, @RequestParam("pass") String pass,
				Model model) {
			System.out.println("Controlador registro");
			Boolean resultadoLogin = usuarioServiceImpl.ingresoUsuario(correo, pass);
			if (resultadoLogin) { // resultadoLogin == true; Login correcto
			 return "redirect:/home";
			} else {
				model.addAttribute("msgError", "¡Error! Verifica tus datos");
				return "login.jsp";
			}

		}
}
	

