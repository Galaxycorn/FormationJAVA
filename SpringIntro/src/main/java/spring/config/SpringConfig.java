package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.beans.Guitare;
import spring.beans.Guitariste;
import spring.beans.Pianiste;
import spring.beans.Piano;
import spring.interfaces.Musicien;

@Configuration
@ComponentScan("spring.beans")
public class SpringConfig {

	@Bean("guitariste")
	public Musicien guitariste() {
		Guitariste guitariste = new Guitariste();
		guitariste.setInstrument(new Guitare());
		return guitariste;
	}

	@Bean("pianiste")
	public Musicien pianiste() {
		Pianiste pianiste = new Pianiste();
		pianiste.setInstrument(new Piano());
		return pianiste;
	}

}
