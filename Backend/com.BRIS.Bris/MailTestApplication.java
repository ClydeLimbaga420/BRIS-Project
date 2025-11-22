package com.BRIS.Login;

import com.BRIS.Login.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailTestApplication implements CommandLineRunner {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(MailTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mailService.sendMail("your_email@gmail.com",
                "Test Email",
                "This is a test email from Spring Boot");
        System.out.println("Mail sent (or at least attempted).");
    }
}
