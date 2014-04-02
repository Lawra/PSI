package es.pue.ocajp7.eltrilero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Declaracio i inicialització de variables">
        int dinersInicials = 0;
        int dinersActuals = 0;
        int dinersApostats =0;
        int cubGuanyador;
        int cubTriat = 0;
        int partidesJugades = 0;
        int partidesGuanyades = 0;
        double min;
        String siNo;
        String nomJugador;
        boolean correct;
        boolean tornarJugar;
        Random rnd = new Random();
        Date startDate = null;
        Date endDate = null;
        Scanner stdin = new Scanner(System.in);
        DateFormat localeDfmt = null;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Entrada de dades">
        startDate = new Date();

        do{
            correct = true;
            System.out.printf("Introdueix el teu nom: ");
            nomJugador = stdin.nextLine();
            if(nomJugador.trim().length() == 0){
                correct = false;
                System.out.println("ERROR: el nom esta buit");
            }
        }while(!correct);
        
        do{
            correct = true;
            System.out.printf("Introdueix quantitat disponible de diners: ");

            try {
                dinersInicials = Integer.parseInt(stdin.nextLine());
                dinersActuals = dinersInicials;
                if(dinersInicials < 1){
                    System.out.println("ERROR: El valor ha de ser superior a 1");
                    correct = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Has d'indicar un valor numeric");
                correct = false;
            }
        }while(!correct);
        //</editor-fold>
                
        // Comensa el joc:
        do{
            tornarJugar = true;
            partidesJugades ++;
            System.out.printf("%s, tens %d diners disponibles.\n", nomJugador, dinersActuals);
            System.out.println("");
            System.out.println("\t    ##             ##            ##            ## ");
            System.out.println("\t   ####           ####          ####          ####           ##");
            System.out.println("\t  ######         ######        ######        ######         ####");
            System.out.println("\t ########       ########      ########      ########         ##");
            System.out.println("\t    C1             C2            C3            C4");
            System.out.println("\n On esta la piloteta?");

            //<editor-fold defaultstate="collapsed" desc="Quantitat a apostar">
            do{
                correct = true;
                System.out.printf("Indica la quantitat que vols apostar, %s: (diners disponibles: %d€)\n", nomJugador, dinersActuals);
                try {
                    dinersApostats = Integer.parseInt(stdin.nextLine());
                    if(dinersApostats > dinersActuals || dinersApostats < 1){
                        System.out.printf("ERROR: El valor ha de ser entre 1 i %d\n", dinersActuals);
                        correct = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("ERROR: Has d'indicar un valor numeric");
                    correct = false;
                }
            }while(!correct);
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Tria de la bola i solucio">
            cubGuanyador = rnd.nextInt(4);
            do{
                correct = true;
                System.out.printf("En quin cub esta la piloteta, %s? ", nomJugador);

                try {
                    cubTriat = Integer.parseInt(stdin.nextLine());
                    if(cubTriat > 4 || cubTriat < 1){
                        System.out.println("ERROR: Només hi han 4 cubs");
                        correct = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("ERROR: Has d'indicar un valor numeric");
                    correct = false;
                }
            }while(!correct);

            if(cubTriat == (cubGuanyador+1)){
                System.out.println("Enorabona! has trobat la piloteta");
                dinersActuals += dinersApostats;
                partidesGuanyades ++;
            }else{
                System.out.println("Oh! hem sap greu, has fallat");
                dinersActuals -= dinersApostats;
            }
            System.out.printf("---> Cantidad inicial: %d €\n", dinersInicials);
            System.out.printf("---> Cantidad actual: %d €\n", dinersActuals);
            System.out.printf("---> Beneficios/Perdidas: %d €\n", (dinersActuals - dinersInicials));
            System.out.printf("---> Partidas jugadas: %d\n", partidesJugades);
            System.out.printf("---> Partidas ganadas: %d (%.2f%% victories)\n", partidesGuanyades, (partidesGuanyades*100D/partidesJugades));
            System.out.printf("---> Partidas perdidas: %d (%.2f%% derrotes)\n", (partidesJugades - partidesGuanyades), ((partidesJugades - partidesGuanyades)*100D/partidesJugades));

            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Tornar a Jugar?">
            if(dinersActuals>0){
                do{
                    correct = true;
                    System.out.printf("Vols continuar jugant %s? (s/n): ", nomJugador);

                    try {
                        siNo = stdin.nextLine();
                        tornarJugar = siNo.equalsIgnoreCase("s");
                        
                    } catch (NoSuchElementException ex) {
                        System.out.println("ERROR: Has d'indicar alguna cosa (s/n)");
                        correct = false;
                    }
                }while(!correct);
            }else{
                tornarJugar = false;
                System.out.println("Ho sento, ja no et queden més diners. Torna a vindre quan en tinguis més");
            }
            
        //</editor-fold>
            
        }while(tornarJugar);
        endDate = new Date();
        min = (endDate.getTime() - startDate.getTime())/1000D/60;
        localeDfmt = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.getDefault());
        //<editor-fold defaultstate="collapsed" desc="Estadistiques finals">
        
        StringBuilder contingut = new StringBuilder();
        contingut.append("\r\n            E s ta d í s t i q u e s   d e l   j u g a d o r\r\n");
        contingut.append("----------------------------------------------------------------\r\n");
        contingut.append(String.format("---> Jugador: %s \r\n", nomJugador));
        contingut.append(String.format("---> Diners inicials: %d €\r\n", dinersInicials));
        contingut.append(String.format("---> Diners finals:  %d €\r\n", dinersActuals));
        contingut.append(String.format("---> Beneficis/Perdues:  %d €\r\n", (dinersActuals - dinersInicials)));
        contingut.append(String.format("---> Hora de inici: %s\r\n", localeDfmt.format(startDate).toString()));
        contingut.append(String.format("---> Hora de fi: %s\r\n", localeDfmt.format(endDate).toString()));
        contingut.append(String.format("---> Duració: %.2f minuts\r\n", min));
        contingut.append(String.format("---> Partidas jugadas:  %d\r\n", partidesJugades));
        contingut.append(String.format("---> Partidas ganadas: %d (%.2f%% victories)\r\n", partidesGuanyades, (partidesGuanyades*100D/partidesJugades)));
        contingut.append(String.format("---> Partidas perdidas: %d (%.2f%% derrotes)\r\n", (partidesJugades - partidesGuanyades), ((partidesJugades - partidesGuanyades)*100D/partidesJugades)));
        
        System.out.println(contingut);
       
        String nomfitxer = String.format("stats-%1$td-%1$tm-%1$tY.txt", endDate);
        try {
            Files.write(Paths.get(nomfitxer), contingut.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("-----------ERROR-----------");
            System.out.println(ex.getMessage());
            System.out.println("---------------------------");
        }
        //</editor-fold>
        
        
    }
    
}
