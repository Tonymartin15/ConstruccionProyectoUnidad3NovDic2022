import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class JsonTest{

    private String path = ("src/Json.json");

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

    /* 
    @Test
    public void ValidacionDeCreacionDeObjeto(){


        Json_Validate validacionJSON = new Json_Validate();
        validacionJSON.JSONval();
        boolean expectedResult = false;
        boolean actualResult = validacionJSON.isActive();
        assertEquals(expectedResult, actualResult);
    }
    */
}
