import java.util.Objects;

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

    @Override
    public String toString(){
        return super.toString()+ "\t" + dueDate;
    }

    @Override
    public boolean equals(Object o){

        if(!super.equals(o)){       //тоже самое что super.equals(0) == false;
            return false;           // Если родительский метод вернул false, возвращаем false в дочерний и выходим
        }

        UrgentTask urgentTask = (UrgentTask) o;
        return Objects.equals(this.dueDate, urgentTask.dueDate);
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), dueDate);
    }
}
