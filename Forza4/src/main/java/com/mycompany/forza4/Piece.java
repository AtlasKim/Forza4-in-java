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

public class Piece {

    private Colore pieceColor;
    
    public Piece(Colore pieceColor)
    {
        setPieceColor(pieceColor);
    }
    
    public void setPieceColor(Colore pieceColor)
    {
        this.pieceColor = pieceColor;
    }
    
    public Colore getPieceColor()
    {
        return(this.pieceColor);
    }
}
