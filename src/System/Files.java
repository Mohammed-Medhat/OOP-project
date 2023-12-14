package System;
import User.Person;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Files {
    public static void writePeopleToFile(List<User.Person> people, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static List<Person> readPeopleFromFile(String fileName) {
        List<Person> people = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            people = (List<Person>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
}
}