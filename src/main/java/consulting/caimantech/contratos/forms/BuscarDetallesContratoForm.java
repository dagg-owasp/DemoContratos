package consulting.caimantech.contratos.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


public class BuscarDetallesContratoForm {
	
	@NotNull(message="El id del contrato es mandatorio")
	@Min(value=1, message="El id del contrato debe ser mayor o igual a 1")
	@Max(value=100, message="El id del contrato no puede ser mayor a 100")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BuscarDetallesContratoForm [id=" + id + "]";
	}


}