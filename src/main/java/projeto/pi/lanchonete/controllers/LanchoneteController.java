package projeto.pi.lanchonete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projeto.pi.lanchonete.models.produto;
import projeto.pi.lanchonete.repositories.ProdutoRepository;




@Controller
public class LanchoneteController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping("/produtos/form")
	private String form() {
		return "formProduto";
		
	}
	@PostMapping("/produtos")
	private String adicionar(produto produto) {
		
		System.out.println(produto);
		pr.save(produto);
		return "produtoAdicionado";
		
	}

}
