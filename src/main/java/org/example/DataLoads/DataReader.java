package org.example.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        //convert the json file content to a String
        String jsonContent = FileUtils.readFileToString(new File("reservationDetails.json"), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String,String>> data = objectMapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
        //TypeReference is used to convert something from one type to another format

        return data;
    }

}
