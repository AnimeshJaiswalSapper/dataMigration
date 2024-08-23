//package ai.sapper.migration.DataMigration.convertor;
//
//import ai.sapper.migration.DataMigration.model.postgres.Entity;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//@Converter
//public class EntityConvertor implements AttributeConverter<List<Entity>, String> {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String convertToDatabaseColumn(List<Entity> attribute) {
//        try {
//            return objectMapper.writeValueAsString(attribute);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<Entity> convertToEntityAttribute(String dbData) {
//        if (dbData == null) {
//            return Collections.emptyList();
//        }
//        try {
//            return objectMapper.readValue(dbData, new TypeReference<List<Entity>>() {});
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}