public class Task {
    String title;
    String description;
    String status = "new";

    public void markAsCompleted(){
        status = "completed";
    }
    public String getstatus(){
        return status;
    }

}
