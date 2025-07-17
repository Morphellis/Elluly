public class Task {

    private String title;
    private String description;
    private String status = "new";

    public void markAsCompleted(){
        status = "completed";
    }

    public String getStatus(){
        return status;
    }
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }

    public void setTitle(String title){this.title = title;}
    public void setDescription(String description){this.description = description;}
    public void setStatus(String status){this.status = status;}

    public void getDetails(){
        System.out.println("Title: " + title + "\nDescription: " + description + "\nStatus: " + status);
    }
}

