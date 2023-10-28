package ca.innolab.i18ndemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public ClassLoaderTemplateResolver templateResolver() {

		var templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setPrefix("templates/");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCharacterEncoding("UTF-8");

		// This is proposed as a solution here: https://stackoverflow.com/questions/74709361/thymeleaf-utf8-xml-bug
		// This doesn't solve the problem.
		//templateResolver.setForceTemplateMode(true);

		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {

		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());

		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver() {

		var viewResolver = new ThymeleafViewResolver();

		viewResolver.setTemplateEngine(templateEngine());
		//viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setContentType("text/html; charset=UTF-8");
		//viewResolver.setOrder(0);
		//viewResolver.setCache(false);
		viewResolver.setForceContentType(true);


		return viewResolver;
	}
}
