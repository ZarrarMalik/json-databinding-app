package zarrar.malik.jsondomain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonDeserializerForData extends com.fasterxml.jackson.databind.JsonDeserializer<JsonData>{

    @Override
    public JsonData deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        ObjectCodec codec = parser.getCodec();
        JsonNode root = codec.readTree(parser);
        
        JsonData jsonData = new JsonData();
        jsonData.setId(Long.valueOf(root.get("Json Data class id: ").asText().replace("custom prefix", "")));
        jsonData.setKey1(root.get("Json Data class key1: ").asText());
        jsonData.setKey2(root.get("Json Data class key2: ").asText());
        
        return jsonData;
    }

}
