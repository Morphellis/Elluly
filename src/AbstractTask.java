public abstract class AbstractTask {

    private String title;
    private String description;
    private String status = "new";
    private String completeonDate;

    AbstractTask(){
    }

    public String toString(){
        return title + "\t" + description + "\t" + status + "\t" + completeonDate;
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
