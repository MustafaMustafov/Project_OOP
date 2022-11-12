package Management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileManagement {

    public static<T> void writeObjectToFile(ArrayList<T> objects, String inputName) {
        try {
            String fileName = "project/src/ProgramFiles/" + inputName;
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(objects);
            objectOutputStream.flush();
        } catch (Exception e) {
            System.out.println("File can not be written!");
        }
    }

    public static<T> ArrayList<T> readObjectFromFile(String inputName) {
        ArrayList<T> obj = new ArrayList<>();
        try {
            String fileName = "project/src/ProgramFiles/" + inputName;
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            obj = (ArrayList<T>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println("File not found!");
        }
        return obj;
    }

}
