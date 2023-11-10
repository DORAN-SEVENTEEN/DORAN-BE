package com.seventeen.doran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DorandoranApplication {

  public static void main(String[] args) {
    SpringApplication.run(DorandoranApplication.class, args);
  }
}
