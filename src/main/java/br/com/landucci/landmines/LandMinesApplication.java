package br.com.landucci.landmines;

import javax.swing.SwingUtilities;

import br.com.landucci.landmines.gui.LandminesFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LandMinesApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LandMinesApplication.class).headless(false).run(args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> SwingUtilities.invokeLater(() -> {
			final LandminesFrame frame = new LandminesFrame();
			frame.setVisible(true);
		});
	}

}
