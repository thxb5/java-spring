package com.mall.march.marchproject;

import com.mall.march.marchproject.repository.UserRepository;
import com.mall.march.marchproject.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class MarchProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarchProjectApplication.class, args);

    }

}
