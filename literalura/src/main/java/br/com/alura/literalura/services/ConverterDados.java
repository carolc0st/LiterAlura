package br.com.alura.literalura.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterDados implements  IConverterDados{
    private ObjectMapper mapper = new ObjectMapper();
//    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public <T> T conversorDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
