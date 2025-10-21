
// Parte 2: Herança em Quizzes
// Nesta parte, você vai criar um programa "do zero", escrevendo todo o código. 
// O programa deverá ter uma hierarquia de classes representando diferentes tipos de questões de quizzes, 
// uma classe representando um quiz e um programa principal que irá criar e fazer algumas operações com um quiz.

// Crie uma superclasse Question, com atributos/métodos comuns a qualquer tipo de quiz (você tem liberdade para defini-los - 
// não há uma única forma correta de representar isso).

// Crie pelo menos 2 classes derivadas de Question, representando outros tipos de questões, por exemplo: 
// verdadeiro/falso, múltipla-escolha, preencher lacunas, etc. Estas classes especializadas deverão ter atributos específicos.

//Crie uma classe Quiz, que deverá armazenar e gerenciar uma lista de questões, 
//como no exemplo com herança na classe Group da aula anterior.

//Crie uma classe Main, que deverá criar um quiz com várias questões de diferentes classes.
//Depois de criá-lo, você deverá fazer pelo menos 2 operações à sua escolha 
//(por exemplo, mostrar as questões, verificar resposta de uma questão, sortear uma questão, etc.), 
//de acordo com os métodos que você implementou na classe Quiz.
public class Question {
    protected String descricao;
    protected int id;
    protected char respostacorreta;


    public Question(int id, String descricao, char respostacorreta){
        this.id = id;
        this.descricao = descricao;
        this.respostacorreta = respostacorreta;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getId(){
        return this.id;
    }

    public char getRespostacorreta(){
        return this.respostacorreta;
    }

    public boolean verificaResposta(char resposta){
        return Character.toLowerCase(this.respostacorreta) == Character.toLowerCase(resposta);
    }

    public void exibir(){
        System.out.println("Questão " + id + ": " + descricao);
    }

    

    
}
