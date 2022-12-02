package cl.generation.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="roles")
@Getter//para obtener los getters de forma mas facil
@Setter// para obtener los setters de froma ma facil
@AllArgsConstructor// todos los constructores mas izi
@NoArgsConstructor// el constructor vacio de una forma izi
@ToString// para visualizar el objeto como string
public class Rol {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	//ManyToMany rol
	//@JsonIgnore para que este dato no se muestre al otro lado
		@ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
		private List<Usuario> usuarios;
}