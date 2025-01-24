package service.impl;

import service.face.Service;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ServiceImpl implements Service {

    private Map<String, String> dictionary = new HashMap<String, String>();
    public Map<String, String> printMap() {
        return dictionary;
    }
    @Override
    public void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            String json = jsonContent.toString();
            json = json.substring(1, json.length() - 1);
            String[] entries = json.split(",");
            for (String entry : entries) {
                String[] keyValue = entry.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].replace("\"", "").trim();
                    String value = keyValue[1].replace("\"", "").trim();
                    dictionary.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void clearDictionary(){
        dictionary.clear();
    }
    @Override
    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("{");
            Iterator<Map.Entry<String, String>> iterator = dictionary.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                writer.write("\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"");
                if (iterator.hasNext()) {
                    writer.write(",");
                }
            }
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMap(String key, String value) {
        dictionary.put(key, value);
    }
    @Override
    public void deleteMap(String key) {
        dictionary.remove(key);
    }
    @Override
    public String findMap(String key){
        return dictionary.get(key);
    }
}
