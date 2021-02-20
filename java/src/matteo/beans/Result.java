package matteo.beans;

import java.util.ArrayList;

public class Result {

    private ArrayList<LibraryResult> allSignedUpLibraries = new ArrayList<>();

    public ArrayList<LibraryResult> getAllLibraries() {
        return allSignedUpLibraries;
    }

    public void setAllLibraries(ArrayList<LibraryResult> allLibraries) {
        this.allSignedUpLibraries = allLibraries;
    }

    public void addLibrary(LibraryResult lib){
        this.allSignedUpLibraries.add(lib);
    }
}
