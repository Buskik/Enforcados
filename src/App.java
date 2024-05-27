
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

         
        String palavra = palavraAleatoria();
        char[] letras = letras(palavra);
        char[]acertadas = acertadas(letras);
         int x1 = 0;
         int y1 = 0;
         int x2 = 0;
         int y2 = 0;
         Object[] visao1 = {};
         Object[] visao2 = {};
         String[][] tabuleiro =  new String[10][10];
         
            menu();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nome do jogador 1:");
            String player1 = sc.next();
            System.out.println("Nome do jogador 2:");
            String player2 = sc.next();
            while((x1 < tabuleiro.length && y1 < tabuleiro[0].length) || (x2 < tabuleiro.length && y2 < tabuleiro[0].length)){

                if(String.valueOf(letras).equals(String.valueOf(acertadas))){
                    palavra = palavraAleatoria();
                    letras = letras(palavra);
                    acertadas = acertadas(letras);
               }
                visao1 = tab2(x1, y1,x2,y2, tabuleiro, player1, palavra, acertadas, letras);
                acertadas = (char[]) visao1[2];

                x1 = (int) visao1[0];

                if (x1 >= tabuleiro[0].length){
                    x1 = 0;
                    y1++;
                }
                if (x2 >= tabuleiro[0].length){
                    x2 = 0;
                    y2++;
                
                }
                visao2 = tab2(x2, y2,x1,y1, tabuleiro, player2, palavra,acertadas, letras);
                acertadas = (char[]) visao2[2];
                x2 = (int) visao2[0];
                if (x1 >= tabuleiro[0].length){
                    x1 = 0;
                    y1++;
                }
                if (x2 >= tabuleiro[0].length){
                    x2 = 0;
                    y2++;
                 
                    
            }
            if(String.valueOf(letras).equals(String.valueOf(acertadas))){
                palavra = palavraAleatoria();
                letras = letras(palavra);
                acertadas = acertadas(letras);
           }
            
        }
            System.out.println("Você venceu!");

            String a = sc.next();
            menu();
       

      
      
    }

    public static Object[] tab2(int x1, int y1, int x2, int y2, String[][] tabuleiro, String player, String palavra, char[] acertadas, char[] letras) {
        
        int especial = 1;
        {
            System.out.println("\u001B[35m" + player + "\u001B[0m");
            System.out.printf("══════════════════════════════════════");
        int casa = 1;
        for(int i = 0; i < tabuleiro.length; i++){
            
            
            
            System.out.println();
            
            for(int j = 0; j <tabuleiro[i].length; j++){
                
             if (x1 == especial && y1 == i){
                x1 = especial(x1);
                    System.out.printf("\u001B[35m" +" @" + "\u001B[0m");
                    System.out.printf("║");
                    
                   
                }
                else if (x1 == x2 && y1 == y2 && x1 == j && y1 == i){
                    System.out.printf("\u001B[35m" + " ½" + "\u001B[0m");
                    System.out.printf("║");
                }
                else if (x2 == j && y2 == i){
                    System.out.printf(" @");
                    System.out.printf("║");
                }
                else if (x1 == j && y1 == i){
                    System.out.printf("\u001B[35m" +" @" + "\u001B[0m");
                    System.out.printf("║");
                    
                    }
                else if (j % 5 == 0){
                    System.out.printf("\u001B[32m" + " §"+ "\u001B[0m");
                    System.out.printf("║");
                    especial = j;
                
                } else{
                    System.out.printf("%3d",casa);
                    System.out.printf("║");
                    
                }
                
                casa++;

                
               
                
            }
            System.out.println("");
            System.out.printf("══════════════════════════════════════");
            
        }

        Object[] a = forca(palavra, letras, acertadas);
        int dado = (int) a[0];
        acertadas = (char[]) a[1];
        x1 += dado;
        
        System.out.print("\033[H\033[2J");  
    System.out.flush();  
    
    }
    
    Object[] b = {x1,letras,acertadas};

            return b ;
}


    public static int dado() {
        Random random = new Random();
        int valor = random.nextInt(1,7);
        return valor;
    }
    public static String palavraAleatoria() {
        Random random = new Random();
            String[ ] entrada = {"batata", "cenoura", "abacaxi", "tomate", "morango", "melancia", "carambola", "amendoim", "abobora", "pessego", "banana", "laranja", "abacate", "cebola", "pneumoultramicroscopicossilicovulcanoconiotico", "beterraba", "alface", "almondega", "parmesao", "pimentao", "almofada", "chocolate", "geladeira", "travesseiro", "pneumoultramicroscopicossilicovulcanoconiotico", "computador", "televisao", "refrigerante", "sorvete", "pipoca", "relogio", "guitarra", "teclado", "pneumoultramicroscopicossilicovulcanoconiotico", "celular", "espelho", "ventilador", "cadeira", "escova", "perfume", "caneta", "tesoura", "pneumoultramicroscopicossilicovulcanoconiotico", "pneumoultramicroscopicossilicovulcanoconiotico", "pneumoultramicroscopicossilicovulcanoconiotico"};
            int indice = random.nextInt(entrada.length);
            // Selecionar uma palavra aleatoria
             String palavraAleatoria = entrada[indice];

             return palavraAleatoria;
    }
    public static char[] letras(String palavraAleatoria) {
        char[] letras = palavraAleatoria.toCharArray();
        return letras;
    }
    public static char[] acertadas(char[] letras) {

        char[] acertadas = new char[letras.length] ;
        for (int i = 0; i < letras.length; i++) {
          acertadas[i] = '_';
          
        }
        return acertadas;
    }
    public static int especial(int x) {
        Random rand = new Random();
        int a = rand.nextInt(1,7);
        switch (a) {
             
            case 1:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("Que sorte! Avance 2 casas");
            
            x+=2;
                break;
        
            case 2:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("Que azar! Volte 4 casas");
                x-=4;
                break;
        
            case 3:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("Que sorte! Avance 1 casas");
                x++;
                break;
        
            case 4:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("Que sorte! Avance 3 casas");
                x+=3;
                break;
        
            case 5:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("Que azar! Volte 1 casa");
                x-=1;
                break;
        
            case 6:
            System.out.print("\033[H\033[2J");  
            System.out.flush();
                System.out.println("Que sorte! Avance 4 casas");
                x+=4;
                break;
        
            default:
                break;
        }

        
        return x;
    }
    public static void logo() {
        System.out.println();
             System.out.println(" _____        __                         _           _ \r\n" + //
                              "| ____|_ __  / _| ___  _ __ ___ __ _  __| | ___  ___| |\r\n" + //
                              "|  _| | '_ \\| |_ / _ \\| '__/ __/ _` |/ _` |/ _ \\/ __| |\r\n" + //
                              "| |___| | | |  _| (_) | | | (_| (_| | (_| | (_) \\__ \\_|\r\n" + //
                              "|_____|_| |_|_|  \\___/|_|  \\___\\__,_|\\__,_|\\___/|___(_)");
                System.out.println("                      ##-------------------                      \r\n" + //
                                    "                  ---####-++++++++++++++++-----                  \r\n" + //
                                    "               ---++--###-+++++++++++++++++++++---               \r\n" + //
                                    "            ---++++++-+##+-+++++++++++++++++++++++---            \r\n" + //
                                    "          --+++++++++--##+-++++++++++++++++++++++++++--          \r\n" + //
                                    "        --+++++++++++--###-++++++++++++++++++++++++++++--        \r\n" + //
                                    "      ---++++++++++++--###-+++++++++++++++++++++++++++++---      \r\n" + //
                                    "     --++++++++++++++--##+-+++++++++++++++++++++++++++++++--     \r\n" + //
                                    "    --+++++++++++++++--##+-++++++++++++++++++++++++++++++++--    \r\n" + //
                                    "   --+++++++++++++++--###----------+++++++++++++++++++++++++++   \r\n" + //
                                    "  --+++++++++++++++--#############----++++++++++++++++++++++++-  \r\n" + //
                                    " --+++++++++++++++--#######++########+---+++++++++++++++++++++-- \r\n" + //
                                    " -+++++++++++++++--####--+###+-+##+#####--+++++++++++++++++++++- \r\n" + //
                                    "-++++++++++++++++-###--+##........#+-####+-+++++++++++++++++++++-\r\n" + //
                                    "-++++++++++++++++-###-+##.......-..#+--###+-++++++++++++++++++++-\r\n" + //
                                    "-++++++++++++++++-###--#+.......-..###--###-++++++++++++++++++++-\r\n" + //
                                    "-++++++++++++++++-+##+-+#......--....++-+##-++++++++++++++++++++-\r\n" + //
                                    "-+++++++++++++++++-####-+##..---...+##+-+##-++++++++++++++++++++-\r\n" + //
                                    "-++++++++++++++++++--####-+#........-#--###-++++++++++++++++++++-\r\n" + //
                                    "-+++++++++++++++++++---########.......####+-++++++++++++++++++++-\r\n" + //
                                    "-+++++++++++++++++++++---+#############..-#####+++++++++++++++++-\r\n" + //
                                    "--+++++++++++++++++++++++------+#.............###+++++++++++++++-\r\n" + //
                                    " -+++++++++++++++++++++++++++---#....----.......##+++++++++++++- \r\n" + //
                                    " --+++++++++++++++++++++++++++++#.----...........#++++++++++++-- \r\n" + //
                                    "  -++++++++++++++++++++++++++++##...........-...##++++++++++++-  \r\n" + //
                                    "   -+++++++++++++++++++++++++++#.........--...-##++++++++++++-   \r\n" + //
                                    "    --+++++++++++++++++++++++++#.....---....+###+++++++++++--    \r\n" + //
                                    "     --++++++++++++++++++++++++##........####+++++++++++++--     \r\n" + //
                                    "      ---+++++++++++++++++++++++##########+++++++++++++++--      \r\n" + //
                                    "        --+++++++++++++++++++++++++++++++++++++++++++++--        \r\n" + //
                                    "          ---++++++++++++++++++++++++++++++++++++++++--          \r\n" + //
                                    "            ---+++++++++++++++++++++++++++++++++++---            \r\n" + //
                                    "               ----++++++++++++++++++++++++++++---               \r\n" + //
                                    "                  -----+++++++++++++++++++-----                  \r\n" + //
                                    "                      ---------------------                       ");
    }
    public static void regras() {
        int escolha = 99;
        while (escolha != 0) {
            
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nREGRAS");
        System.out.println("Enforcados é um jogo de tabuleiro onde para avançar você precisa adivinhar alguma letra da forca!\nNo tabuleiro há também casas especiais que diversificam o jogo, podendo ter recompensas boas ou ruins.\nO jogador que chegar até o fim do tabuleiro vence!");
        
        System.out.println("\nDigite 0 para voltar ao menu.");
        escolha = sc.nextInt();
        if (escolha == 0){
            break;
        }
        }
        
    }
    public static void menu() {

        boolean jogar = false;
        while (jogar == false) {
            Scanner sc = new Scanner(System.in);
            
    
                                    logo();
    
                                    System.out.println("Digite o número desejado para navegar pelo menu:");
                                    System.out.println("1. Jogar");
                                    System.out.println("2. Regras");
                                    int escolha = sc.nextInt();
                                    switch (escolha) {
                                        case 1:
                                            jogar = true;
                                            break;
                                    
                                        case 2:
                                            regras();
                                    
                                        default:
                                            break;
                                    };
                                    System.out.print("\033[H\033[2J");  
        System.out.flush();    
        }
       
           
                                
    }
    public static Object[] forca(String palavraAleatoria, char[] letras, char[] acertadas) {
        int dado = 0;
        
       Scanner scan = new Scanner(System.in);
        //Exibir a palavra aleatória
        System.out.println("\nPalavra aleatória: " + palavraAleatoria);
        
        System.out.println("Palavra: ");
      
    
    System.out.println(acertadas);
    System.out.print("Digite uma letra: ");
    String palavra = scan.next();
      char letra = palavra.toLowerCase().charAt(0);
      boolean acertou = false;
   if (palavra.equals("0")){
    menu();
   }
    for (int i = 0; i < letras.length; i++) {
      if(letra == letras[i]){
        
        acertou = true; 

       
        acertadas[i] = letras[i];
        
        
      }  
    }
    if (acertou == true) {
        System.out.println("Você acertou!");
    
        dado = dado();
        System.out.println("Você tirou " + dado + " no dado");
        
        
    }
    Object[] a = {dado, acertadas};
    return a;
    }
}


    

