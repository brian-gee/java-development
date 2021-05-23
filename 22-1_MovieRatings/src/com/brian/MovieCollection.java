package com.brian;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieCollection {

    List<Movie> movies = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#.#");

    public void add(Movie m) {
        this.movies.add(m);
    }

    public List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> condition) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie m : movies) {
           if (condition.test(m)) {
               filteredMovies.add(m);
           }
        }
        return filteredMovies;
    }

    public String getLowestRating() {
        double lowestRating = movies.stream()
                .map(Movie::getMovieRating)
                .reduce(5.0, Math::min);

        return df.format(lowestRating);
    }

    public String getHighestRating() {
         double highestRating = movies.stream()
                .map(Movie::getMovieRating)
                .reduce(0.0, Math::max);

        return df.format(highestRating);
    }


    public String getAverageRating() {
        double total = movies.stream()
                .map(Movie::getMovieRating)
                .reduce(0.0, Double::sum);
        int i = movies.size();
        String averageRatingFormatted = df.format(total / i);

        return  averageRatingFormatted;
    }

}