package projeto.pi.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.pi.lanchonete.models.produto;

public interface ProdutoRepository extends JpaRepository<produto, Long> {

}
