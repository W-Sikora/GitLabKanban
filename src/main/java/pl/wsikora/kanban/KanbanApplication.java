package pl.wsikora.kanban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.wsikora.kanban.config.SslVerification;

@SpringBootApplication
public class KanbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanbanApplication.class, args);
//		SslVerification sslVerification = new SslVerification();
//		sslVerification.disable();
	}

}
