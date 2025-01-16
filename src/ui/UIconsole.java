package ui;

import pattern.Pattern;
import service.face.Service;
import service.impl.ServiceImpl;

import java.util.Scanner;

public class UIconsole {
    private String translation= "src/dictionary/DictionaryTranslation.json";
    private String numeric = "src/dictionary/DictionaryNumeric.json";
    private String a = null;
    private Service transnum = new ServiceImpl();
    private Pattern pattern = new Pattern();
    Scanner p = new Scanner(System.in);
    public void uiConsole(){
        while (true) {
            System.out.println("Выбирете словарь: 1 - с переводом 2 - с числами 3 - выход");
            a = p.nextLine();
            switch (a) {
                case "1":
                    transnum.loadFile(translation);
                    pattern.pattern(transnum, a, translation, numeric);
                    break;
                case "2":
                    transnum.loadFile(numeric);
                    pattern.pattern(transnum, a, translation, numeric);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("нет такого выбора, попробуйте еще раз");
            }
            a = null;
        }
    }
}
