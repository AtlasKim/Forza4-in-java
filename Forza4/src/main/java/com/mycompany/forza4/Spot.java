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
public class Spot {
    private int x;
    private int y;
    private Piece piece = null;
    
    public Spot(int x,int y)
    {
            setX(x);
            setY(y);
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return(this.x);
    }
    
    public int getY()
    {
        return(this.y);
    }
    
    public Piece getPiece()
    {
        return(this.piece);
    }
    
    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }
    
    public boolean occupied()
    {
        if(this.piece == null)
            return false;
        else
            return true;
    }
}
