public class Task {

    private static int taskCount = 0;
    private String title;
    private String description;
    private String status = "new";
    private String completeonDate;

    Task(){
        taskCount++;
    }
    public void markAsCompleted(){
        status = "completed";
    }
    public void markAsCompleted(String completeonDate){
    status = "completed";
    this.completeonDate = completeonDate;
    }

    public String getDateOfCompletion(){return completeonDate;};
    public String getStatus(){
        return status;
    }
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }

    public void setTitle(String title){this.title = title;}
    public void setDescription(String description){this.description = description;}
    public void setStatus(String status){this.status = status;}

    public static int getTaskCount(){return taskCount;};


    public void getDetails(){
        System.out.println("Title: " + title + "\nDescription: " + description + "\nStatus: " + status);

    }
}

