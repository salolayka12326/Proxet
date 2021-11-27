package com.example.task;

import com.example.task.domain.Player;
import com.example.task.repository.PlayerRepository;
import com.example.task.resource.PlayerResource;
import com.example.task.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
@SpringBootApplication
public class TaskApplication {


    public static void main(String[] args){
        SpringApplication.run(TaskApplication.class, args);


    }

}
