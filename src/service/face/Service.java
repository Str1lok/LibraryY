package service.face;

import java.util.Map;


public interface Service {
    Map<String, String> printMap();
    void addMap(String key, String value);
    void deleteMap(String key);
    void loadFile(String filePath);

    void clearDictionary();

    void saveToFile(String filePath);
    String findMap(String key);
}
