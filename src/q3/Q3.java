package q3;

import java.util.ArrayList;

public class Q3 {

    int cont; //contador para indicar o final da palavra
    char palavra[];
    int contaPC; //conta quantas vezes computador aparecu
    //char estados[] = {'c', 'o', 'm', 'p', 'u', 't', 'a', 'd', 'o', 'r'}; //o índice do vetor indica o estado que será testado
    ArrayList<Integer> posicoes = new ArrayList(); //lista das posições dos matchs com computador

    public static void main(String[] args) {
        Q3 automato = new Q3(); //Instancia o automato
        automato.contaPC = 0; //Inicializa contador
        String sentenca = "O computador é uma máquina capaz de variados tipos de tratamento automático de informações ou processamento de dados. Entende-se por computador um sistema físico que realiza algum tipo de computação. Assumiu-se que os computadores pessoais e laptops são ícones da era da informação. O primeiro computador eletromecânico foi construído por Konrad Zuse (1910–1995). Atualmente, um microcomputador é também chamado computador pessoal ou ainda computador doméstico."; //array com as palavras de teste
        //Scanner entrada = new Scanner(System.in);
        //System.out.println("Entre com a sentença: ");
        //sentenca = entrada.nextLine();
        automato.palavra = sentenca.toCharArray(); //converte a String para um vetor de char;
        automato.iniciar();

    }

    public void iniciar() {
        cont = 0;
        q0();

    }

    //Estado inicial
    public void q0() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (palavra[cont] == 'c' && palavra[cont - 1] == ' ') { //teste pra mudar de estado
                posicoes.add(cont); //salva a posição do possível computador
                //System.out.println(cont);
                contaPC++; //pode ter achado um computador então incrementa o contador
                cont++;
                q1(); //muda para o estado q1
            } else if (palavra[cont] == 'c' && cont == 0) { //testa se computador está no início da sentença assumindo que a frase não começa com letra maiúscula
                contaPC++;
                cont++;
                q1();
            } else { //continua no estado atual se não encontrou um c e continua varrendo o vetor
                cont++;
                q0();
            }
        } else { //chegou no final do vetor
            qFim();
        }
    }

    //como os estados possuem o mesmo comportamento
    public void q1() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'o') { //teste pra mudar de estado
                cont++;
                q2();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q2() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'm') { //teste pra mudar de estado
                cont++;
                q3();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }

    
    public void q3() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'p') { //teste pra mudar de estado
                cont++;
                q4();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q4() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'u') { //teste pra mudar de estado
                cont++;
                q5();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q5() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 't') { //teste pra mudar de estado
                cont++;
                q6();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q6() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'a') { //teste pra mudar de estado
                cont++;
                q7();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q7() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'd') { //teste pra mudar de estado
                cont++;
                q8();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    public void q8() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'o') { //teste pra mudar de estado
                cont++;
                q9();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    public void q9() {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char

            if (palavra[cont] == 'r' && (palavra[cont+1] == ' ' || palavra[cont+1] == '.')) { //teste pra mudar de estado
                cont++;
                q0();
            } else {
                cont++;
                qErro();//não pertence ao vocabulário?
                q0();
            }

        } else {
            qErro();
            qFim();
        }
    }
    
    /*
    public void qGenerico(int i) {
        if (cont < palavra.length) { //verifica se já está no final da cadeia de char
            if (i < estados.length) {
                if (palavra[cont] == estados[i]) { //teste pra mudar de estado
                    cont++;
                    qGenerico(i + 1);
                } else {
                    cont++;
                    qErro();//não pertence ao vocabulário?
                    q0();
                }
            } else if (palavra[cont] == ' ' || palavra[cont] == '.') {
                cont++;
                q0();
            } else {
                cont++;
                qErro();
                q0();
            }
        } else {
            qErro();
            qFim();
        }
    }*/
    //Estado de erro
    public void qErro() {
        posicoes.remove(contaPC - 1);
        contaPC--;

    }

    public void qFim() {
        System.out.print("computador aparece nas posições: "); //por ser estado final, verificou que a cadeia terminou então encerra o teste com sucesso   
        int n = posicoes.size();
        for (int i = 0; i < n; i++) {
            System.out.print(posicoes.get(i) + " ");
        }
    }
}
