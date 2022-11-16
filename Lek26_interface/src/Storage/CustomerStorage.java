package Storage;

import Application.Model.Customer;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomerStorage {

    public static ArrayList<Customer> getAll() {
        return readJSON();
    }

    private static ArrayList<Customer> readJSON(){
        ArrayList<Customer> result = new ArrayList<Customer>();
        var fileName = "/Users/jakobnoermark/IdeaProjects/DMU/Lek26_interface/mock.json";

        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONArray a = new JSONArray(content);

        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;

            String name = person.getString("first_name") + " " + person.getString("last_name");
            String street = person.getString("street");
            String zip = "" + person.getInt("zip") + "00";
            String town = person.getString("town");
            Customer.SizeCategory category = getCategory(person.getInt("category"));
            double balance = person.getDouble("balance");

            Customer c = new Customer(name, street, zip, town, category, balance);
            result.add(c);
            //System.out.println(name);
        }
        return result;
    }

    private static Customer.SizeCategory getCategory(int value){
        if (1 <= value && value <= 4)
            return Customer.SizeCategory.values()[value];
        return Customer.SizeCategory.UNKNOWN;
    }



}
