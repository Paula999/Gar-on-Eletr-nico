package projeto.pi.lanchonete.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LanchoneteController {
	
	@RequestMapping("/lanchonete/form")
	private String form() {
		return "formLanchonete";
		
	}

}
