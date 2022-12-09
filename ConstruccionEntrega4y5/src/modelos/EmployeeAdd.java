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
public class EmployeeAdd {
    
    boolean Errors=true;
    boolean PhotoVal = false;
    int NumeroDeEmpleados = 0;
    //int ValidacionEmpleado = 0;

    public boolean isActive(){
        return this.Errors;
    }
    
    public int EmployeeCount(){
        return this.NumeroDeEmpleados;
    }
    
    
    public void EmployeeCounter(){
        JsonReader Read = new JsonReader();
        Read.JsonReader();
        ArrayList<Employee> ArrayEmp = Read.getEmployees();
        for(Employee employees : ArrayEmp){
			NumeroDeEmpleados++;
                        
		}
    }
    
    public void EmployeeAdd(){
        JsonReader Read = new JsonReader();
        Read.JsonReader();
        ArrayList<Employee> ArrayEmp = Read.getEmployees();
        JSONObject json = new JSONObject();
        JSONArray jsonArrayEmpleados = new JSONArray();
        JSONObject jsonEmployee = new JSONObject();
       
        for(Employee employees : ArrayEmp){
			JSONObject empleadotemp = new JSONObject();
			empleadotemp.put("id", employees.getId());
                        empleadotemp.put("firstName", employees.getName());
                        empleadotemp.put("lastName", employees.getLastname());
                        empleadotemp.put("photo", employees.getPhoto());
			jsonArrayEmpleados.put(empleadotemp);
                        
		}
		String idString = String.valueOf(NumeroDeEmpleados);
		JSONObject empleadotemp = new JSONObject();
		String firstName = JOptionPane.showInputDialog(null, "Ingresa el primer nombre del empleado");
		String lastName = JOptionPane.showInputDialog(null, "Ingresa el apellido del empleado ");
                while (PhotoVal == false){
                String photo = JOptionPane.showInputDialog("Ingrese una imagen para el empleado "+ NumeroDeEmpleados + " Esta debe ser un url Valido");
		Pattern p = Pattern.compile("https://"); 
		Matcher m = p.matcher(photo);
		if (!m.find()){
                JOptionPane.showMessageDialog(null, "No se ha encontrado un link de imagen valido");
		} else{
                    PhotoVal = true;
                    NumeroDeEmpleados++;
                }
		empleadotemp.put("id", idString);
		empleadotemp.put("firstName", firstName);
		empleadotemp.put("lastName", lastName);
		empleadotemp.put("photo", photo);
		jsonArrayEmpleados.put(empleadotemp);
                Errors=true;

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
}
