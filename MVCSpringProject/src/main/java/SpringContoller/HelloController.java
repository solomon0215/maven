package SpringContoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String heaaa(Model model, 
			@RequestParam(value = "num",required=false) String num) {
		model.addAttribute("greeting", num);
		return "NewFile";
	}
}
