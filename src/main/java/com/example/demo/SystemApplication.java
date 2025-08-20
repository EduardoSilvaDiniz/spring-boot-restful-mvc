package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {
  public static void main(String[] args) {
		System.out.println("start http server");
    SpringApplication.run(SystemApplication.class, args);
  }
}
