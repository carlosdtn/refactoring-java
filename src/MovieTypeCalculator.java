import enums.MovieType;

public class MovieTypeCalculator {
    public static double calculatePrice(String movieType, int daysRented) {
        double amount = 0;
        if (movieType.equals(MovieType.REGULAR.getValue())) {
            amount = 2;
            if (daysRented > 2) {
                amount += (daysRented - 2) * 1.5;
            }
        } else if (movieType.equals(MovieType.NEW.getValue())) {
            amount = daysRented * 3;
        } else if (movieType.equals(MovieType.CHILDRENS.getValue())) {
            amount = 1.5;
            if (daysRented > 3) {
                amount += (daysRented - 3) * 1.5;
            }
        }
        return amount;
    }
}
