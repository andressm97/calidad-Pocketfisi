package proyecto.back;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			URL url = new URL("https://sum-calidad.herokuapp.com/tabla/listar");
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<fn_sum_course>> typeReference = new TypeReference<List<fn_sum_course>>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/listar.json");
			InputStream inputStream = url.openStream();
			try {
				List<fn_sum_course> users = mapper.readValue(inputStream,typeReference);
				//userService.save(users);
				System.out.println("Users Saved!" + users.get(0).getDocente());
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
	*/
}
