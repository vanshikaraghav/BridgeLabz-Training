package stream_API;
import java.util.*;
import java.util.stream.*;

class Movies{
	String name;
	float rating;
	int releaseyear;
	public Movies(String name, float rating , int year) {
		this.name = name;
		this.rating = rating;
		this.releaseyear = year;
	}
}

public class TrendingMovies {
	public static void main(String[] args) {
		
		 List<Movies> movie = List.of(
	                new Movies("Inception", 4.8f, 2010),
	                new Movies("Skyfall", 4.5f, 2023),
	                new Movies("F1", 4.5f, 2025)
	        );
		
		 List<Movies> top5 = movie.stream().filter(m -> m.rating > 3.5)
				 .sorted(Comparator.comparing((Movies m) -> m.rating).reversed()
						 .thenComparing(m -> m.releaseyear , Comparator.reverseOrder()))
						 .limit(5).collect(Collectors.toList());
	
		  top5.forEach(m ->
          System.out.println(m.name + " | " + m.rating + " | " + m.releaseyear)
  );
	}
}