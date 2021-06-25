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

public class Player 
{
    private Color playerColor;
    
    public Player(Color playerColor)    //Costruttore
    {
        setPlayerColor(playerColor);
    }
    
    public void setPlayerColor(Color playerColor)   //set del colore
    {
        this.playerColor = playerColor;
    }
    
    public Color getPlayerColor()                  //get del colore
    {
        return(this.playerColor);
    }
    
    public int move(Grid grid, int y) throws Exception   //mossa giocatore
    {
        if(grid.getSpot(0,y).occupied())
        {
            throw new Exception("Column full");
        }    
        
        for(int i=5;i>=0;i--)
        {
            if(!grid.getSpot(i,y).occupied()) //Ci facciamo ritornare direttamente dalla griglia le coordinate dello spot che ci serve
            {     
                grid.getSpot(i,y).setPiece(new Piece(playerColor));   //se quello spot è libero allora inseriamo lì il pezzo
                return i;
            }
        }
        
        return 10;        //ritorniamo un valore non valido per futuri controlli
    }
}
