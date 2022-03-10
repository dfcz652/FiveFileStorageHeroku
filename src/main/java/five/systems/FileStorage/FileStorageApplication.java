package five.systems.FileStorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class FileStorageApplication {

		public static void main(String[] args) {
			SpringApplication.run(FileStorageApplication.class, args);
			System.out.println ("Успешный запуск");

		}
	}

