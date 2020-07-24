package consulting.caimantech.contratos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import consulting.caimantech.contratos.model.Contrato;

public interface IContratoRepo extends  JpaRepository <Contrato, Integer> {

}
