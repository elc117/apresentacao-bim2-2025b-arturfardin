import java.time.LocalDate;

public class GroupAssignment extends Assignment {
  private String teamMates;
  
  @Override
  public String message() {
    if(this.pending == false){
      return super.message();
    } else {
      return "Group " + super.message() + "- call " + this.teamMates;

    }
  }

  public GroupAssignment(LocalDate dueDate, String description, String teamMates) {
    super(dueDate, description); // Super serve pra chamar o construtor com argumentos da classe mãe, já que groupassignment é uma extensão de assignment
    this.teamMates = teamMates;
  }

}