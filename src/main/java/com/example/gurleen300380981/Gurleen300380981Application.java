package com.example.gurleen300380981;

import com.example.gurleen300380981.entities.Student;
import com.example.gurleen300380981.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@EntityScan
@SpringBootApplication
public class Gurleen300380981Application {

    public static void main(String[] args) {
        SpringApplication.run(Gurleen300380981Application.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student(101, "JohnDoe", "CSIS 3175", 3, "C"));
            studentRepository.save(new Student(101, "JohnDoe", "CSIS 3173", 3, "B"));

            studentRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }
}
