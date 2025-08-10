import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTask {

    private static int ID = 0;

    public Set<String> tags = new HashSet<>();

    private int currentID;
    private String title;
    private String description;
    private String status = "new";
    private String completeonDate;

    AbstractTask(){
        this.currentID = ID;
        ID++;
    }

    @Override
    public String toString(){
        completeonDate = completeonDate == null ? "-" : completeonDate;
        return "ID: " + currentID + "\t" + "Тэги: " + tags + "\t"+ " Заголовок: " + title + "\t"+ "Описание: " + description + "\t"+ "Статус: " + status + "\t" + "Дата завершения: " + completeonDate + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверяем, не сравниваем ли мы объект сам с собой
        if (this == obj) return true;
        // 2. Проверяем, не пришел ли null и совпадают ли классы
        if (obj == null || getClass() != obj.getClass()) return false;
        // 3. Приводим объект obj к нашему типу
        AbstractTask task = (AbstractTask) obj;
        return Objects.equals(this.title, task.title) && Objects.equals(this.description, task.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, description);
    }

    public void markAsCompleted(){
        status = "completed";
    }
    public void markAsCompleted(String completeonDate){
        status = "completed";
        this.completeonDate = completeonDate;
    }

    public String getDateOfCompletion(){return completeonDate;}
    public String getStatus(){return status;}
    public String getTitle(){ return title; }

    public void setDescription(String description){this.description = description;}
    public void setStatus(String status){this.status = status;}

    public void setTitle(String title){
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        else{
        this.title = title;
        }
    }

    public void setTags(Set<String> tags){
        if (tags != null) {
            this.tags.addAll(tags);
            // Используем addAll, чтобы добавить все теги из другого набора, а не заменить старые.
            // Это позволяет добавлять сразу несколько тегов (например, из строки "тег1 тег2").
        }
    }
}
