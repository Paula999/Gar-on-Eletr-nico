package projeto.pi.lanchonete.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projeto.pi.lanchonete.models.produto;




@Controller
public class LanchoneteController {
	
	@RequestMapping("/produtos/form")
	private String form() {
		return "formProduto";
		
	}
	@PostMapping("/produtos")
	private String adicionar(produto produto) {
		
		System.out.println(produto);
		return "produtoAdicionado";
		
	}

}
