package com.example.myrestapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello From Spring Boot";
    }

    @GetMapping("/book")
    public Book getBook(){
        Book aBook = new Book();
        aBook.setName("Man's Search For Meaning");
        aBook.setAuthor("Victor E. Frankl");
        return aBook;
    }

    @GetMapping("/movie")
    public Movie getMovie(){
        Movie aMovie = new Movie();
        return aMovie;
    }
    
    @GetMapping("/test-cicd")
    public String test(){
        return "For CI/CD test";
    }

    @GetMapping("/JenkinsFile-with-github-webhook")
    public String jenkinsFileGithubWebhook() {
        return "JenkinsFile with Github Webhook works!";
    }

}
