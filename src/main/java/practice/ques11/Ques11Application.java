package practice.ques11;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class Ques11Application {

	private static final Logger logger = LoggerFactory.getLogger(Ques11Application.class);

	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info("Ques11");

		SpringApplication app = new SpringApplication(Ques11Application.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		
		List optsVal = appArgs.getOptionValues("port");
		logger.info("optsVal" + optsVal);

		String portNumber = null;

		if(optsVal == null || optsVal.get(0) ==null){
			portNumber = System.getenv("PORT");

			if(portNumber == null)
				portNumber = DEFAULT_PORT;
		}else{
			portNumber = (String)optsVal.get(0);
		}

		if(portNumber != null){

			app.setDefaultProperties(
				Collections.singletonMap("server.port",
					portNumber));
		}
		app.run(args);
	}

}

