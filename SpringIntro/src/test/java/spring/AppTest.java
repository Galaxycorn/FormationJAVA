package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.beans.Guitariste;
import spring.beans.Pianiste;
import spring.config.SpringConfig;

public class AppTest {
	public static void main(String[] args) {
		// lancement spring
		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		Guitariste guitariste = ctx.getBean("guitariste", Guitariste.class);
		Pianiste pianiste = ctx.getBean("pianiste", Pianiste.class);
		guitariste.performer();
		pianiste.performer();

		// fermeture spring
		ctx.close();
	}
}
