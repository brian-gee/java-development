package com.brian;

public class Movie {
    private String movieName;
    private int movieYear;
    private double movieRating;

    public Movie(String movieName, int movieYear, double movieRating) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }
}