package com.cts;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.bean.Movie;
import com.cts.resources.MovieSummary;


@RestController
public class Hello {

	@RequestMapping("/trending")
	public Movie trending() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("APIKey", "6e8ebaec70f27ea69491b2c5b9d6bf8e");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.themoviedb.org/3/trending/all/day?api_key=6e8ebaec70f27ea69491b2c5b9d6bf8e";
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
		MovieSummary movieSummary = restTemplate.getForObject(resourceURL, MovieSummary.class);
		System.out.println(response);

		return new Movie(movieSummary.getId(),movieSummary.getTitle(), movieSummary.getOverview());
	}
	
	@RequestMapping("/search/{keyword}")
	public Movie search() {
		String keyword = ;	
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("APIKey", "6e8ebaec70f27ea69491b2c5b9d6bf8e");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.themoviedb.org/3/search/"+keyword+"?api_key=6e8ebaec70f27ea69491b2c5b9d6bf8e&page=1";
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
		MovieSummary movieSummary = restTemplate.getForObject(resourceURL, MovieSummary.class);
		System.out.println(response);

		return new Movie(movieSummary.getId(),movieSummary.getTitle(), movieSummary.getOverview());
	}
	@RequestMapping("/upcoming")
	public Movie upcoming() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("APIKey", "6e8ebaec70f27ea69491b2c5b9d6bf8e");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.themoviedb.org/3/movie/upcoming?api_key=6e8ebaec70f27ea69491b2c5b9d6bf8e&language=en-US&page=1";
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
		MovieSummary movieSummary = restTemplate.getForObject(resourceURL, MovieSummary.class);
		System.out.println(response);

		return new Movie(movieSummary.getId(),movieSummary.getTitle(), movieSummary.getOverview());
	}
	
}
