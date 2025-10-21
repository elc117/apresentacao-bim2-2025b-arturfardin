public class Main {
    
    public static void main(String[] args){
        Quiz quiz = new Quiz("Matemática");

        multiplaescolha q1 = new multiplaescolha(1, "Quanto é 10x5.\nA) 50\nB) 45\nC) 30\nD) 90\nE) 65", 'A', 'A');
        multiplaescolha q2 = new multiplaescolha(2, "Quanto é 95 - 34.\nA) 51\nB) 71\nC) 72\nD) 61\nE) 23", 'A', 'D');
        
        VouF q3 = new VouF(3, "A soma dos quadrados dos catetos de um triângulo retângulo é igual ao quadrado da hipotenusa (V/F)", 'V', 'V');
        VouF q4 = new VouF(4, "são os lados do triângulo que formam o ângulo reto. São classificados em: cateto adjacente e cateto oposto (V/F)", 'V', 'F');


        quiz.addMultiplaescolha(q1);
        quiz.addMultiplaescolha(q2);
        quiz.addVouF(q3);
        quiz.addVouF(q4);

        quiz.exibirTodasQuestoes();
        System.out.println("\nCorreção das questões:");

        quiz.verificarRespostas();
    }
    
}
