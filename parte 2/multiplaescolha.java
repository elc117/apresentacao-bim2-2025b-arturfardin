

public class multiplaescolha extends Question {
    private char resposta;

    public multiplaescolha(int id, String enunciado, char resposta, char respostacorreta) {
        super(id, enunciado, respostacorreta);
        this.resposta = resposta;
    }

    public char getResposta(){
        return this.resposta;
    }

}
