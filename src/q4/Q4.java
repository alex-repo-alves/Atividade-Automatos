package q4;

//import java.util.Scanner;
public class Q4 {

    int cont; //contador para indicar o final da palavra
    int palavra[] = {100, 25, 25, 25, 25, 100, 50, 50, 100, 100, 25, 50, 25, 50, 25, 25, 100};

    public static void main(String[] args) {
        Q4 automato = new Q4(); //Instancia o automato
        //int sentenca[] = {100, 25, 25, 25, 25,100,50,50,100,100,25,50,25,50,25,25,100}; //array com as palavras de teste
        //Scanner entrada = new Scanner(System.in);
        //System.out.println("Entre com a sentença: ");
        //sentenca = entrada.nextLine();
        //automato.palavra = sentenca.toCharArray();

        automato.iniciar();
    }

    public void iniciar() {
        cont = 0;
        q0();
    }

    //Estado inicial
    public void q0() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 100) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q0(); //muda de estado
            } else if (palavra[cont] == 25) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q1();
            } else if (palavra[cont] == 50) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q2();
            }else {
                qErro();
            }
        } else {
            qFim(); //fim da execução
        }
    }

    public void q1() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 100) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q1(); //muda de estado
            } else if (palavra[cont] == 25) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q2();
            } else if (palavra[cont] == 50) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q4();
            }else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qFim();
        }
    }

    public void q2() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 100) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q2(); //muda de estado
            } else if (palavra[cont] == 25) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q4();
            } else if (palavra[cont] == 50) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q3();
            }else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qFim();
        }
    }

    public void q3() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 100) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q3(); //muda de estado
            } else if (palavra[cont] == 25) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q1();
            } else if (palavra[cont] == 50) { //teste pra mudar de estado
                System.out.print(0+" ");
                cont++;
                q2();
            }else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qFim();
        }
    }
    
    public void q4() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 100) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q4(); //muda de estado
            } else if (palavra[cont] == 25) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q3();
            } else if (palavra[cont] == 50) { //teste pra mudar de estado
                System.out.print(1+" ");
                cont++;
                q1();
            }else {
                qErro();//não pertence ao vocabulário?
            }
        } else {
            qFim();
        }
    }

    //Estado de erro
    public void qErro() {
        System.out.println("PALAVRA REJEITADA PELO AUTOMATO!\n");
    }

    public void qFim() {
        System.out.println("\nFIM!"); //por ser estado final, verificou que a cadeia terminou então encerra o teste com sucesso   
    }
}
