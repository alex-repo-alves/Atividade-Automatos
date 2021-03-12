package q1;
//import java.util.Scanner;
public class Q1a {
    int cont; //contador para indicar o final da palavra
    char palavra [];
    public static void main(String[] args) {
        Q1a automato = new Q1a(); //Instancia o automato
        String sentenca[] = {"0","0100","100","1", "1001","010","0001"}; //array com as palavras de teste
        //Scanner entrada = new Scanner(System.in);
        //System.out.println("Entre com a sentença: ");
        //sentenca = entrada.nextLine();
        //automato.palavra = sentenca.toCharArray();
        
        //Varre o array de teste para testar as palavras
        for (int i = 0; i < sentenca.length; i++) {
            System.out.println("Teste para: "+sentenca[i]);
            automato.palavra = sentenca[i].toCharArray(); //converte as Strings em vetor de char
            automato.iniciar();
          
        }      
    }
    
    public void iniciar(){
        cont = 0;
        q0();
    }
    
    //Estado inicial
    public void q0(){ 
        if (cont<palavra.length){ //verifica se já está no final da cadeia de char
            if (palavra[cont] == '1'){ //teste pra mudar de estado
                cont++;
                q1(); //muda de estado
            } else if(palavra[cont] == '0'){
                cont++;
                q0();//continua no mesmo estado
            } else {
                qErro();//não pertence ao vocabulário?
            }
        } else{
            qFim(); //por ser estado final, verificou que a cadeia terminou então encerra o teste com sucesso
        } 
    }
    
    public void q1(){
        if (cont<palavra.length){
            if (palavra[cont] == '0'){
                cont++;
                q2();
            }else {
                qErro();
            }
        } else{
            qErro();
        }
    }
    
    public void q2(){
        if (cont<palavra.length){
            if (palavra[cont] == '0'){
                cont++;
                q3();
            }else {
                qErro();
            }
        } else{
            qErro();
        }
    }
    
    public void q3(){
        if (cont<palavra.length){
            if (palavra[cont] == '1'){
                cont++;
                q1();
            } else {
                qErro();
            }
        } else{
            qFim();
        } 
    }
    
    //Estado de erro
    public void qErro(){ 
        System.out.println("PALAVRA REJEITADA PELO AUTOMATO!\n");
    }
    
    public void qFim() {
        System.out.println("PALAVRA ACEITA PELO AUTOMATO!\n");
    }
}
