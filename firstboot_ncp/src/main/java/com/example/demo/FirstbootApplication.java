package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring.mybatis.board.BoardController;

//내장 tomcat(9090) 시작, component-scan -> com.example.demo 내부 -> application.properties 설정 읽기
//run as - spring boot app 실행
@SpringBootApplication
//@ComponentScan (basePackages = "com.example.demo")
//@ComponentScan(basePackages = "upload") //자기 자신 패키지와 다르면 추가해야함.
//@ComponentScan(basePackageClasses = BoardController.class)
//@ComponentScan(basePackages = {"upload","spring.mybatis.board"})
@ComponentScan(basePackages = "boardmapper")
//@ComponentScan(basePackages = "spring.mybatis.board")
@MapperScan(basePackages = "boardmapper")
//@ComponentScan(basePackages = "websocket")
//@MapperScan(basePackages = "websocket")
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}

}
