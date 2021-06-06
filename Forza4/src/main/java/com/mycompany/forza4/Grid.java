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
public class Grid {
    private Spot[][] grid = new Spot[6][7];
    
    public Grid()
        {
            resetGrid();
        }
    
    public void resetGrid()
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                grid[i][j] = new Spot(i,j);
            }
        }
    }
    
    public Spot getSpot(int x,int y) throws Exception
    {
        if (x < 0 || x > 5 || y < 0 || y > 6) {
            throw new Exception("Index out of bound");
        }
  
        return grid[x][y];
    }
    
    /*public void setSpot(int x,int y) throws Exception
    {
        if (x < 0 || x > 5 || y < 0 || y > 6) {
            throw new Exception("Index out of bound");
        }
  
        return grid[x][y];
    }*/
}
