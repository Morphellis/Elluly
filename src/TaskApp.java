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
                        tasks[i].setTitle(in.nextLine());
                        tasks[i].setDescription(in.nextLine());
                        break;
                    }

                }
            }
            else if (choice.equals("add_urgent")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
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
            else if (choice.equals("list")){ // проходится по каждому элементу и если оно НЕ null, выводит его
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null){
                        System.out.println(i + ". Заголовок - " + tasks[i].getTitle() + "\n   Описание: " + tasks[i].getDescription());
                    }
                }
            }
            else if (choice.equals("complete")){ // Проверяет поле title у всех элементов массива и если находится нужное - вызывается метод complete, который переопределяет поле status с new на completed
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                        tasks[i].markAsCompleted();
                        System.out.println(tasks[i].getStatus());
                    }
                }
            }

            else if (choice.equals("status")){ //Временное решение по просмотру статуса того или иного задания
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                for (int i = 0; i < tasks.length; i++ ){
                    if (tasks[i] != null && tasks[i].getTitle().equals(completedTask)) {
                        System.out.println(tasks[i].getStatus());
                    }
                }
            }
            else{
                System.out.println("Неизвестная команда");
            }


        }
    }
}