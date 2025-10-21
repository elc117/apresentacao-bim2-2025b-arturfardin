
import java.util.ArrayList;


public class Quiz {
    private String materia;
    private ArrayList<multiplaescolha> mult;
    private ArrayList<VouF> VouFs;



    public Quiz(String materia){
        this.materia = materia;
        this.mult = new ArrayList<>();
        this.VouFs = new ArrayList<>();
    }

    public void addMultiplaescolha(multiplaescolha q){
        this.mult.add(q);
    }
    public void addVouF(VouF q){
        this.VouFs.add(q);
    }


    public ArrayList<Character> getrespostasdousuario() {
        ArrayList<Character> respostas = new ArrayList<Character>();
        for (multiplaescolha x: mult) {
            respostas.add(x.getResposta());
        }
        for (VouF f: VouFs) {
            respostas.add(f.getResposta());
        }
        return respostas;
    }

     // primeira operação, mostrar as questões na tela.

    public void exibirTodasQuestoes() {

        System.out.println("Quiz de " + materia);
        System.out.println("Total de questões: " + (mult.size() + VouFs.size()) + "\n");
        
        for (multiplaescolha m : mult) {
            m.exibir();
        }
        for (VouF f : VouFs) {
            f.exibir();
        }

    }

      // segunda operação, contar os acertos e % de acerto

    public void verificarRespostas(){
        int acertos = 0;
        int total = mult.size() + VouFs.size();

        for (multiplaescolha m : mult) {
            if(m.verificaResposta(m.getResposta())){
                System.out.println("Questão " + m.getId() + ": Acertou");
                acertos++;
            } else {
                System.out.println("Questão " + m.getId() + ": Errou, Resposta correta: " + m.getRespostacorreta());
            }
        }
        for (VouF f : VouFs) {
            if(f.verificaResposta(f.getResposta())){
                System.out.println("Questão " + f.getId() + ": Acertou");
                acertos++;
            } else {
                System.out.println("Questão " + f.getId() + ": Errou, Resposta correta: " + f.getRespostacorreta());
            }
        } 

        double percentual = (acertos * 100) / total;
        System.out.println("\nAcertos = " + acertos + "/" + total);
        System.out.println("\nTaxa de acerto: " + percentual + "%");

    }

}
