import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите номер операции:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            System.out.println("5. Завершить");

            String input = scanner.nextLine();
            if ("5".equals(input)) {
                break;
            }
            if ("1".equals(input)) {
                System.out.println("Какую покупку хотите добавить?");
                input = scanner.nextLine();
                list.add(input);
                System.out.println("Итого в списке покупок: " + list.size());
            } else if ("2".equals(input)) {
                printList(list);
            } else if ("3".equals(input)) {
                printList(list);
                System.out.println("Какую хотите удалить? Введите номер или название");
                input = scanner.nextLine();
                int num;
                try {
                    num = Integer.parseInt(input);
                    if (num <= list.size() && num >= 0) {
                        System.out.print("Покупка " + list.remove(num - 1) + " удалена, ");
                        printList(list);
                    }
                } catch (NumberFormatException e) {
                    if (list.remove(input)) {
                        System.out.print("Покупка " + input + " удалена, ");
                        printList(list);
                    } else {
                        System.out.println("ПОКУПКИ " + input + " НЕТ В СПИСКЕ!");
                    }
                }
            } else if ("4".equals(input)) {
                System.out.println("Введите текст для поиска:");
                input = scanner.nextLine();
                String queryLower = input.toLowerCase();
                String itemLower;
                String item;
                System.out.println("Найдено:");
                for (int i = 0; i < list.size(); i++) {
                    item = list.get(i);
                    itemLower = item.toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println(i + 1 + ". " + item);
                    }
                }
            }
        }
    }

    public static void printList(List<String> list) {
        System.out.println("Список покупок:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }
    }
}
