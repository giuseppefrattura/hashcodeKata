package matteo.beans;

import java.util.ArrayList;

public class Result {

    private ArrayList<Library> allLibraries;

    public ArrayList<Library> getAllLibraries() {
        return allLibraries;
    }

    public void setAllLibraries(ArrayList<Library> allLibraries) {
        this.allLibraries = allLibraries;
    }

    public void addLibrary(Library lib){
        this.allLibraries.add(lib);
    }
}
