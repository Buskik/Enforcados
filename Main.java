import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    //Iniciar Jogo
    //Definindo variáveis
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    System.out.println("###FORCA###");
    System.out.printf("Regras: \n Tente acertar chutando uma letra \n Se acertar entre no jogo de azar \n ganhando este jogo ganhe mais tentantivas de chutas a letra ate errar");
    String[ ] entrada = {"batata", "cenoura", "abacaxi", "tomate", "morango", "melancia", "carambola", "amendoim", "abóbora", "pêssego", "banana", "laranja", "abacate", "cebola", "pneumoultramicroscopicossilicovulcanoconiótico", "beterraba", "alface", "almôndega", "parmesão", "pimentão", "almofada", "chocolate", "geladeira", "travesseiro", "pneumoultramicroscopicossilicovulcanoconiótico", "computador", "televisão", "refrigerante", "sorvete", "pipoca", "relógio", "guitarra", "teclado", "pneumoultramicroscopicossilicovulcanoconiótico", "celular", "espelho", "ventilador", "cadeira", "escova", "perfume", "caneta", "tesoura", "pneumoultramicroscopicossilicovulcanoconiótico", "pneumoultramicroscopicossilicovulcanoconiótico", "pneumoultramicroscopicossilicovulcanoconiótico"};
    int indice = random.nextInt(entrada.length);
    // Selecionar uma palavra aleatória
     String palavraAleatoria = entrada[indice];
    //Exibir a palavra aleatória
    System.out.println("Palavra aleatória: " + palavraAleatoria);
    char[] letras = palavraAleatoria.toCharArray();
    char[] acertadas = new char[letras.length] ;
    for (int i = 0; i < letras.length; i++) {
      acertadas[i] = '_';
      
    }

    //Rodada
    //contador de tentativas
    for(int tentativas = palavraAleatoria.length();tentativas > 0;tentativas--){
    System.out.println("Palavra: ");
      
    
    System.out.println(acertadas);
    System.out.println("\nTentativas restantes: " + tentativas);
    System.out.print("Digite uma letra: ");
    String palavra = scan.next();
      char letra = palavra.toLowerCase().charAt(0);
      boolean acertou = false;
   // boolean acerto = true;
    for (int i = 0; i < letras.length; i++) {
      if(letra == letras[i]){
        acertou = true;
        if (String.valueOf(acertadas).contains(String.valueOf(letra))){

          acertou = false;
        }
        acertadas[i] = letras[i];
        
        
      }  
    }
    //Verificar acerto
    if (acertou == true) {
      System.out.println("Você acertou!");
      int randomNumber = random.nextInt(1,4);
  
      System.out.println("Informe um número de 1 á 3 para continuar sua vez");
      int sorteado =scan.nextInt();
    
      if (sorteado != randomNumber) {
        System.out.println("Parabéns, você ganhou mais uma rodada!");
        tentativas++;

    } else {
        System.out.println("Você já teve sua chance. Passa a vez.");
    }
        if (sorteado < 1 || sorteado > 3){
        System.err.println("Número inválido tente novamente");
       }
    } else {
      System.out.println("Passou a vez!");
    }
    
    
    }
        
    }   
    }
  
