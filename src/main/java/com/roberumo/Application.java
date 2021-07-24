package com.roberumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		if (args.length == 0) {
			System.err.println("No arguments!");
			System.exit(1);
		} else {
			System.out.println(args[0]);
		}
		SpringApplication.run(Application.class, args);
	}

}
