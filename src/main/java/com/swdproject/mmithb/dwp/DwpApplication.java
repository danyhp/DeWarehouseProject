package com.swdproject.mmithb.dwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@EnableJpaAuditing
public class DwpApplication {

    @RequestMapping("/")
    public String welcome() {
        return "DeWarehouse";
    }

    public static void main(String[] args) {
        SpringApplication.run(DwpApplication.class, args);
    }
}
