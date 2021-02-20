import modules.FileModel;

import java.io.InputStream;

class FileReader{

    public FileModel readFile(){

        String fileName = "a.in";

        System.out.println("getResourceAsStream : " + fileName);
        InputStream is = getFileFromResourceAsStream(fileName);



        return null;
    }


    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);


        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }


}