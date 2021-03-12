package q2;
//import java.util.Scanner;

public class Q2c {

    int cont; //contador para indicar o final da palavra
    char palavra[];

    public static void main(String[] args) {
        Q2c automato = new Q2c(); //Instancia o automato
        String sentenca[] = {"a", "b", "aab", "abb", "aabb", "aa", "bb"}; //array com as palavras de teste
        //Scanner entrada = new Scanner(System.in);
        //System.out.println("Entre com a sentença: ");
        //sentenca = entrada.nextLine();
        //automato.palavra = sentenca.toCharArray();

        //Varre o array de teste para testar as palavras
        for (int i = 0; i < sentenca.length; i++) {
            System.out.println("Teste para: " + sentenca[i]);
            automato.palavra = sentenca[i].toCharArray(); //converte as Strings em vetor de char
            automato.iniciar();

        }
    }

    public void iniciar() {
        cont = 0;
        q0();
    }

    //Estado inicial
    public void q0() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 'a') { //teste pra mudar de estado
                cont++;
                q1(); //muda de estado
            } else if (palavra[cont] == 'b') { //teste pra mudar de estado
                cont++;
                q2();
            } else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qErro();
        }
    }

    public void q1() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 'a') { //teste pra mudar de estado
                cont++;
                q3(); //muda de estado
            } else if (palavra[cont] == 'b') { //teste pra mudar de estado
                cont++;
                q1();
            } else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qFim();
        }
    }

    public void q2() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            qErro();
        } else {
            qFim();
        }
    }

    public void q3() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 'a') { //teste pra mudar de estado
                cont++;
                q3(); //muda de estado
            } else if (palavra[cont] == 'b') {
                cont++;
                q2();
            } else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qErro();
        }
    }
    
    //Estado de erro
    public void qErro() {
        System.out.println("PALAVRA REJEITADA PELO AUTOMATO!\n");
    }

    public void qFim() {
        System.out.println("PALAVRA ACEITA PELO AUTOMATO!\n"); //por ser estado final, verificou que a cadeia terminou então encerra o teste com sucesso   
    }
}
