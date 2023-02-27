package ibf2022.ssf.day11workshop;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11workshopApplication {

	private static String portNum = null;
	private static String DEFAULT_PORTNUM = "9090";

	public static void main(String[] args) {

		//mvn clean spring-boot:run -Dspring-boot.run.arguments=--port=5051
		//mvn clean spring-boot:run -Dspring-boot.run.arguments=--Dport=5055
		// java -jar target/workshop11-0.0.1-SNAPSHOT.jar --port=5055
		// java -jar target/workshop11-0.0.1-SNAPSHOT.jar --Dport=5055
		for (String argVal : args) {
			System.out.println("argVal > " + argVal);
			if (argVal.contains("--Dport") || argVal.contains("--port")) {
				portNum = argVal.substring(argVal.length() - 4, argVal.length());
				System.out.println("portNum > " + portNum);
			}
		}

		//mvn clean spring-boot:run -Dspring-boot.run.arguments=--port=5050
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		if (appArgs.containsOption("port")) {
			System.out.println("contains");
			portNum = appArgs.getOptionValues("port").get(0);
		}

		// set PORT=xxxx
		// mvn spring-boot:run
		if (portNum == null) {
			portNum = System.getenv("PORT");
			System.out.println("portNum > " + portNum);
		}

		// unset PORT
		// set PORT=xxxx
		// mvn spring-boot:run
		if (portNum == null || portNum.length() == 0) {
			portNum = DEFAULT_PORTNUM;
		}
		
		// server.port takes highest priority
		SpringApplication app = new SpringApplication(Day11workshopApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", portNum));
		app.run(args);
	}

}
