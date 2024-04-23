package edu.gemini;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;

import java.util.ArrayList;

@SpringBootApplication
public class GeminiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiApplication.class, args);
	}
}
