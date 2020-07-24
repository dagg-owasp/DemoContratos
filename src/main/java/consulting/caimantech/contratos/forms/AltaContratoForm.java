package consulting.caimantech.contratos.forms;


import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AltaContratoForm {
	
	@NotNull(message="El id del contrato es mandatorio")
	@NotEmpty(message="El id del contrato es mandatorio")
	@Pattern(regexp="^[1-9][0-9]?$|^100$", message="El id del contrato debe ser un numero entre el 1 y el 100")
	private String id;
	
	@NotNull(message="El nombre del contrato es mandatorio")
	@NotEmpty(message="El nombre del contrato es mandatorio")
	@Size(min=5, max=50, message="La longitud del nombre contrato debe ser minimo de 5 y maximo de 50")
	@Pattern(regexp="^[a-zA-Z0-9ÁÉÍÓÚÑáéíóúñ\\s\\&\\.\\,\\#]+$", message="El nombre del contrato debe ser alfanumerico")
	private String nombre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "AltaContratoForm [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
