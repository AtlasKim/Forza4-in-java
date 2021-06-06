/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.forza4;

/**
 *
 * @author Boku no Melo
 */
import java.util.Scanner;

public class Forza4Test 
{
    public static void main(String[] args) throws Exception
    {
        
        Scanner input = new Scanner(System.in); //scanner per leggere gli input dei due giocatori
        Game forza4 = new Game();
        int column = 10; //colonna della tessera inserita
        int spotRow = 10; //riga della tessera inserita
        int i; //servirà ad alternare i turni dei giocatori
        int victoryIndex = 0; //serve a salvare l'indice di chi ha vinto
        String replay = "Y";
        boolean victory;
        
        while(replay.equals("Y")) //finché i due giocatori vogliono giocare ripeti il ciclo
        {
            i = 0;                      //resettiamo tutte le variabili necessarie al corretto funzionamento di una nuova partita
            victory = false;
            forza4.getGrid().resetGrid();
            System.out.println("FORZA 4");
            
            while(victory == false) //finché non si arriva alla vittoria continua ad andare avanti
            {
                forza4.printGrid();
                
                //while(column<0 || column>6)
                //{                    
                if(forza4.getPlayer(i%2).getPlayerColor() == Color.ROSSO)
                    System.out.println("Giocatore rosso, inserisci la colonna dove vuoi piazzare la tessera (da 0 a 6):");
                else if(forza4.getPlayer(i%2).getPlayerColor() == Color.VERDE)
                    System.out.println("Giocatore verde, inserisci la colonna dove vuoi piazzare la tessera (da 0 a 6):");

                column = input.nextInt();
                input.nextLine(); //next int non legge il carattere di new line che resta nel buffer e fa impazzire i successivi next line
                spotRow = forza4.getPlayer(i%2).move(forza4.getGrid(), column);
                //}
                
                victory = forza4.victoryCheck(spotRow, column, forza4.getPlayer(i%2).getPlayerColor());
                victoryIndex = i;
                i++;                                     
            }
           
            forza4.printGrid();
            if(forza4.getPlayer(victoryIndex%2).getPlayerColor() == Color.ROSSO)
                System.out.println("Giocatore rosso, hai vinto! Volete giocare ancora? (Y/N)");
            else
                System.out.println("Giocatore verde, hai vinto! Volete giocare ancora? (Y/N)");
            
            replay = input.nextLine();
            System.out.println(replay);
        }
    }
}
