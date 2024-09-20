package com.eaac.starter;

import com.eaac.exec.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EaacApplication {
    @Autowired
    private Executor executor;
    public static void main(String[] args) {
        SpringApplication.run(EaacApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner1() {
        return args -> {
            Object exec = executor.exec("spring", "app1", "hh1", "disaster","hello world");
            System.out.println("exec = " + exec);
        };
    }
}
