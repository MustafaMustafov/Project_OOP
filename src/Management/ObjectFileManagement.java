package Management;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileManagement {
    //TODO Object class needs to be Serializable
    public static void writeObjectToFile(List<Object> meal) {
        try {
            String fileName = "src/ProgramFiles/" + meal.getClass().getName() + ".txt";
            FileOutputStream outputStream = new FileOutputStream("src/ProgramFiles/.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(meal);
            objectOutputStream.flush();
        } catch (Exception e) {
            System.out.println("File can not be written!");
        }
    }

    public static List<Object> readObjectFromFile(String fileName) {
        List<Object> obj = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            obj = (List<Object>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
//            System.out.println("The file was not found!");
            System.out.println(e);
        }
        return obj;
    }


//    public static void main(String[] args) {
//        Object ivan = new Object();
//        HashMap<String, Object> testо = new HashMap<>();
//        testо.put("Ivan", ivan);
////        writeObjectToFile(test);
//        String temp = String.valueOf(readObjectFromFile("src/ProgramFiles/.txt"));
//        System.out.println(temp);
//    }
}