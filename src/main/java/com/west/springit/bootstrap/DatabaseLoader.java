package com.west.springit.bootstrap;

import com.west.springit.domain.Link;
import com.west.springit.domain.Role;
import com.west.springit.domain.User;
import com.west.springit.repository.CommentRepository;
import com.west.springit.repository.LinkRepository;
import com.west.springit.repository.RoleRepository;
import com.west.springit.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final LinkRepository linkRepository;
    private final RoleRepository roleRepository;

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public DatabaseLoader(LinkRepository linkRepository, CommentRepository commentRepository, RoleRepository roleRepository, CommentRepository commentRepository1, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.roleRepository = roleRepository;
        this.commentRepository = commentRepository1;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        addUsersAndRoles();

        Map<String, String> links = new HashMap<>();
        links.put("Securing Spring Boot APIs and SPAs with OAuth 2.0", "https://auth0.com/blog/securing-spring-boot-apis-and-spas-with-oauth2/?utm_source=reddit&utm_medium=sc&utm_campaign=springboot_spa_securing");
        links.put("Easy way to detect Device in Java Web Application using Spring Mobile - Source code to download from GitHub", "https://www.opencodez.com/java/device-detection-using-spring-mobile.htm");
        links.put("Tutorial series about building microservices with SpringBoot (with Netflix OSS)", "https://medium.com/@marcus.eisele/implementing-a-microservice-architecture-with-spring-boot-intro-cdb6ad16806c");
        links.put("Detailed steps to send encrypted email using Java / Spring Boot - Source code to download from GitHub", "https://www.opencodez.com/java/send-encrypted-email-using-java.htm");
        links.put("Build a Secure Progressive Web App With Spring Boot and React", "https://dzone.com/articles/build-a-secure-progressive-web-app-with-spring-boo");
        links.put("Building Your First Spring Boot Web Application - DZone Java", "https://dzone.com/articles/building-your-first-spring-boot-web-application-ex");
        links.put("Building Microservices with Spring Boot Fat (Uber) Jar", "https://jelastic.com/blog/building-microservices-with-spring-boot-fat-uber-jar/");
        links.put("Spring Cloud GCP 1.0 Released", "https://cloud.google.com/blog/products/gcp/calling-java-developers-spring-cloud-gcp-1-0-is-now-generally-available");
        links.put("Simplest way to Upload and Download Files in Java with Spring Boot - Code to download from Github", "https://www.opencodez.com/uncategorized/file-upload-and-download-in-java-spring-boot.htm");
        links.put("Add Social Login to Your Spring Boot 2.0 app", "https://developer.okta.com/blog/2018/07/24/social-spring-boot");
        links.put("File download example using Spring REST Controller", "https://www.jeejava.com/file-download-example-using-spring-rest-controller/");


        links.forEach((k, v) -> {
            linkRepository.save(new Link(k, v));
        });
    }

    private void addUsersAndRoles() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");

        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);

        User user = new User("user@gmail.com",secret,true);
        user.addRole(userRole);
        userRepository.save(user);

        User admin = new User("admin@gmail.com",secret,true);
        admin.addRole(adminRole);
        userRepository.save(admin);

        User master = new User("super@gmail.com",secret,true);
        master.addRoles(new HashSet<>(Arrays.asList(userRole,adminRole)));
        userRepository.save(master);
    }
}









