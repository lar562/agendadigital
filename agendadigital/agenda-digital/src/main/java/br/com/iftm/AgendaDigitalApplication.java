package br.com.iftm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)//Ignora autoconfiguration pois esta trabalhando com Hiber
public class AgendaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaDigitalApplication.class, args);
	}

}

