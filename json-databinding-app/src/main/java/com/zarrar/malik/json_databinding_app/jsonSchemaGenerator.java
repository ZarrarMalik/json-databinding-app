package com.zarrar.malik.json_databinding_app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

import zarrar.malik.jsondomain.LectureSchema;

public class jsonSchemaGenerator {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SchemaFactoryWrapper factoryWrapper = new SchemaFactoryWrapper();
        objectMapper.acceptJsonFormatVisitor(objectMapper.constructType(LectureSchema.class), factoryWrapper);
        JsonSchema jsonSchema = factoryWrapper.finalSchema();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));

    }

}
