package matteo.beans;

import java.util.ArrayList;

public class Library {

    private int id;
    private int signupDays;
    private int booksPerDay;
    private ArrayList<Book> booksList;

    public Library(int id, int signupDays, int booksPerDay){
        this.id = id;
        this.signupDays = signupDays;
        this.booksPerDay = booksPerDay;
    }

    public int getId() {
        return id;
    }

    public int getSignupDays() {
        return signupDays;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }
}


