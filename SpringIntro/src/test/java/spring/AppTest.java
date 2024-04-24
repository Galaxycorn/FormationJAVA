package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.SpringConfig;
import spring.interfaces.Musicien;

public class AppTest {
	public static void main(String[] args) {
		// lancement spring
		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		ctx.getBean("guitariste", Musicien.class).performer();

		// fermeture spring
		ctx.close();
	}
}
