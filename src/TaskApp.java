import java.util.*;

public class TaskApp {
    public static void main(String[] args) {

        String completedTask;
        String choice;
        Scanner in = new Scanner(System.in);
        List<AbstractTask> tasks = new ArrayList<>();
        NameComparator nameComparator = new NameComparator();
        Queue<AbstractTask> urgentQueue = new LinkedList<>();

        while (true){
            System.out.println("Введите выбор");
            choice = in.nextLine();
            if (choice.equalsIgnoreCase("exit")){
                System.out.println("До свидания!");
                break;
            }
            else if (choice.equalsIgnoreCase("add")){
                        boolean taskAdded = false; // Временная переменная для обработчика ошибок
                        System.out.println("Введите заголовок");
                        String tempTitle = in.nextLine();
                        System.out.println("Введите описание ");
                        String tempDescription = in.nextLine();
                        System.out.println("Хотите ввести тег? y/n");
                        Set <String> tempTags = new HashSet<>();
                        if (in.nextLine().equalsIgnoreCase("y")){
                            System.out.println("Введите тег");
                            tempTags.add(in.nextLine());
                        }
                        try {
                            SimpleTask tempTask = new SimpleTask();
                            tempTask.setTitle(tempTitle);
                            tempTask.setTags(tempTags);
                            tempTask.setDescription(tempDescription);
                            taskAdded = true; // это работает, потому что если будет выкинута ошибка, то выполнение блока try сразу же заканчивается
                            tasks.add(tempTask); // в конце ArrayList закидывается переменная tempTask
                        }catch (IllegalArgumentException e){
                            System.out.println("Заголовок не может быть пустым");
                        }
                        finally {
                            System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                        }


            }
            else if (choice.equalsIgnoreCase("add_urgent")){ // проходится по каждому значению массива и, если оно null, то переопределяет его
                        boolean taskAdded = false; // Временная переменная для обработчика ошибок
                        System.out.println("Введите заголовок");
                        String tempTitle = in.nextLine();
                        System.out.println("Введите описание ");
                        String tempDescription = in.nextLine();
                        System.out.println("Хотите ввести тег? y/n");
                        Set <String> tempTags = new HashSet<>();
                        if (in.nextLine().equalsIgnoreCase("y")){
                            System.out.println("Введите тег");
                            tempTags.add(in.nextLine());
                        }
                        System.out.println("Введите срок");
                        String tempDueDate = in.nextLine();
                        try{
                            UrgentTask tempTask = new UrgentTask();
                            tempTask.setTags(tempTags);
                            tempTask.setTitle(tempTitle);
                            tempTask.setDescription(tempDescription);
                            tempTask.setDueDate(tempDueDate);
                            taskAdded = true;
                            tasks.add(tempTask);
                        }catch (IllegalArgumentException e){
                            System.out.println("Заголовок не может быть пустым");
                        }
                        finally {
                            System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                        }



            }
            else if (choice.equalsIgnoreCase("list")){
                for (AbstractTask task : tasks) {
                    System.out.println(task.toString());
                }
            }
            else if (choice.equalsIgnoreCase("queue-list")){
                for (AbstractTask task : urgentQueue) {
                    System.out.println(task.toString());
                }
            }
            else if (choice.equalsIgnoreCase("complete")){ // Проверяет поле title у всех элементов массива и если находится нужное - вызывается метод complete, который переопределяет поле status с new на completed
                System.out.println("Введите какую задачу вы хотите завершить");
                completedTask = in.nextLine();
                System.out.println("Хотите ввести время завершения задачи? (y/n)");
                String Choice2 = in.nextLine();
                if (Choice2.equalsIgnoreCase("n")){
                    for (int i = 0; i < tasks.size(); i++ ){
                        if (tasks.get(i).getTitle().equals(completedTask)) {
                            tasks.get(i).markAsCompleted();
                            System.out.println(tasks.get(i).getStatus());
                        }
                    }
                }
                else if (Choice2.equalsIgnoreCase("y")){
                    for (int i = 0; i < tasks.size(); i++ ){
                        if (tasks.get(i).getTitle().equals(completedTask)) {
                            System.out.println("Введите дату завершения");
                            String completionDate = in.nextLine();
                            tasks.get(i).markAsCompleted(completionDate);
                            System.out.println(tasks.get(i).getStatus());
                            System.out.println(tasks.get(i).getDateOfCompletion());
                        }
                    }
                }

            }
            else if (choice.equalsIgnoreCase("status")){ //Временное решение по просмотру статуса того или иного задания
                System.out.println("Введите какую задачу, статус которой хотите посмотреть");
                completedTask = in.nextLine();
                for (AbstractTask task : tasks) {
                    if (task.getTitle().equals(completedTask)) {
                        System.out.println(task.getStatus());
                    }
                }
            }
            else if(choice.equalsIgnoreCase("sort")){
                System.out.println("Массив до сортировки:");
                tasks.forEach(task -> System.out.println(task.toString())); // Перебор через лямбду
                tasks.sort((task1, task2) -> task1.getTitle().compareTo(task2.getTitle())); // comparing через лямбду
                System.out.println("\n--- Массив после сортировки по возрасту ---");
                tasks.forEach(task -> System.out.println(task.toString()));
            }
            else if(choice.equalsIgnoreCase("add_to_urgent_queue")){
                boolean taskAdded = false;
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
                    urgentQueue.offer(tempTask);
                }catch (IllegalArgumentException e){
                    System.out.println("Заголовок не может быть пустым");
                    break;
                }
                finally {
                    System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                }
            }
            else if(choice.equalsIgnoreCase("add_tag")){
                System.out.println("К какой задаче хотите добавить тэг?");
                String tempTask = in.nextLine();
                for(AbstractTask task : tasks)
                    if (task.getTitle().equals(tempTask)) {
                        System.out.println("Введите какой хотите добавить тег");
                        task.setTags(Collections.singleton(in.nextLine())); //Метод, создающий коллекцию из одного объекта

                    }
            }

            else{
                System.out.println("Неизвестная команда");

            }
        }
    }
}