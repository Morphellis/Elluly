public class UrgentTask extends AbstractTask {

    private String dueDate;
    public void setDueDate(String dueDate) {this.dueDate = dueDate;}
    public String getDueDate() {return this.dueDate;}

    UrgentTask(){
        super(); //Это можно вообще не писать, т.к. это выполнится неявно в любом случае
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Due Date: " + getDueDate());
    }

    public String toString(){
        return super.toString()+ "\t" + dueDate;
    }
}
