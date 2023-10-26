package ca.innolab.i18ndemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showIndexPage() {
		return "index-page";
	}
}
