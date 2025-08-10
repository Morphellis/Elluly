import java.util.*;

public class TaskApp {
    public static void main(String[] args) {

        String completedTask;
        String choice;
        Scanner in = new Scanner(System.in);
        NameComparator nameComparator = new NameComparator();
        Queue<AbstractTask> urgentQueue = new LinkedList<>();
        Map <Integer, AbstractTask> taskMap = new HashMap<>();

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
                            taskMap.put(tempTask.getID(), tempTask); // в конце ArrayList закидывается переменная tempTask
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
                            taskMap.put(tempTask.getID(), tempTask);
                        }catch (IllegalArgumentException e){
                            System.out.println("Заголовок не может быть пустым");
                        }
                        finally {
                            System.out.println("Результат добавления: " + (taskAdded ? "успех" : "ошибка"));
                        }



            }
            else if (choice.equalsIgnoreCase("list")){
                for (Map.Entry <Integer, AbstractTask> entry : taskMap.entrySet()) {
                    Integer key = entry.getKey();
                    AbstractTask value = entry.getValue();
                    System.out.println(key + value.toString());
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
                    for (int i = 0; i < taskMap.size(); i++ ){
                        if (taskMap.get(i).getTitle().equals(completedTask)) {
                            taskMap.get(i).markAsCompleted();
                            System.out.println(taskMap.get(i).getStatus());
                        }
                    }
                }
                else if (Choice2.equalsIgnoreCase("y")){
                    for (int i = 0; i < taskMap.size(); i++ ){
                        if (taskMap.get(i).getTitle().equals(completedTask)) {
                            System.out.println("Введите дату завершения");
                            String completionDate = in.nextLine();
                            taskMap.get(i).markAsCompleted(completionDate);
                            System.out.println(taskMap.get(i).getStatus());
                            System.out.println(taskMap.get(i).getDateOfCompletion());
                        }
                    }
                }

            }
            else if (choice.equalsIgnoreCase("status")){ //Временное решение по просмотру статуса того или иного задания
                System.out.println("Введите какую задачу, статус которой хотите посмотреть");
                completedTask = in.nextLine();
                for (AbstractTask value : taskMap.values()) {
                    if (value.getTitle().equals(completedTask)) {
                        System.out.println(value.getStatus());
                    }
                }
            }
            // пока не разобрался
//            else if(choice.equalsIgnoreCase("sort")){
//                System.out.println("Массив до сортировки:");
//                for (AbstractTask task : taskMap){
//                    System.out.println(task);
//                }
//                taskMap.sort(nameComparator);
//                System.out.println("\n--- Массив после сортировки по возрасту ---");
//                for (AbstractTask task : tasks){
//                    System.out.println(task);
//                }
//            }
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
                for(AbstractTask value : taskMap.values())
                    if (value.getTitle().equals(tempTask)) {
                        System.out.println("Введите какой хотите добавить тег");
                        value.setTags(Collections.singleton(in.nextLine())); //Метод, создающий коллекцию из одного объекта

                    }
            }

            else{
                System.out.println("Неизвестная команда");

            }
        }
    }
}