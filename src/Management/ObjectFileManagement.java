package Management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileManagement {
    //TODO Object class needs to be Serializable
    public static<T> void writeObjectToFile(ArrayList<T> objects, String fileName) {
        try {
//            String className = objects.getClass().+ ".csv";
//            String fileName1 = "src/ProgramFiles/" + fileName;
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(objects);
            objectOutputStream.flush();
        } catch (Exception e) {
            System.out.println("File can not be written!");
        }
    }

    public static<T> ArrayList<T> readObjectFromFile(String fileName) {
        ArrayList<T> obj = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            obj = (ArrayList<T>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
//            System.out.println("The file was not found!");
            System.out.println(e);
        }
        return obj;
    }

    public static<T> void writeObjectToFileNew(List<T> objects, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream writeOut = new ObjectOutputStream(fileOut);
            for (var tempObj : objects) {
                writeOut.writeObject(tempObj);
                writeOut.flush();
            }
            writeOut.close();
            fileOut.close();
            System.out.println("Data is save to file " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
