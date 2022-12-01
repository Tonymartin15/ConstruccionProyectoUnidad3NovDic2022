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
public class EmployeeModify {
    boolean Errors=true;
    boolean PhotoVal = false;

    public boolean isActive(){
        return this.Errors;
    }

	public void EdicionJson()
	{
		
        String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a modificar");
        JsonReader Read = new JsonReader();
        Read.JsonReader();
        ArrayList<Employee> ArrayEmp = Read.getEmployees();
        JSONObject json = new JSONObject();
        JSONArray jsonArrayEmpleados = new JSONArray();
        JSONObject jsonEmployee = new JSONObject();

        for (Employee employees : ArrayEmp) {
            JSONObject empleadotemp = new JSONObject();
            if (identificador.equals(employees.getId())) {
                String firstName = JOptionPane.showInputDialog("Ingresa el primer nombre del empleado " + identificador);
                String lastName = JOptionPane.showInputDialog("Ingresa el apellido del empleado " + identificador);
                String photo = "";
                while (PhotoVal == false){
                photo = JOptionPane.showInputDialog("Ingrese una imagen para el empleado "+ identificador + " Esta debe ser en formato JPG");
		Pattern p = Pattern.compile("[.jpg,https://]"); 
		Matcher m = p.matcher(photo);
		if (!m.find()){
                JOptionPane.showMessageDialog(null, "No se ha encontrado JPG valido");
		} else{
                    PhotoVal = true;
                }
                }
                
                empleadotemp.put("id", identificador);
                empleadotemp.put("firstName", firstName);
                empleadotemp.put("lastName", lastName);
                empleadotemp.put("photo", photo);
         
                if (firstName.equals(employees.getName())) {
                    Errors = false;
                    
                } else {
                    
                }
            } else {
                
                empleadotemp.put("id", employees.getId());
                empleadotemp.put("firstName", employees.getName());
                empleadotemp.put("lastName", employees.getLastname());
                empleadotemp.put("photo", employees.getPhoto());
                
            }
            jsonArrayEmpleados.put(empleadotemp);
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
