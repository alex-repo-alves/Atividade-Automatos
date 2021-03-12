package q1;

//import java.util.Scanner;

public class Q1b {
    int cont;
    char palavra [];
    public static void main(String[] args) {
        Q1b automato = new Q1b(); //Instancia o automato
        String sentenca[] = {"b","babab","baab","aab", "a","ab","bab","aba"}; //array com as palavras de teste
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
    
    public void q0(){
        if (cont<palavra.length){
            if (palavra[cont] == 'a'){
                cont++;
                q1();
            } else if(palavra[cont] == 'b'){
                cont++;
                q0();
            } else {
                qErro();
            }
        } else{
            qFim();
        } 
    }
    
    public void q1(){
         if (cont<palavra.length){
            if (palavra[cont] == 'a'){
                cont++;
                q2();
            } else if(palavra[cont] == 'b'){
                cont++;
                q1();
            } else {
                qErro();
            }
        } else{
            qErro();
        } 
    }
    
    public void q2(){
        if (cont<palavra.length){
            if (palavra[cont] == 'a'){
                cont++;
                q1();
            } else if(palavra[cont] == 'b'){
                cont++;
                q0();
            } else {
                qErro();
            }
        } else{
            qErro();
        } 
    }  
    
    public void qErro(){
        System.out.println("PALAVRA REJEITADA PELO AUTOMATO!\n");
    }
    
    public void qFim() {
        System.out.println("PALAVRA ACEITA PELO AUTOMATO!\n"); //por ser estado final, verificou que a cadeia terminou então encerra o teste com sucesso   
    }
}
