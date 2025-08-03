import  java.util.Scanner;
import java.util.Arrays;

public class TaskApp {
    public static void main(String[] args) {

        String completedTask;
        String choice;
        Scanner in = new Scanner(System.in);
        AbstractTask[] tasks = new AbstractTask[5];
        NameComparator nameComparator = new NameComparator();

        while (true){
            System.out.println("Введите выбор");
            choice = in.nextLine();
            if (choice.equalsIgnoreCase("exit")){
                System.out.println("До свидания!");
                break;
            }
            else if (choice.equalsIgnoreCase("add")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        boolean taskAdded = false; // Временная переменная для обработчика ошибок
                        System.out.println("Введите заголовок");
                        String tempTitle = in.nextLine();
                        System.out.println("Введите описание ");
                        String tempDescription = in.nextLine();
                        try {
                            AbstractTask tempTask = new SimpleTask();
                            tempTask.setTitle(tempTitle);
                            tempTask.setDescription(tempDescription);
                            taskAdded = true; // это работает, потому что если будет выкинута ошибка, то выполнение блока try сразу же заканчивается
                            tasks[i] = tempTask;
                        }catch (IllegalArgumentException e){
                            System.out.println("Заголовок не может быть пустым");
                            break;
                        }
                        finally {
                            System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                        }
                        break;
                    }

                }
            }
            else if (choice.equalsIgnoreCase("add_urgent")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        boolean taskAdded = false; // Временная переменная для обработчика ошибок
                        System.out.println("Введите заголовок");
                        String tempTitle = in.nextLine();
                        System.out.println("Введите описание ");
                        String tempDescription = in.nextLine();
                        System.out.println("Введите срок");
                        String tempDueDate = in.nextLine();
                        try{
                            UrgentTask tempTask = new UrgentTask();
                            tempTask.setTitle(tempTitle);
                            tempTask.setDescription(tempDescription);
                            tempTask.setDueDate(tempDueDate);
                            taskAdded = true;
                            tasks[i] = tempTask;
                        }catch (IllegalArgumentException e){
                            System.out.println("Заголовок не может быть пустым");
                            break;
                        }
                        finally {
                            System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                        }
                        break;
                    }
                }

            }
            else if (choice.equalsIgnoreCase("list")){ // проходится по каждому элементу и если оно НЕ null, выводит его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null){
                        System.out.println(tasks[i].toString());
                    }
                }
            }
            else if (choice.equalsIgnoreCase("complete")){ // Проверяет поле title у всех элементов массива и если находится нужное - вызывается метод complete, который переопределяет поле status с new на completed
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                System.out.println("Хотите ввести время завершения задачи? (y/n)");
                String Choice2 = in.nextLine();
                if (Choice2.equalsIgnoreCase("n")){
                    for (int i = 0; i < tasks.length; i++ ){
                        if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                            tasks[i].markAsCompleted();
                            System.out.println(tasks[i].getStatus());
                        }
                    }
                }
                else if (Choice2.equalsIgnoreCase("y")){
                    for (int i = 0; i < tasks.length; i++ ){
                        if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                            System.out.println("Введите дату завершения");
                            String completionDate = in.nextLine();
                            tasks[i].markAsCompleted(completionDate);
                            System.out.println(tasks[i].getStatus());
                            System.out.println(tasks[i].getDateOfCompletion());
                        }
                    }
                }

            }
            else if (choice.equalsIgnoreCase("status")){ //Временное решение по просмотру статуса того или иного задания
                System.out.println("Введите какую задачу, статус которой хотите посмотреть");
                completedTask = in.nextLine();
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                        System.out.println(tasks[i].getStatus());
                    }
                }
            }
            else if(choice.equalsIgnoreCase("sort")){
                System.out.println("Массив до сортировки:");
                System.out.println(Arrays.toString(tasks));
                Arrays.sort(tasks, nameComparator);
                System.out.println("\n--- Массив после сортировки по возрасту ---");
                System.out.println(Arrays.toString(tasks));
            }
            else{
                System.out.println("Неизвестная команда");
            }
        }
    }
}