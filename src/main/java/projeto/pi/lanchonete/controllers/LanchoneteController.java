package projeto.pi.lanchonete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import projeto.pi.lanchonete.models.produto;
import projeto.pi.lanchonete.repositories.ProdutoRepository;




@Controller
@RequestMapping("/produtos")
public class LanchoneteController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping("/form")
	private String form() {
		return "formProduto";
		
	}
	@PostMapping
	private String adicionar(produto produto) {
		
		System.out.println(produto);
		pr.save(produto);
		return "produtos/produtoAdicionado";
		
	}
	
	@GetMapping
	public ModelAndView listar () {
	   List<produto> produtos = pr.findAll();
	   ModelAndView mv = new ModelAndView("produtos/cardapio");
	   mv.addObject("produtos", produtos );
	   return mv;
	   
	   
		
		
		
	}

}
