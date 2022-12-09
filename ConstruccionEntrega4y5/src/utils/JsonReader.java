<<<<<<<< HEAD:ConstruccionEntrega1y2/src/utils/JsonReader.java
package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import modelos.Employee;

public class JsonReader {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {

            String content = Files.readString(Paths.get("src/Json.json"));
            JSONObject obj = new JSONObject(content);
            JSONObject jsonObject = obj.getJSONObject("employees");
            JSONArray jsonPersonData = jsonObject.getJSONArray("employee");

            for (int i = 0; i < jsonPersonData.length(); i++) {

                JSONObject item = jsonPersonData.getJSONObject(i);
                String id = item.getString("id");
                String name = item.getString("firstName");
                String lastname = item.getString("lastName");
                String photo = item.getString("photo");
                Employee newEmployee = new Employee(id, name, lastname, photo);
                employees.add(newEmployee);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return employees;

    }
}
========
package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import modelos.Employee;

public class JsonReader {
        
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public String JsonReader() {
        
        try {

            String content = Files.readString(Paths.get("src/Json.json"));
            JSONObject obj = new JSONObject(content);
            JSONObject jsonObject = obj.getJSONObject("employees");
            JSONArray jsonPersonData = jsonObject.getJSONArray("employee");
            StringBuilder st= new StringBuilder();

            for (int i = 0; i < jsonPersonData.length(); i++) {

                JSONObject item = jsonPersonData.getJSONObject(i);
                String id = item.getString("id");
                String name = item.getString("firstName");
                String lastname = item.getString("lastName");
                String photo = item.getString("photo");
                Employee newEmployee = new Employee(id, name, lastname, photo);
                 
                employees.add(newEmployee);
            }
            return st.toString();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
           
        }
        return "";

    }
    
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
>>>>>>>> QA:ConstruccionEntrega3/src/utils/JsonReader.java
