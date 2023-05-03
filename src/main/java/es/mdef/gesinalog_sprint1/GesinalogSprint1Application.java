package es.mdef.gesinalog_sprint1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GesinalogSprint1Application {

	public static final Logger log = LoggerFactory.getLogger(GesinalogSprint1Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GesinalogSprint1Application.class, args);
	}

}
