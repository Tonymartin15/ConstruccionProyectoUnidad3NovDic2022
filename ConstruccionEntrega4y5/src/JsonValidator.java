import java.io.IOException;
import java.io.InputStream;   
import java.util.Set;  
  
import com.fasterxml.jackson.databind.JsonNode;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import com.networknt.schema.JsonSchema;  
import com.networknt.schema.JsonSchemaFactory;  
import com.networknt.schema.SpecVersion;  
import com.networknt.schema.ValidationMessage;
  
public class JsonValidator {  

    boolean Errors=true;

    public boolean isActive(){
        return Errors;
    }
        
    private static InputStream inputStreamFromClasspath( String path ) {  
          
        return Thread.currentThread().getContextClassLoader().getResourceAsStream( path );  
    }  
           
        public void JSONval() throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();  
          
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);  
          
        try(  
                InputStream jsonStream = inputStreamFromClasspath( "json.json" );  
                InputStream schemaStream = inputStreamFromClasspath( "Json-Schema.json" )  
        ){  
               
            JsonNode json = objectMapper.readTree(jsonStream);  
  
            JsonSchema schema = schemaFactory.getSchema(schemaStream);  
              
            Set<ValidationMessage> validationResult = schema.validate( json );  
       
            if (validationResult.isEmpty()) {  
                Errors=false;
                System.out.println( "No hay errores en la validacion" );  
                
            } else {  
                   
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));  
            }  
           
        }  
        
    }
} 
