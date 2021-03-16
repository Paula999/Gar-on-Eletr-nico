package projeto.pi.lanchonete.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LanchoneteController {
	
	@RequestMapping("/produtos/form")
	private String form() {
		return "formProduto";
		
	}

}
