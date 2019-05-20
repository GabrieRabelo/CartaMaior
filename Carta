
/**
 * Objeto carta.
 * 
 * @author Profª  
 * @version 1.0
 */
import java.util.Random;
public class Carta
{
    private int valor, naipe;
    private boolean aberta;
    
    /**
     * Cria uma nova carta.
     */
    public Carta(){
        sorteia();
        aberta = false;
    }
    
    /**
     * Gera o valor e naipe para uma carta.
     */
    public void sorteia(){
        Random gerador = new Random();
        
        valor = gerador.nextInt(13) + 1;
        naipe = gerador.nextInt(4);  
    }
    
    /**
     * Retorna o valor da carta.
     */
    public int getValor(){
        return valor;
    }
    
    /**
     * Retorna o valor do naipe.
     */
    public int getNaipe(){
        return naipe;
    }
    
    public boolean estaAberta(){
        return aberta;
    }
    
    public void abre (){
        aberta = true;
    }
    
    public void fecha(){
        aberta = false;
    }
    public String toString(){
        if(aberta==false) return "**";
        String saida;
        if(valor==1) saida = "A";
        else if(valor==11) saida = "J";
             else if(valor==12) saida = "Q";
                  else if(valor==13) saida = "K";
                       else saida = ""+valor;
        if(naipe==0) saida = saida + "O";
        else if(naipe==1) saida = saida + "C";
             else if(naipe==2) saida = saida + "E";
                  else saida = saida + "P";
        return saida;
    }
}
