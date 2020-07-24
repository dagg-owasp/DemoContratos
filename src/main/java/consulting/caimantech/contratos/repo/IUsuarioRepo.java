package consulting.caimantech.contratos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import consulting.caimantech.contratos.model.Usuario;

public interface IUsuarioRepo extends JpaRepository <Usuario, Integer>{
	
	Usuario findByNombre(String nombre);

}