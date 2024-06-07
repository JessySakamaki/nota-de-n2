package br.com.aulaskratz.nota_de_n2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 */
@EnableJdbcAuditing
@SpringBootApplication
public class NotaDeN2Application {

	/**
	 * Método principal que inicia a aplicação Spring Boot.
	 *
	 * @param args argumentos de linha de comando (não utilizados).
	 */
	public static void main(String[] args) {
		SpringApplication.run(NotaDeN2Application.class, args);
	}

}
