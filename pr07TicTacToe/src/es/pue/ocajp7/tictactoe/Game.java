package es.pue.ocajp7.tictactoe;

import java.text.NumberFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //<editor-fold defaultstate="collapsed" desc="Inicialització de variables a nivell de classe">
    static String player1 = null;
    static String player2 = null;
    static String YesNo = null;
    static String symbol = null;
    static char[] board = new char[9];
    static Scanner stdin = new Scanner(System.in);
    static boolean incorrect;
    static boolean win;
    static boolean playAgain;
    static char S1;// = 'O';
    static char S2;// = 'X';
    static char s;
    static int nGame = 0;
    static int nTurn = 0;
    static int nVictoryP1 = 0;
    static int nVictoryP2 = 0;
    static int nTied = 0;
    static int pos;
    static int start;
    static NumberFormat localeNfmt = null;
    static Date startDate = null;
    static Date endDate = null;
    
    
    //</editor-fold>
    
    
    public static void main(String[] args) {
        Random rnd = new Random();
        //<editor-fold defaultstate="collapsed" desc="Game inicilization">
        do{
            incorrect = false;
            System.out.printf("> Player 1: ");
            player1 = stdin.nextLine();
            if(player1.trim().length() == 0){
                incorrect = true;
                System.out.println("ERROR: the name is empty");
            }
        }while(incorrect);
        
        do{
            incorrect = false;
            System.out.printf("> Hello %s, what symbol do you want? ", player1);
            try {
                symbol = stdin.nextLine();
                if(symbol.trim().length() == 0){
                    incorrect = true;
                    System.out.println("ERROR: the symbol is empty");
                }else{
                    int num = Integer.parseInt(symbol);
                    if(num>=1 && num<=9){
                        System.out.println("ERROR: you can't introduce a symbol of a number between 1-9");
                        incorrect = true;
                    }else{
                        S1 = symbol.charAt(0);
                    }
                }
            } catch (Exception e) {
                S1 = symbol.charAt(0);
            }
        }while(incorrect);
        
        do{
            incorrect = false;
            System.out.printf("> Player 2: ");
            player2 = stdin.nextLine();
            if(player2.trim().length() == 0){
                incorrect = true;
                System.out.println("ERROR: the name is empty");
            }
        }while(incorrect);
        do{
            incorrect = false;
            System.out.printf("> Hello %s, what symbol do you want? ", player2);
            
            try {
                symbol = stdin.nextLine();
                if(symbol.trim().length() == 0){
                    incorrect = true;
                    System.out.println("ERROR: the symbol is empty");
                }else{
                    int num = Integer.parseInt(symbol);
                    if(num>=1 && num<=9){
                        System.out.println("ERROR: you can't introduce a symbol of a number between 1-9");
                        incorrect = true;
                    }else{
                        S2 = symbol.charAt(0);
                        if(S2==S1){
                            incorrect = true;
                            System.out.printf("ERROR: you have to choose a diferent symbol than %c\n", S1);
                        }
                    }
                }
            } catch (Exception e) {
                S2 = symbol.charAt(0);
                if(S2==S1){
                    incorrect = true;
                    System.out.printf("ERROR: you have to choose a diferent symbol than %c\n", S1);
                }
            }
        }while(incorrect);
        // calculant el jugador que comensa a jugar:
        start = rnd.nextInt(2);
        //</editor-fold>
        
        
        do{
            startDate = new Date();
            initializeBoard();
            nGame++;
            nTurn = 0;
            //<editor-fold defaultstate="collapsed" desc="Game">
            do{
                win = false;
                nTurn++;
                
                System.out.printf("\nGame: %d\n", nGame);
                System.out.println("------------------------------------------------------------");
                System.out.printf("- Turn: %d\n", nTurn);
                System.out.printf("- Player 1: %s (symbol %c)\n", player1, S1);
                System.out.printf("- Player 2: %s (symbol %c)\n", player2, S2);
                printBoard();
                do{
                    incorrect = false;
                    if(((nTurn+start) % 2) == 0){
                        System.out.printf("> %s, choose position (1-9): ", player2);
                        s = S2;
                    }else{
                        System.out.printf("> %s, choose position (1-9): ", player1);
                        s = S1;
                    }
                    try {
                        pos = Integer.parseInt(stdin.nextLine())-1;
                        if(pos>8 || pos<0){
                            System.out.println("ERROR: You have to introduce a number between (1-9)");
                            incorrect = true;
                        }
                        if(board[pos] == S1 || board[pos] == S2){
                            System.out.println("ERROR: You have to choose and empty position");
                            incorrect = true;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: You have to introduce a number");
                        incorrect = true;
                    } 
                }while(incorrect);
                board[pos] = s;
                
                win = checkBoard(S1) || checkBoard(S2) || nTurn == 9;
            }while(!win);
            //</editor-fold>
            
            printBoard();
            if(checkBoard(S1)){
                System.out.println("------------------------------------------------------------");
                System.out.printf("Congratulations %s!, you win with %d turns\n", player1, nTurn);
                System.out.println("------------------------------------------------------------");
                start = 1;
                nVictoryP1++;
            }else if(checkBoard(S2)){
                System.out.println("------------------------------------------------------------");
                System.out.printf("Congratulations %s!, you win with %d turns\n", player2, nTurn);
                System.out.println("------------------------------------------------------------");
                start = 0;
                nVictoryP2++;
            }else{
                System.out.println("------------------------------------------------------------");
                System.out.println("That's a tie!");
                System.out.println("------------------------------------------------------------");
                nTied++;
                start = rnd.nextInt(2);
            }
            
            stdin.nextLine();
            endDate = new Date();
            showStats();
            
            //<editor-fold defaultstate="collapsed" desc="Play again?">
            do{
               incorrect = false;
               System.out.printf("> Do you want to play again? (y/n): ");
               try {
                    YesNo = stdin.nextLine();
                    playAgain = YesNo.equalsIgnoreCase("y");

               } catch (NoSuchElementException ex) {
                    System.out.println("ERROR: Has d'indicar alguna cosa (s/n)");
                    incorrect = true;
                }
            }while(incorrect);
            //</editor-fold>
            
        }while(playAgain);
    }
    
    // mètodes
    private static boolean checkBoard(char symbol){
        boolean H[] = new boolean[3];
        boolean V[] = new boolean[3];
        boolean D[] = new boolean[2];
        boolean result;
        
        for(int i=0;i<3;i++){
            // horitzontal:
            H[i]= (board[i]==symbol && board[i+1]==symbol && board[i+2]==symbol);
            // vertical
            V[i]= (board[0+i]==symbol && board[3+i]==symbol && board[6+i]==symbol);
        }
        
        //diagonal
        D[0]=(board[0]==symbol && board[4]==symbol && board[8]==symbol);
        D[1]=(board[6]==symbol && board[4]==symbol && board[2]==symbol);
        
        result = H[0] || H[1] || H[2] || V[0] || V[1] || V[2] || D[0] || D[1];
        return result;
    }
    
    private static void printBoard(){
        System.out.println("	-----	-----	-----");
        System.out.printf("	| %c |	| %c |	| %c |\n", board[0], board[1], board[2]);
        System.out.println("	-----	-----	-----");
        System.out.printf("	| %c |	| %c |	| %c |\n", board[3], board[4], board[5]);
        System.out.println("	-----	-----	-----");
        System.out.printf("	| %c |	| %c |	| %c |\n", board[6], board[7], board[8]);
        System.out.println("	-----	-----	-----");
    }
    
    private static void showStats(){
        localeNfmt = NumberFormat.getPercentInstance();
        localeNfmt.setMinimumFractionDigits(2);
        System.out.println("\nE S T A D I S T I C S");
        System.out.println("------------------------------------------------------------");
        System.out.println("1.- Resumen de la última partida jugada:");
        System.out.printf("Game: %d\n",nGame);
        System.out.println("------------------------------------------------------------");
        System.out.printf("- Truns: %d\n", nTurn);
        System.out.printf("- Player 1: %s (Symbol %c)\n", player1, S1);
        System.out.printf("- Player 2: %s (Symbol %c)\n", player2, S2);
        printBoard();
        System.out.println("2.- Hall of fame:");
        System.out.printf("- Matches played: %d\n", nGame);
        System.out.printf("- Player 1(%s) victories: %d (%s)\n", player1, nVictoryP1, localeNfmt.format(nVictoryP1/nGame));
        System.out.printf("- Player 2(%s) victories: %d (%s)\n", player2, nVictoryP2, localeNfmt.format(nVictoryP2/nGame));
        System.out.printf("- Tied matches: %d (%s)\n\n", nTied, localeNfmt.format(nTied/nGame));
        
    }
    
    private static void initializeBoard(){
        board[0] = '1';
        board[1] = '2';
        board[2] = '3';
        board[3] = '4';
        board[4] = '5';
        board[5] = '6';
        board[6] = '7';
        board[7] = '8';
        board[8] = '9';
    }
}
