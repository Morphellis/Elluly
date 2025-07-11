import  java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {

        String message;
        String choice;
        Scanner in = new Scanner(System.in);
        String[] tasks = new String[10];

        while (true){
            System.out.println("Введите выбор");
            choice = in.nextLine();
            if (choice.equals("exit")){
                System.out.println("До свидания!");
                break;
            }
            else if (choice.equals("add")){ // Цикл проходится по каждому значению массива, и если оно null, то он переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        System.out.println("Что ввести в " + i + " ячейку ?");
                        message = in.nextLine();
                        tasks[i] = message;
                        break;
                    }
                }
            }
            else if (choice.equals("list")){ // проходится по каждому элементу и если оно НЕ null, выводит его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null){
                        System.out.println("Задание " + i + ": " + tasks[i]);
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                System.out.println("Неизвестная команда");
            }

        }
    }
}