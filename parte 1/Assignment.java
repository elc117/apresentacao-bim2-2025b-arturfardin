import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

// 1- Na classe assignment implementar public string toString() : X
// 2- Na classe assignment complementar o metodo status : 
// "done" se a tarefa estiver completa (não pendente) :
// "late" se a tarefa estiver pendente e atrasada : 
// "due in x days" se a tarefa estiver pendente, faltando x=daysLeft() dias para a entrega : 
// 3- Completar o metodo notificationMessage() : 
// 4- Na classe TrackAssignments, no final do método main,
// adicione um código para contar e mostrar a quantidade de tarefas concluídas (não pendentes) :



public class Assignment {

  protected LocalDate dueDate;
  protected String description;
  protected boolean pending;
  protected LocalDate submitDate;
  
  public Assignment(LocalDate dueDate, String description) {
    this.dueDate = dueDate;
    this.description = description;
    this.submitDate = null;
    this.pending = true;
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isPending() {
    return this.pending;
  }


  public void complete(LocalDate date) {
    this.submitDate = date;
    this.pending = false;
  }


  public int daysLeft() {
    return (int) ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
  }

  private String status() {
    if (isPending() == false){
      return "done";
    } else if (daysLeft() > 0){
      return "due in " + daysLeft() + "days";
    } else{
      return "late";
    } 
  }


  public String message() {
    return "Assignment " + this.description + " is " + status();
    
  }

  public String toString() {
    return "{ dueDate='" + this.dueDate + "', description='" + this.description + "', pending='" + this.pending +"', submitDate='" + this.submitDate + "' }"; // forma interessante de concatenação de strings
  }

}