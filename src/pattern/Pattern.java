package pattern;

import service.face.Service;
import service.impl.ServiceImpl;

import java.util.Map;
import java.util.Scanner;

public class Pattern {
    private Service service = new ServiceImpl();
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
                    add();
                    break;
                case 3:
                    System.out.println("Введите ключ:");
                    String keyDel = p.nextLine();
                    delete(keyDel);
                    break;
                case 4:
                    System.out.println("Введите ключ:");
                    String keyFind = p.nextLine();
                    find(keyFind);
                    break;
                case 5:
                    transnum.saveToFile(massend(a, translation, numeric));
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
    public void add() {
        System.out.println("Введите ключ:");
        String key = p.nextLine();
        System.out.println("Введите значение:");
        String value = p.nextLine();
        service.addMap(key, value);
    }
    public void delete(String key){
        service.deleteMap(key);
    }
    public void find(String key){
        System.out.println(service.findMap(key));
    }
    public String massend(String a, String translation, String numeric){
        if (a.equals("1")) {return translation;} else {return numeric;}
    }
}

