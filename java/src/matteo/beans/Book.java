package matteo.beans;

public class Book {

    private int id;
    private int score;
    private boolean isScanned;

    public Book(int id, int score){
        this.id = id;
        this.score = score;
        isScanned = false;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean isScanned() {
        return isScanned;
    }

    public void setScanned(boolean scanned) {
        isScanned = scanned;
    }
}

