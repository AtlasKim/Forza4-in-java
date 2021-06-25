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
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MyGridLayout extends JFrame{
    private Game forza4;
    private Grid griglia;
    private int i = 0;
    private int spotRow = 10;
    private int victoryIndex = 0;
    private boolean victory;
    
    private double [] xArea;                            //Sono due array che ci aiutano a capire meglio in quale posizione inserire le tessere
    private double [] yArea;
    
    protected static int width = 1069;                  //erano 1169 e 960
    protected static int height = 942;
    //private JLabel status;
    private JPanel boardPanel;
    private JLabel boardIcon;
    private BufferedImage redIcon;
    private BufferedImage greenIcon;
    //private double unit;
    //private JLabel column;
    private int xPos;
    private int yPos;
    private double yOffset;
    private double xOffset;
    private int yColumnFound;
    private int xRowFound;
    private boolean isMouseClicked = false;
    
    public MyGridLayout() throws IOException{
        super();
        Icon board = new ImageIcon(getClass().getResource( "board.png"));  //tutte le immaggini devono essere nella stessa cartella dei file .class
        setSize(width,height);  
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //greenIcon = ImageIO.read(new File("C:\\Users\\Boku no Melo\\Desktop\\Materie Università Carmelo\\Programmazione a oggetti\\PRATICA\\Forza4\\target\\classes\\com\\mycompany\\forza4\\verde.png"));
        forza4 = new Game();
        //status = new JLabel();
       // status.setBackground(java.awt.Color.red);
        //column = new JLabel();
        //column.setBackground(java.awt.Color.BLUE);
        
        boardPanel = new JPanel();                                              //Convertirlo in JLayeredPane
        boardIcon = new JLabel();
        boardIcon.setIcon(board);                                               //Convertire in un tipo diverso di immagine se JLayeredPane dà problemi
        boardPanel.add(boardIcon);                                              
        boardPanel.setBackground(java.awt.Color.black);
        boardPanel.setBounds(0, 0, board.getIconHeight(), board.getIconWidth());  //stabilire come fissare una dimensione massima della boardPanel
       // unit = board.getIconWidth()/7;
        
        boardPanel.setPreferredSize(boardPanel.getSize());
        boardPanel.setMaximumSize(boardPanel.getSize());
        boardPanel.setMinimumSize(boardPanel.getSize());
        
        add(boardPanel,BorderLayout.CENTER);
        boardPanel.addMouseListener(new MouseClickHandler());
        //add(status, BorderLayout.EAST);
        //add(column, BorderLayout.EAST);
        //redIcon = new ImageIcon(getClass().getResource( "rosso.png"));
        redIcon=ImageIO.read(new File("C:\\Users\\Boku no Melo\\Desktop\\Materie Università Carmelo\\Programmazione a oggetti\\PRATICA\\Forza4\\target\\classes\\com\\mycompany\\forza4\\rosso.png"));
        griglia = new Grid();                                                   //cambiare tutte le icone per inserirle nel LayeredPane
        xArea=setXArea(xArea);
        yArea=setYArea(yArea);
        printArray(yArea);
        printArray(xArea);
    }                                                  //TROVARE UN METODO PER STAMPARE BUFFERED IMAGE SOPRA JPANEL USANDO IL METODO DRAWIMAGE
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g.create() ;
        
        if(redIcon != null)
        {
            g2d.drawImage(redIcon, xStampa(xPos), yStampa(yPos),rootPane);
            //g2d.drawImage(redIcon, i, i, rootPane)
        }
            
    }
    
    //@Override
    public class MouseClickHandler implements MouseListener,MouseMotionListener        //era private
    {
        // handle mouse-click event and determine which button was pressed
        @Override
        public void mouseClicked( MouseEvent event )
        {
            setIsMouseClicked(true);                              //stiamo sfruttando un flag per fare dei controlli nel test e bloccare l'esecuzione
            xPos = event.getX(); // get x-position of mouse
            yPos = event.getY(); // get y-position of mouse
            yColumnFound = findColonna(xPos,yArea);
            xRowFound = findRiga(yPos,xArea);
            
            System.out.println("X :"+xPos);
            System.out.println("Y :"+yPos);
            System.out.println("Colonna effettiva :"+yColumnFound);
            
            //metodo per stampare a schermo la tessera
            
            try {
                forza4.printGrid();
            
                spotRow = forza4.getPlayer(i%2).move(forza4.getGrid(), yColumnFound);
                //}
            

            
                victory = forza4.victoryCheck(spotRow, yColumnFound, forza4.getPlayer(i%2).getPlayerColor());
            
                victoryIndex = i;
                i++;
                forza4.printGrid();
                JLabel picLabel = new JLabel(new ImageIcon(redIcon));
                boardPanel.add(picLabel);
                boardPanel.repaint();
                //status.setText(String.format("Cliccato a [%d,%d], andrebbe nella colonna ",xPos,yPos));
                //status.setText(String.format("Cliccato a [%d,%d]",xPos,yPos));
                //column.setText(String.format(" Andrebbe nella colonna %d",(int)(xPos/unit)));         
            
            if(victory == true)
            {
                
                    if(forza4.getPlayer(victoryIndex%2).getPlayerColor() == Color.ROSSO)
                        System.out.println("Giocatore rosso, hai vinto! Volete giocare ancora? (Y/N)");
                    else
                        System.out.println("Giocatore verde, hai vinto! Volete giocare ancora? (Y/N)");
            }
            }catch (Exception ex) {
                    Logger.getLogger(MyGridLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    }    
    /*public double getUnit()
    {
        return unit;
    }*/
    
    public double[] setYArea(double []yArea)
    {
        
        yArea = new double [Grid.colonne];                                      //avrà una dimensione che dipende da quella dell'immagine e della griglia
        yOffset = boardPanel.getWidth()/Grid.colonne; 
        
        for(int i = 0; i<Grid.colonne;i++)
        {
            yArea[i]=(yOffset*i);                                               // |0| |offset| |offset*2|
        }
        
        return yArea;
    }
    
    public double[] setXArea(double []xArea)
    {
        xArea = new double [Grid.righe];
        xOffset = boardPanel.getHeight()/Grid.righe;
        
         for(int i = 0; i<Grid.righe;i++)
        {
            xArea[i]=(xOffset*i);                                               // |0| |offset| |offset*2|
        }
        
        return xArea;
    }
    
    
    
    public int findColonna(int xPos, double []xArea)                            //ritorna l'indice corretto della colonna dove andrebbe inserita la tessera
    {
        for(int i=0;i<xArea.length;i++)
        {
            if(xPos<=xArea[i])                                                   //            170
                return i-1;                                                     // 0    157,4    300
        }
        return xArea.length-1;
    }
    
    public int findRiga(int yPos, double []yArea)                            //ritorna l'indice corretto della colonna dove andrebbe inserita la tessera
    {
        for(int i=0;i<yArea.length;i++)
        {
            if(yPos<=yArea[i])                                                   //            170
                return i-1;                                                     // 0    157,4    300
        }
        return yArea.length-1;
    }
    
    public int xStampa(int x)
    {
        return (int) ((xArea[x]+xOffset)/2);
    }
    
    public int yStampa(int y)
    {
        return (int) ((yArea[y]+yOffset)/2);
    }
    
    public void printArray(double []pos)
    {
        for(int i=0;i<pos.length;i++)
        {
            System.out.println(pos[i]);
        }
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getYPos()
    {
        return yPos;
    }
    
    public int getYColumnFound()
    {
        return yColumnFound;
    }
    
    public boolean getIsMouseClicked()
    {
        return isMouseClicked;
    }
    
    public void setIsMouseClicked(boolean flag)
    {
        isMouseClicked = flag;
    }
    
    public boolean getVictory()
    {
        return victory;
    }
    
    public void setVictory(boolean flag)
    {
        victory = flag;
    }
}
