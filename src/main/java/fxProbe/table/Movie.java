package fxProbe.table;

/**
 * Created by knabe on 15.09.16.
 * According to listing 9-1 from JavaFX for Dummies.
 */
public class Movie {

    private String title;
    private int year;
    private double price;


    public Movie() {
        this.title = "";
        this.year = 0;
        this.price = 0.0;
    }

    public Movie(final String title, final int year, final double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

}
