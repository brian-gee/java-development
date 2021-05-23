package com.brian;

import java.util.ArrayList;
import java.util.List;

public class MovieRatingsApp {
    private MovieCollection mc = new MovieCollection();
    private List<Movie> filteredMovies = new ArrayList<>();
    private int userChoice;

    public MovieRatingsApp() {
        System.out.println("Welcome to the Movie Ratings application!");
        while (userChoice != 6) {
            printMenu();
            switch (userChoice) {
                case 1 -> addMovie();
                case 2 -> printTopRatedMovies();
                case 3 -> printMostRecentMovies();
                case 4 -> printAllMovies();
                case 5 -> printAllRatings();
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println("\n-----------------------\n" +
                "What do you want to do?\n" +
                "-----------------------\n" +
                "1 - Enter a movie\n" +
                "2 - View top rated movies\n" +
                "3 - View most recent movies\n" +
                "4 - View all movies\n" +
                "5 - View ratings\n" +
                "6 - Quit application");
        userChoice = Console.getInt("\nChoose a menu option: ");
        System.out.println();
    }

    public void addMovie() {
        String title;
        int year;
        Double rating;
        int numberOfMovies = Console.getInt("How many movies do you want to enter? ");
        for (int i = 1; i <= numberOfMovies; i++) {
            System.out.println("\nMovie #" + i + "\n----------");
            title = Console.getLine("Enter title: ");
            year = Console.getInt("Enter year: ");
            rating = Console.getDouble("Enter rating between 1 and 5 (decimals OK): ");
            Movie m = new Movie(title, year, rating);
            mc.add(m);
        }
    }

    public void printTopRatedMovies() {
        filteredMovies = mc.filterMovies(mc.movies, m -> m.getMovieRating() > 4);
        System.out.println("Movies rated 4.0 or higher\n" + "--------------------------");
        filteredMovies.forEach( (m -> printMovie(m)));
    }

    public void printMostRecentMovies() {
        System.out.println("Most Recent Movies\n------------------");
        filteredMovies = mc.filterMovies(mc.movies, m -> m.getMovieYear() > 2000);
        filteredMovies.forEach( (m -> printMovie(m)));
    }

    public void printAllMovies(){
        System.out.println("All Movies\n----------");
        mc.movies.forEach( (m -> printMovie(m)));
    }

    public void printAllRatings() {
        System.out.println("Movie rating data\n-----------------\n" +
                "Number of movies: " + mc.movies.size() + "\n" +
                "Lowest rating: " + mc.getLowestRating() + "\n" +
                "Highest rating: " + mc.getHighestRating() + "\n" +
                "Average rating: " + mc.getAverageRating());

    }

    public void printMovie(Movie m) {
        System.out.println(m.getMovieName() + "(" +
                m.getMovieYear() + ") Rating: " + m.getMovieRating());
    }
}