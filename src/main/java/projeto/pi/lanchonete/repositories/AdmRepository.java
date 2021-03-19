package projeto.pi.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.pi.lanchonete.models.Administrador;

public interface AdmRepository extends JpaRepository<Administrador, Long> {
	
	Administrador findByEmail(String email);

}
