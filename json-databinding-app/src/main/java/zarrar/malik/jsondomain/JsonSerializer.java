package zarrar.malik.jsondomain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<JsonData>{

    @Override
    public void serialize(JsonData jsonData, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        
        generator.setPrettyPrinter(new DefaultPrettyPrinter());
        
        generator.writeStartObject();
        generator.writeFieldName("custom serialization");
        generator.writeString("Json data");
        
        generator.writeStringField("Json Data class id: ", "custom prefix" + jsonData.getId());
        generator.writeStringField("Json Data class key1: ", "custom prefix" + jsonData.getKey1());
        generator.writeStringField("Json Data class key2: ", "custom prefix" + jsonData.getKey2());
        generator.writeStringField("Json Data class Date: ", "custom prefix" + jsonData.getDate());
        
        generator.writeEndObject();
    }

}
