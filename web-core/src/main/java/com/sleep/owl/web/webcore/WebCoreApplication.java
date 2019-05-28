package com.sleep.owl.web.webcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WebCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCoreApplication.class, args);
    }

}
