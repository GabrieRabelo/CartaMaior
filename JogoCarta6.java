import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
/**
 * Jogo de carta para exercício 6 da Lista de jogos OO.
 *
 * @author Gabriel Rabelo
 * @version 1.
 */
public class JogoCarta6{
    public static void main (String args[]) throws FileNotFoundException{
        Scanner teclado = new Scanner(System.in);
        
        Carta carta1 = new Carta();
        Carta carta2 = new Carta();
        Carta carta3 = new Carta();
        
        Random botGuess = new Random();
        
        int pontuacao = 0;
        int pontuacaoBot = 0;
        int max = 6;
        int cartaMaior = 0;
        
        System.out.println("\f..:: Jogo das Cartas ::..");
        System.out.println("- Tente acertar a carta de valor mais alto");
        System.out.println("- Você está jogando contra um bot");
        System.out.println("== Boa sorte ;) ==");
        for(int rodada = 1; rodada<= max; rodada++){
            do{
                carta1.sorteia();
                carta2.sorteia();
                carta3.sorteia();
            }while(carta1.getValor() == carta2.getValor() || carta1.getValor() == carta3.getValor() || carta2.getValor() == carta3.getValor());
            carta1.fecha(); carta2.fecha(); carta3.fecha();
            System.out.println("\nEscolha uma carta: " + "1. |" + carta1.toString() + "| 2. |" + carta2.toString() + "| 3.|" + carta3.toString() + "|");
            
            int chute = teclado.nextInt();
            int chuteBot = botGuess.nextInt(3)+1;
            System.out.println("Você chutou a " + chute + "ª carta");
            System.out.println("O bot chutou a " + chuteBot + "ª carta");
            
            if(carta1.getValor() > carta2.getValor() && carta1.getValor() > carta3.getValor()) cartaMaior = 1;
            else if(carta2.getValor() > carta1.getValor() && carta2.getValor() > carta3.getValor()) cartaMaior = 2;
            else if(carta3.getValor() > carta1.getValor() && carta3.getValor() > carta2.getValor()) cartaMaior = 3;
            
            carta1.abre(); carta2.abre(); carta3.abre();
            System.out.println("*Vira as cartas* |" + carta1.toString() + "| |" + carta2.toString() + "| |" + carta3.toString() + "|");
            
            if(chute == cartaMaior){
                System.out.println("Você acertou!");
                pontuacao += 100;
            }
            else System.out.println("Você errou.");
            if (chuteBot == cartaMaior){
                System.out.println("O bot acertou.");
                pontuacaoBot +=100;
            }
            else System.out.println("O bot errou.");
            
            System.out.println("Sua pontuação: " + pontuacao + " Bot: " + pontuacaoBot);
            
            
        }
        if(pontuacao > pontuacaoBot) System.out.println("\nVocê ganhou!");
        if(pontuacaoBot > pontuacao) System.out.println("\nO bot ganhou!");
        if(pontuacao == pontuacaoBot) System.out.println("\nEmpate.");
        
        verificaVencedor(pontuacao);
    }
    
    private static void verificaVencedor(int pontuacao) throws FileNotFoundException{
        Scanner teclado = new Scanner(System.in);
        int pontuacaoVencedor = leitura();
        
        if(pontuacao > pontuacaoVencedor){
            System.out.println("Informe seu nome: ");
            String nome = teclado.nextLine();
            gravacao(nome,pontuacao);
            System.out.println("Você bateu o recorde atual! Parabéns " + nome);
        }
    }
    
    private static int leitura() throws FileNotFoundException{
        int valor = 0;
        try{
            File origem = new File("vencedorC.txt");
            Scanner arquivo = new Scanner(origem);
            
            String nome = "";
            if(arquivo.hasNextLine()){
                nome = arquivo.nextLine();
                if(arquivo.hasNextLine()){
                    String pontuacao = arquivo.nextLine();
                    valor = Integer.parseInt(pontuacao);
                }
            }
            if(valor!=0)System.out.println("Vencedor atual: " + nome + " Pontuacao: " + valor);
            arquivo.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Arquivo não encontrado.");
        }
        return valor;
    }
    
    private static void gravacao(String nome, int pontuacao) throws FileNotFoundException{
        PrintWriter arquivo = new PrintWriter("VencedorC.txt");
        arquivo.println(nome);
        arquivo.println(pontuacao);
        arquivo.close();
    }
}