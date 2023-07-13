import java.util.HashMap;
import enums.MovieType;

public class RentalInfo {
  public String statement(Customer customer) {
    HashMap<String, Movie> movies = new HashMap();
    movies.put("F001", new Movie("You've Got Mail", MovieType.REGULAR.getValue()));
    movies.put("F002", new Movie("Matrix", MovieType.REGULAR.getValue()));
    movies.put("F003", new Movie("Cars", MovieType.CHILDRENS.getValue()));
    movies.put("F004", new Movie("Fast & Furious X", MovieType.NEW.getValue()));

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {
        Movie movie = movies.get(r.getMovieId());
        double thisAmount = MovieTypeCalculator.calculatePrice(movie.getCode(), r.getDays());

        // add frequent bonus points
        frequentEnterPoints++;
        // add bonus for a two day new release rental
        if (movie.getCode().equals(MovieType.NEW.getValue()) && r.getDays() > 2) {
            frequentEnterPoints++;
        }

        // print figures for this rental
        result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
        totalAmount += thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
