
# Conceitos estudados
## Palavra-chave super, toString() e @Override
 `Super:` É uma palavra-chave utilizada em certas situações quando queremos nos referir à classe "mãe". Ela nos permite utilizar métodos, chamar construtores e até acessar campos da classe principal.
#### Exemplo
```
public multiplaescolha(int id, String enunciado, char resposta, char respostacorreta) {
  super(id, enunciado, respostacorreta);
  this.resposta = resposta;
}
```
Aqui vemos o super sendo utilizado para chamar o construtor da classe Question, que é a classe principal do programa.

`toString():` É um metodo que transforma um objeto em sua versão "stringficada". Muito util para debugs.
#### Exemplo
```
public String toString() {
    return "{ dueDate='" + this.dueDate + "', description='" + this.description + "', pending='" + this.pending +"', submitDate='" + this.submitDate + "' }";
  }
```
Aqui podemos ver como seria um método toString().

`@Override: `É uma anotação que permite sobrescrever um método e editá-lo especificamente para outra classe "filha".
#### Exemplo
```
// Método message() da classe Assignment
public String message() {
    return "Assignment " + this.description + " is " + status()
  }

// Método message() da classe GroupAssignment

@Override
public String message() {
  if(this.pending == false){
    return super.message();
  } else {
    return "Group " + super.message() + "- call " + this.teamMates;
  }
}
```
Aqui vemos a utilização do @Override na prática. O método message já existe na classe Assignments, porém, para não precisar criar um novo método, utilizamos o método da classe principal com algumas alterações.

## Parte 1
Na parte 1, precisamos analisar um código de gerenciamento de tarefas e complementar o que estava faltando, além de corrigir possíveis erros.

A primeira etapa foi implementar o método *toString()*, que foi feito para retornar uma string em uma formatação específica.
#### Exemplo de como deveria ficar
 ```
 dueDate='2024-11-28', description='game', pending='true', submitDate='null'
```
Após isso, deveríamos completar o método *status* para que seguisse uma certa lógica:
```
"done" se a tarefa estiver completa (não pendente)
"late" se a tarefa estiver pendente e atrasada
"due in x days" se a tarefa estiver pendente, faltando x=daysLeft() dias para a entrega
```
A terceira etapa era completar o método message da classe *GroupAssignment*, para retornar uma mensagem diferente caso a tarefa fosse feita em grupo.
```
public GroupAssignment(LocalDate dueDate, String description, String teamMates) {
    super(dueDate, description); 
    this.teamMates = teamMates;
}
```
A última etapa foi criar um código que contasse quantas tarefas foram concluídas.

```
    for (Assignment item : list){
      if (item.pending == false){
        vezes++;
      }
    }
    System.out.println("==> Completed assignments: " + vezes);
  }
```

*Parte facil*: Criação do método toString().
*Parte não tão facil*: Perceber que compareTo não retorna o valor de dias entre duas datas.

## Execução do código


https://github.com/user-attachments/assets/7a546145-d1fd-49fe-bff3-96dc0e69a09b




## Parte 2
Nesta parte, o objetivo era construir um pequeno projeto de quiz interativo utilizando herança. O programa possui uma hierarquia de classes onde *Question* é a classe principal, e as classes *multiplaescolha* e *VouF* são extensões dela, representando diferentes tipos de questões.
Além disso, foi necessário criar duas operações utilizando a lista de questões.

### Estrutura do programa
`Question:` Classe base que contém atributos e métodos comuns a qualquer tipo de questão, como o enunciado, a resposta correta e o método que verifica se a resposta do usuário está certa.

`multiplaescolha:` Subclasse que representa questões com múltipla escolha. Possui o atributo resposta, que guarda a alternativa escolhida pelo usuário.

`VouF:` Subclasse que representa questões de verdadeiro ou falso, com lógica parecida com a da múltipla escolha, mas usando apenas *V* ou *F* como resposta.

`Quiz:` Classe que organiza as questões, armazena as respostas e permite o gerenciamento do quiz.

`Main:` Classe responsável por criar o quiz, adicionar as perguntas e simular a execução.


### Operações
```
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
```

Essa operação serve para mostrar todas as questões da lista/quiz.

```
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
```
Essa operação faz a verificação da lista: ela compara as respostas do usuário utilizando o método *verificaResposta()* e incrementa o contador de acertos caso o retorno seja true. Também calcula o percentual de acertos e mostra a quantidade de respostas corretas.

*Parte facil*: Criação da classe *question* e método *verificaResposta()*.
*Parte não tão facil*: Decidir quais atributos ficariam nas subclasses.

## Execução do código

https://github.com/user-attachments/assets/6fec353d-0e1a-4642-b5f5-d47359cd3005


## Referências

https://pt.stackoverflow.com/questions/66563/para-que-serve-fun%C3%A7%C3%A3o-super
https://www.w3schools.com/java/ref_keyword_super.asp
http://www.mauda.com.br/?p=1472
https://pt.stackoverflow.com/questions/22913/qual-a-finalidade-da-override
https://pt.stackoverflow.com/questions/98324/calcular-diferen%C3%A7a-entre-datas
https://pt.stackoverflow.com/questions/212754/qual-%C3%A9-a-fun%C3%A7%C3%A3o-do-m%C3%A9todo-tostring








