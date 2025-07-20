public class UrgentTask extends Task{

    private String dueDate;
    public void setDueDate(String dueDate) {this.dueDate = dueDate;}
    public String getDueDate() {return this.dueDate;}

    UrgentTask(){
        super(); //Это можно вообще не писать, т.к. это выполнится неявно в любом случае
    }

    public void getDetails() {
        super.getDetails();
        System.out.println("Due Date: " + this.dueDate);
    }
}
