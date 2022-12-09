/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.JsonReader;

/**
 *
 * @author Francisco
 */
public class EmployeeDelete {
    
    boolean ValDelete=false;
    boolean PhotoVal = false;

    public boolean isActive(){
        return this.ValDelete;
    }
    
    public void EmployeeDelete(){
        String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a modificar");
        JsonReader Read = new JsonReader();
        Read.JsonReader();
        ArrayList<Employee> ArrayEmp = Read.getEmployees();
        JSONObject json = new JSONObject();
        JSONArray jsonArrayEmpleados = new JSONArray();
        JSONObject jsonEmployee = new JSONObject();
        int idEmpleado = 0;

        for (Employee employees : ArrayEmp) {
            JSONObject empleadotemp = new JSONObject();
            if (identificador.equals(employees.getId())) {
                ValDelete=true;
		} else{
                
                idEmpleado++;
                String idString = String.valueOf(idEmpleado);
                empleadotemp.put("id", idString);
                empleadotemp.put("firstName", employees.getName());
                empleadotemp.put("lastName", employees.getLastname());
                empleadotemp.put("photo", employees.getPhoto());
                jsonArrayEmpleados.put(empleadotemp);	
                }
               
                }

        jsonEmployee.put("employee", jsonArrayEmpleados);
        json.put("employees", jsonEmployee);

        String path = "src/Json.json"; 

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            String jsonString = json.toString();
            out.write(jsonString);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }
}
