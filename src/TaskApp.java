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
            if (choice.equalsIgnoreCase("exit")){
                System.out.println("До свидания!");
                break;
            }
            else if (choice.equalsIgnoreCase("add")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        tasks[i] = new Task();
                        System.out.println("Введите заголовок");
                        tasks[i].setTitle(in.nextLine());
                        System.out.println("Введите описание ");
                        tasks[i].setDescription(in.nextLine());
                        break;
                    }

                }
            }
            else if (choice.equalsIgnoreCase("add_urgent")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] == null){
                        UrgentTask tempurgernt = new UrgentTask(); // создаем временную локальную переменную, чтобы работать с дочерним классом, впоследствии она будет стерта при выходе из условия
                        System.out.println("Введите заголовок");
                        tempurgernt.setTitle(in.nextLine());
                        System.out.println("Введите Описание");
                        tempurgernt.setDescription(in.nextLine());
                        System.out.println("Введите срок");
                        tempurgernt.setDueDate(in.nextLine());
                        tasks[i] = tempurgernt;
                        break;
                    }

                }
            }
            else if (choice.equalsIgnoreCase("list")){ // проходится по каждому элементу и если оно НЕ null, выводит его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null){
                        tasks[i].getDetails();
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
                            tasks[i].complete();
                            System.out.println(tasks[i].getStatus());
                        }
                    }
                }
                else if (Choice2.equalsIgnoreCase("y")){
                    for (int i = 0; i < tasks.length; i++ ){
                        if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                            System.out.println("Введите дату завершения");
                            String completionDate = in.nextLine();
                            tasks[i].complete(completionDate);
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
            else if (choice.equalsIgnoreCase("stats")){
                System.out.println(Task.getTaskCount());
            }
            else{
                System.out.println("Неизвестная команда");
            }


        }
    }
}