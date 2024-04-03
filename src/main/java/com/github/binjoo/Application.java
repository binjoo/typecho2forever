package com.github.binjoo;

import com.github.binjoo.app.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private PostApp postApp;
    @Autowired
    private PageApp pageApp;
    @Autowired
    private CommentApp commentApp;
    @Autowired
    private GuestBookApp guestBookApp;
    @Autowired
    private LinkApp linkApp;
    @Autowired
    private SayApp sayApp;

    public static void main(String[] args) {
        log.info("Hello World Main");
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("=============== start ===============");
        postApp.run();
        pageApp.run();
        commentApp.run();
        guestBookApp.run();
        sayApp.run();
        linkApp.run();
        log.info("================ end ================");
    }
}
