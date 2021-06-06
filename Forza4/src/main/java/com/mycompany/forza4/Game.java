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

enum Color
{
    ROSSO,VERDE,VUOTO;
}

public class Game {
    private Grid griglia;      //da capire, voglio fare qui il test oppure posso fare un'altra classe di test?
    private Player[] giocatori = new Player[2];
    //private boolean vittoria;
    
    public Game ()
    {
        this.griglia = new Grid();
        this.giocatori[0] = new Player(Color.ROSSO);  //giocatore con tessere rosse
        this.giocatori[1] = new Player(Color.VERDE); //giocatore con tessere verdi
    }
    
    public Player getPlayer(int x) throws Exception
    {
        if (x < 0 || x > 1) {
            throw new Exception("Index out of bound");
        }
        return this.giocatori[x];
    }
    
    public Grid getGrid()
    {
        return this.griglia;
    }
    
    public void printGrid () throws Exception
    {
        Color spotColor;
        
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(griglia.getSpot(i, j).getPiece()==null)
                    spotColor = Color.VUOTO;
                else
                    spotColor = griglia.getSpot(i, j).getPiece().getPieceColor();
                switch (spotColor)
                {
                    case ROSSO:
                        System.out.print("R");
                        break;
                    case VERDE:
                        System.out.print("V");
                        break;
                    default:
                        System.out.print("O");
                        break;
                }
                System.out.print(" ");
            }
            
            System.out.println("");
        }
        
        System.out.println("");
    }
    
    public boolean victoryCheck(int x, int y, Color color) throws Exception
    {
        int counterColumn,counterRow,counterDiagonal1,counterDiagonal2;
        counterColumn=counterRow=counterDiagonal1=counterDiagonal2=0;
        
        Color spotColor;
               
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(griglia.getSpot(i,j).getPiece()==null)
                    spotColor=Color.VUOTO;
                else
                    spotColor=griglia.getSpot(i,j).getPiece().getPieceColor();
                
                if(griglia.getSpot(i,j).getY() == y) //victory check verticale, fisso la colonna e scorro le righe
                {
                    if(spotColor == color)
                        counterColumn++;
                    else
                        counterColumn=0;
                }
                
                if(griglia.getSpot(i,j).getX() == x) //victory check orizzontale, fisso la riga e scorro le colonne
                {
                    if(spotColor == color)
                        counterRow++;
                    else
                        counterRow=0;
                }
                
                if((i-j) == (x-y))  //victory check sulla diagonale principale, partendo da sinistra verso destra
                {
                    if(spotColor == color)
                        counterDiagonal1++;
                    else
                        counterDiagonal1=0;
                }
                
                if((i+j) == (x+y))  //victory check sulla diagonale secondaria, partendo da destra verso sinistra
                {
                    if(spotColor == color)
                        counterDiagonal2++;
                    else
                        counterDiagonal2=0;
                }
                
                if((counterColumn == 4) || (counterRow == 4) || (counterDiagonal1 == 4) || (counterDiagonal2 == 4))          
                    return true;
                
                System.out.println("Contatore colonna("+i+","+j+"): "+counterColumn);
                System.out.println("Contatore riga("+i+","+j+"): "+counterRow);
                System.out.println("Contatore diagonale 1("+i+","+j+"): "+counterDiagonal1);
                System.out.println("Contatore diagonale 2("+i+","+j+"): "+counterDiagonal2);
            }
        }
       
        return false;
    }
}
