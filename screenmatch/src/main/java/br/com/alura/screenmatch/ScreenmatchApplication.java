package br.com.alura.screenmatch;
import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeAPI consumeAPI = new ConsumeAPI();
		String json = consumeAPI.getData("http://www.omdbapi.com/?t=matrix&apikey=3ab10a20");
		System.out.println(json);

		ConvertData convert = new ConvertData();
		DataSeries data = convert.getData(json, DataSeries.class);
		System.out.println(data);
	}
}
