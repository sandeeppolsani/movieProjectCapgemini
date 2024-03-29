package com.movie.demo;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieBookingSystem1Application implements CommandLineRunner {

	
	@Autowired
	moviedao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingSystem1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Movie m=new Movie();
//		m.setMovieId(101);
		m.setDirector("puri jagannath");
		m.setGenre("romance");
		m.setHero("Mahesh babu");
		m.setHeroine("Ileana");
		m.setRuntime(132);
		String[] language=new String[2];
		language[0]="Telugu";
		language[1]="Hindi";
		m.setLanguage(language);
		m.setReleaseYear(2006);
		
//		dao.create(m);
//		
//		System.out.println("successfully created");
		
		for (Movie student : dao.retrieve()) {
			
			System.out.println(student.getDirector());
			if(student.getLanguage()!=null)
			{
				for (String string : student.getLanguage()) {
					System.out.println(string);
				}
			}
			System.out.println();
		}
		
		
	}

}
