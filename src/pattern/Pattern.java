package pattern;

import service.face.Service;

import java.util.Map;
import java.util.Scanner;

public class Pattern {
    Scanner p = new Scanner(System.in);

    public void pattern(Service transnum, String a, String translation, String numeric){
        while (true){
            System.out.println("1: View");
            System.out.println("2: Add");
            System.out.println("3: Delete");
            System.out.println("4: Find");
            System.out.println("5: Exite");

            int massend = p.nextInt();
            p.nextLine();

            switch (massend) {
                case 1:
                    view(transnum);
                    break;
                case 2:
                    add(transnum, a);
                    break;
                case 3:
                    System.out.println("Введите ключ:");
                    String keyDel = p.nextLine();
                    delete(keyDel, transnum);
                    break;
                case 4:
                    System.out.println("Введите ключ:");
                    String keyFind = p.nextLine();
                    find(keyFind, transnum);
                    break;
                case 5:
                    transnum.saveToFile(massend(a, translation, numeric));
                    transnum.clearDictionary();
                    return;
                default:
                    System.out.println("Нет такого выбора. Выберите заново.");
            }
        }
    }
    public void view(Service transnum){
        for (Map.Entry<String, String> entry : transnum.printMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
    public void add(Service transnum, String a) {
        String errorDictionary1;
        System.out.println("Введите ключ: ");
        String key = p.nextLine();
        if (a.equals("1")){
            errorDictionary1 = "Длина должна быть 4 символа и только латинские!";
        }else {
            errorDictionary1 = "Длина должна быть 5 символов и только цифры!";
        }
        if (!key.equals("[a-zA-z]{4}")){
            System.out.println(errorDictionary1);
        } else {
            System.out.println("Введите значение:");
            String value = p.nextLine();
            transnum.addMap(key, value);
        }
    }
    public void addPlus(){

    }
    public void delete(String key, Service transnum){
        transnum.deleteMap(key);
    }
    public void find(String key, Service transnum){
        System.out.println(transnum.findMap(key));
    }
    public String massend(String a, String translation, String numeric){
        if (a.equals("1")) {return translation;} else {return numeric;}
    }
}

