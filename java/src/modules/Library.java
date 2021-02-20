package modules;

public class Library{
    int id;
    int booksCount;
    int signupProcess;
    int bookShipPerDay;

    public Library(int id, int booksCount, int signupProcess, int bookShipPerDay) {
        this.id = id;
        this.booksCount = booksCount;
        this.signupProcess = signupProcess;
        this.bookShipPerDay = bookShipPerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public int getSignupProcess() {
        return signupProcess;
    }

    public void setSignupProcess(int signupProcess) {
        this.signupProcess = signupProcess;
    }

    public int getBookShipPerDay() {
        return bookShipPerDay;
    }

    public void setBookShipPerDay(int bookShipPerDay) {
        this.bookShipPerDay = bookShipPerDay;
    }
}