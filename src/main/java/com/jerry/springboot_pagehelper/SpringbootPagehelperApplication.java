package com.jerry.springboot_pagehelper;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
public class SpringbootPagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPagehelperApplication.class, args);
        System.out.println("程序运行");
    }

}
