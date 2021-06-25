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
/*import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
        int i;   //servirà ad alternare i turni dei giocatori
        int victoryIndex = 0; //serve a salvare l'indice di chi ha vinto
        String replay = "Y";
        boolean victory;
        
        MyGridLayout gridUi = new MyGridLayout();
        
        while(replay.equals("Y")) //finché i due giocatori vogliono giocare ripeti il ciclo
        {
            i = 0;                      //resettiamo tutte le variabili necessarie al corretto funzionamento di una nuova partita
            victory = false;
            forza4.getGrid().resetGrid();
            System.out.println("FORZA 4");
            
            /*while(victory == false) //finché non si arriva alla vittoria continua ad andare avanti
            {
                
                
                //while(column<0 || column>6)
                //{                    
                if(forza4.getPlayer(i%2).getPlayerColor() == Color.ROSSO)
                    System.out.println("Giocatore rosso, inserisci la colonna dove vuoi piazzare la tessera (da 0 a 6):");
                else if(forza4.getPlayer(i%2).getPlayerColor() == Color.VERDE)
                    System.out.println("Giocatore verde, inserisci la colonna dove vuoi piazzare la tessera (da 0 a 6):");
                
                //column = input.nextInt();
                //input.nextLine(); //next int non legge il carattere di new line che resta nel buffer e fa impazzire i successivi next line
                /*forza4.printGrid();
                spotRow = forza4.getPlayer(i%2).move(forza4.getGrid(), gridUi.getYColumnFound());
                    //}

                victory = forza4.victoryCheck(spotRow, column, forza4.getPlayer(i%2).getPlayerColor());
                victoryIndex = i;
                i++;
                forza4.printGrid();                 
            }
            
            forza4.printGrid();
            if(forza4.getPlayer(victoryIndex%2).getPlayerColor() == Color.ROSSO)
                System.out.println("Giocatore rosso, hai vinto! Volete giocare ancora? (Y/N)");
            else
                System.out.println("Giocatore verde, hai vinto! Volete giocare ancora? (Y/N)");
            */
            replay = input.nextLine();
            System.out.println(replay);
        }
    }
    
    
   /* private class MouseClickHandler implements MouseListener,MouseMotionListener        //era private
    {
        //handle mouse-click event and determine which button was pressed
        @Override
        public void mouseClicked( MouseEvent event )
        {
            gridUi.setIsMouseClicked(true);                              //stiamo sfruttando un flag per fare dei controlli nel test e bloccare l'esecuzione
            xPos = event.getX(); // get x-position of mouse
            yPos = event.getY(); // get y-position of mouse
            yColumnFound = findColonna(xPos,yArea);
            
            
            System.out.println("X :"+xPos);
            System.out.println("Y :"+yPos);
            System.out.println("Colonna effettiva :"+yColumnFound);
            
            //status.setText(String.format("Cliccato a [%d,%d], andrebbe nella colonna ",xPos,yPos));
            //status.setText(String.format("Cliccato a [%d,%d]",xPos,yPos));
            //column.setText(String.format(" Andrebbe nella colonna %d",(int)(xPos/unit)));
        }
        
        @Override
        public void mousePressed(MouseEvent e){}
        @Override
        public void mouseEntered(MouseEvent e){}
        @Override
        public void mouseExited(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        
        @Override
        public void mouseDragged(MouseEvent e){}
        @Override
        public void mouseMoved(MouseEvent e){}
    }*/
}
