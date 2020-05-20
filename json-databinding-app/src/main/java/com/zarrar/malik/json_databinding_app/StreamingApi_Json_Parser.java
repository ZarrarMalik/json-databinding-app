package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;

public class StreamingApi_Json_Parser {
    
    public static void main(String[] args) throws JsonProcessingException, IOException {

    JsonFactory jsonFactory = new JsonFactory();

    File file = new File("streamingApi.json");
    JsonParser parser = jsonFactory.createParser(file);
    
    while(parser.nextToken() !=null){
        {
            JsonToken jsonToken = parser.getCurrentToken();
           // System.out.println(jsonToken);
            
            if(jsonToken.equals(JsonToken.FIELD_NAME)) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                
                if(fieldName.equals("object")) { //if it contains an object
                    while(parser.nextToken() != JsonToken.END_OBJECT) {
                        String nameField = parser.getCurrentName();
                        parser.nextToken(); //move to the value
                        if(nameField.equals("id")){
                            System.out.println("id: " + parser.getValueAsString());
                        }else if (nameField.equals("name")) {
                            System.out.println("name: " + parser.getValueAsString());
                        }else if (nameField.equals("lastname")) {
                            System.out.println("lastname: " + parser.getValueAsString());
                        }
                    }
                }
                
                if(fieldName.equals("array")) {
                    while(parser.nextToken() != JsonToken.END_ARRAY) {
                        if(parser.getCurrentToken().equals(JsonToken.START_OBJECT)) {
                            while(parser.nextToken() != JsonToken.END_OBJECT) {
                                parser.nextToken();
                                System.out.println(parser.getValueAsString());
                            }                           
                        }else {
                            System.out.println(parser.getValueAsString());
                        }
                    }
                    
                }
                
            }
        }
    }
    
    }
}
