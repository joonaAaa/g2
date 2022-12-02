package cl.generation.web.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Pais;
import cl.generation.web.services.PaisServiceImpl;

@RestController
@RequestMapping("/pais")
public class PaisRestController {
	
	@Autowired
	private PaisServiceImpl paisServiceImpl;
	
	
	@RequestMapping("/guardar")//
	public Pais guardarPais(@RequestBody Pais pais) {
		return paisServiceImpl.guardarPais(pais);
	}  
// aca colocamos que retorne un tipo pais 
}
