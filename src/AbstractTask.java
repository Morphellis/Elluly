import java.util.Objects;

public abstract class AbstractTask {

    private String title;
    private String description;
    private String status = "new";
    private String completeonDate;

    AbstractTask(){
    }

    @Override
    public String toString(){
        return title + "\t" + description + "\t" + status + "\t" + completeonDate;
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
    public String getStatus(){
        return status;
    }
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }

    public void setTitle(String title){
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        else{
        this.title = title;
        }
    }
    public void setDescription(String description){this.description = description;}
    public void setStatus(String status){this.status = status;}


    public void printDetails(){
        System.out.println("Title: " + title + "\nDescription: " + description + "\nStatus: " + status);

    }
}
