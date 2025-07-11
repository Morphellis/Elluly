import  java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {

        String completedTask;
        String choice;
        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[5];

        while (true){
            System.out.println("Введите выбор");
            choice = in.nextLine();
            if (choice.equals("exit")){
                System.out.println("До свидания!");
                break;
            }
            else if (choice.equals("add")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        tasks[i] = new Task();
                        System.out.println("Введите заголовок и описание");
                        tasks[i].title = in.nextLine();
                        tasks[i].description = in.nextLine();
                        break;
                    }

                }
            }
            else if (choice.equals("list")){ // проходится по каждому элементу и если оно НЕ null, выводит его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null){
                        System.out.println(i + ". Заголовок - " + tasks[i].title + "\n   Описание: " + tasks[i].description);
                    }
                }
            }
            else if (choice.equals("complete")){ // Проверяет поле title у всех элементов массива и если находится нужное - вызывается метод complete, который переопределяет поле status с new на completed
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null && tasks[i].title.equals(completedTask)) {
                        tasks[i].markAsCompleted();
                        System.out.println(tasks[i].getstatus());
                    }
                }
            }

            else if (choice.equals("status")){ //Временное решение по просмотру статуса того или иного задания
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null && tasks[i].title.equals(completedTask)) {
                        System.out.println(tasks[i].getstatus());
                    }
                }
            }
            else{
                System.out.println("Неизвестная команда");
            }


        }
    }
}