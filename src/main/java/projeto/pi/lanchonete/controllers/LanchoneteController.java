package projeto.pi.lanchonete.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projeto.pi.lanchonete.models.Food;
import projeto.pi.lanchonete.repositories.FoodRepository;


@Controller
@RequestMapping("/foods")
public class LanchoneteController {

	@Autowired
	private FoodRepository fr;
	

	@GetMapping("/form")
	public String form(Food  food) {
		return "foods/formFood";
	}
	
	@GetMapping("/cliente")
	public String cliente(Food  food) {
		return "foods/cardapioCli";
	}

	@PostMapping
	public String salvar(@Valid Food food, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()){
			return form(food);
			
		}

		System.out.println(food);
		fr.save(food);
		attributes.addFlashAttribute("mensagem", "produto salvo com sucesso");
		return "redirect:/foods";
	}
	

	

	@GetMapping
	public ModelAndView listar() {
		List<Food> foods = fr.findAll();
		ModelAndView mv = new ModelAndView("foods/lista");
		mv.addObject("foods", foods);
		return mv;
	}
	
	@GetMapping("/cardapio")
	public ModelAndView listarCardapio() {
		List<Food> foods = fr.findAll();
		ModelAndView mv = new ModelAndView("foods/cardapioCli");
		mv.addObject("foods", foods);
		return mv;
	}
	
	@GetMapping("/{id}/selecionar")
	public ModelAndView selecionarFood(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Food> opt = fr.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/foods");
			return md;
		}
		
		Food food = opt.get();
		md.setViewName("foods/formFood");
		md.addObject("food", food);
		
		return md; 
	}


	@GetMapping("/{id}/remover")
	public String apagarFood(@PathVariable Long id, RedirectAttributes attributes) {
		Optional<Food> opt = fr.findById(id);

		if (!opt.isEmpty()) {
			Food food = opt.get();
			
			fr.delete(food);
			attributes.addFlashAttribute("mensagem", "produto removido com sucesso");
		}
		return "redirect:/foods";

	}
	
		
	
	
		
	


}