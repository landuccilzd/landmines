package br.com.landucci.landmines;

import javax.swing.SwingUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LandMinesApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LandMinesApplication.class).headless(false).run(args);
//		SpringApplication.run(LandMinesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> SwingUtilities.invokeLater(() -> {
			final CLSMinesFrame frame = new CLSMinesFrame(CLSMinesFrame.NIVEL_MEDIO);
			frame.setVisible(true);
		});
	}

}
