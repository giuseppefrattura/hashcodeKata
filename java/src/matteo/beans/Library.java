package matteo.beans;

import java.util.ArrayList;

public class Library {

    private int id;
    private int signupDays;
    private int booksPerDay;
    private float coefficient;
    private ArrayList<Book> booksList;

    public Library(int id, int signupDays, int booksPerDay){
        this.id = id;
        this.signupDays = signupDays;
        this.booksPerDay = booksPerDay;
    }


    public void decrementSignupDays(){
        signupDays --;
    }




    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
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


