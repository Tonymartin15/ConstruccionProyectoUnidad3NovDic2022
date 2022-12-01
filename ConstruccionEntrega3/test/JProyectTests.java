/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.util.List;
import modelos.Employee;
import modelos.EmployeeModify;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.JsonReader;

/**
 *
 * @author Francisco
 */
public class JProyectTests {
    
    public JProyectTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     private String path = ("C:\\Users\\Francisco\\Downloads\\Firefox Downloads\\ConstruccionEntrega2\\ConstruccionEntrega2\\src\\Json.json");

    @Test
    public void ExisteArchivoJSON() {
        
        File file = new File(path);
        boolean expectedResult = true;
        boolean actualResult = false;
        if (file.exists()){
            actualResult = true;
            
        }
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ValidacionDeJSON() throws IOException {

        JsonValidator validacionJSON = new JsonValidator();
        validacionJSON.JSONval();
        boolean expectedResult = false;
        boolean actualResult = validacionJSON.isActive();
        assertEquals(expectedResult, actualResult);
    }

    
    @Test(expected = JSONException.class)
    public void ValidacionObjetoJSON(){
    JsonReader Read = new JsonReader();
    Read.JsonReader();
}
    
    @Test
    public void ValidacionDeModificacion() throws IOException {

        EmployeeModify validacionModif = new EmployeeModify();
        validacionModif.EdicionJson();
        boolean expectedResult = true;
        boolean actualResult = validacionModif.isActive();
        assertEquals(expectedResult, actualResult);
    }
}
