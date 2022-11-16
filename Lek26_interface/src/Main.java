import Storage.CustomerStorage;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //CustomerStorage.getAll();
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
    }
}