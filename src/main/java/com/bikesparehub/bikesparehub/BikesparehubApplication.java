package com.bikesparehub.bikesparehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.bikesparehub.bikesparehub.model.BikePart;
import com.bikesparehub.bikesparehub.repository.BikePartRepository;

@SpringBootApplication
public class BikesparehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesparehubApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(BikePartRepository repo) {
		return args -> {

			BikePart part1 = new BikePart();
			part1.setPartName("Brake Pad");
			part1.setBrand("Yamaha");
			part1.setModel("R15");
			part1.setPrice(850);
			part1.setStock(10);
			part1.setCity("Chennai");
			part1.setCompatibleOldModel("R15 V2");
			part1.setImageUrl("brake-pad.jpg");
			repo.save(part1);

			BikePart part2 = new BikePart();
			part2.setPartName("Clutch Cable");
			part2.setBrand("Honda");
			part2.setModel("CBR");
			part2.setPrice(450);
			part2.setStock(3);
			part2.setCity("Coimbatore");
			part2.setCompatibleOldModel("CBR 150R");
			part2.setImageUrl("clutch-cable.jpg");
			repo.save(part2);
		};
	}
}