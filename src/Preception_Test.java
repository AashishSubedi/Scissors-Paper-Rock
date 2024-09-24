/*
  Aashish Subedi, Vinisha Chaudhary  
  Creating perception test using loops, nested control structures, image icons 
  and dialog pop-up with zener cards.
  03/20/2023
 */

import javax.swing.*;
import java.util.*;

public class Preception_Test 
{  
    public static void main(String[] args) 
    {
        String [] shapes  = {"square", "circle", "star", "wavy", "plus"};
        String [] colors  = {"red","blue","green","yellow", "black"};
        Object [] options = { "Shape", "Color", "Both", "Quit"};
        String [] endOptions = {"Another 5 trials", "quit"};

        ImageIcon icon  = new ImageIcon("psi_cards/question.png");
        ImageIcon icon1 = new ImageIcon("psi_cards/unknown.png");  
  
        String choose_color = "Choose a color";
        String choose_shape = "Choose a shape";
        String card_result = "Card result";
        String test = "Choose a test";
        String result = "Result so far!";
        String introTitle = "                           A.Subedi and V.Chaudhary";        
        String prompt  = """
                         Wlecome to perception test game!
                         This program shows the guesses user have made choosing the options provided.
                         You can guess color, shape or both for the result!
                         """;
        String testMess = "Which preception test would you like to perform? ";
        String shapeMess ="""
                          Your card has been generated 
                          What shape do you precieve?
                          """ ;
        
        String colorMess ="""
                     Your card has been generated 
                     What color do you precieve?""";
        
        JOptionPane.showMessageDialog(null,prompt,"Introduction"+introTitle,0,icon);
        
        int color_score = 0;
        int shape_score =0;
        int total_game = 0;

        int message = JOptionPane.showOptionDialog(null,testMess,
                test+introTitle, 0,0, icon,options,null); 
        int playAgain = 0;
        
        while(true)
        {
            String shapes_choice ="";
            
            if (message==3)
            {
                JOptionPane.showMessageDialog(null, "Thanks for playing the game!"
                    ,test,0,icon);
                System.exit(0);
            }
            if (message == 0)
            {
                int counter = 0;
                while(counter < 5)
                {
                    Random randGen = new Random();
                    int color          = randGen.nextInt(5);
                    int shape          = randGen.nextInt(5);
                    String randomShape = shapes[shape];

                    int shapechoice = JOptionPane.showOptionDialog(null, shapeMess, 
                     choose_shape+introTitle, 0, 0, icon1, shapes,null);
                    total_game++;

                    switch(shapechoice)
                    {
                        case 0:
                            shapes_choice ="square";
                            break;
                        case 1:
                            shapes_choice ="circle";
                            break;
                        case 2:
                            shapes_choice ="star";
                            break;
                        case 3:
                            shapes_choice ="wavy";
                            break;  
                        case 4:
                            shapes_choice = "plus";
                            break;
                    }
                    String fileName = "psi_cards/"+colors[color]+"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);

                    if(shapes_choice.equals(randomShape))
                    {
                        JOptionPane.showMessageDialog(null,"""
                     Shape preception  
                     you precived: """+ shapes_choice + " "+"\nThe shape was: "
                     + ""+randomShape+  " "+"\nGood precption on shape",card_result+introTitle
                      ,0,icon3);
                        shape_score++;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"""
                     Shape preception  
                     you precived: """+ shapes_choice + " "+"\nThe shape was: "
                     + ""+randomShape+  " "+"\nA bit off "
                     + "on this one ",card_result+introTitle,0,icon3);   
                    }
                     counter++;
                }
                int reGame = JOptionPane.showOptionDialog(null, "You have"
                        +" enetered " +total_game+ " perceptions"+"\nYour shape score is "
                        +shape_score,result+introTitle                                ,
                         0, 0, icon, endOptions, endOptions[0]);
                if(reGame == 0)
                {

                    playAgain++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, """
                                Thanks for playing the game!
                                The game is now ending....Bye!""","Game Ending",
                                0,icon);
                    System.exit(0);
                }
            }
           
            String color_choice="";
            if (message == 1)
            {
                int counter = 0;
                while (counter < 5)
                {
                    Random randGen = new Random();
                    int color          = randGen.nextInt(5);
                    int shape          = randGen.nextInt(5);
                    String randomColor = colors[color];
                    int colorchoice = JOptionPane.showOptionDialog(null, colorMess, 
                         choose_color+introTitle, 0, 0, icon1, colors,null);
                    total_game++;
                    switch(colorchoice)
                    {
                        case 0:
                            color_choice = "red";
                        break;
                        case 1:
                            color_choice = "blue";
                            break;
                        case 2:
                            color_choice = "green";
                            break;
                        case 3:
                            color_choice = "yellow";
                            break;
                        case 4:
                            color_choice = "black";
                            break;    
                    }
                    String fileName = "psi_cards/"+colors[color] +"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);
                    if (color_choice.equals(randomColor))
                    {
                        JOptionPane.showMessageDialog(null,"""
                         Color preception  
                         you precived: """+ color_choice + " "+"\nThe color was: "
                         + ""+randomColor+  " "+"\nGood precption on color",card_result+introTitle,
                         0,icon3);
                        color_score++;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"""
                         Color preception  
                         you precived: """+ color_choice + " "+"\nThe color was: "
                         + ""+randomColor+  " "+"\nA bit off "
                         + "on this one ",card_result+introTitle,0,icon3);
                    }
                     counter++;
                }
                int reGame = JOptionPane.showOptionDialog(null, "You have"
                        +" enetered " +total_game+ " perceptions"+"\nYour color score is "
                        +color_score,result+introTitle                  ,
                         0, 0, icon, endOptions, endOptions[0]);
                if(reGame == 0)
                {
                    playAgain++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, """
                                Thanks for playing the game!
                                The game is now ending....Bye!""","Game Ending",
                                0,icon);
                    System.exit(0);
                }
                
            }
            if (message == 2)
            {
                int counter = 0;
                while(counter < 5)
                {
                    Random randGen = new Random();
                    int color          = randGen.nextInt(5);
                    int shape          = randGen.nextInt(5);
                    String randomColor = colors[color];
                    String randomShape = shapes[shape];
                    int colorchoice = JOptionPane.showOptionDialog(null, """
                                     Your card has been generated. 
                                     You have chosen to test both color and shape!
                                     Your first perception response will be color. 
                                     What color do you perceive?""", choose_color+introTitle, 
                                     JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, 
                                    icon1, colors, null);
                    total_game++;
                    
                    switch(colorchoice)
                    {
                        case 0:
                            color_choice = "red";
                            break;
                        case 1:
                            color_choice = "blue";
                            break;
                        case 2:
                            color_choice = "green";
                            break;
                        case 3:
                            color_choice = "yellow";
                            break;
                        case 4:
                            color_choice = "black";
                            break;    
                    }
                    int shapechoice = JOptionPane.showOptionDialog(null, """
                         Your second perception will be shape. 
                         What shape do you perceive?""", choose_shape+introTitle, 
                        JOptionPane.DEFAULT_OPTION, JOptionPane
                        .QUESTION_MESSAGE, icon1, shapes, null);
                    total_game++;
                    
                    
                    switch(shapechoice)
                    {
                        case 0:
                            shapes_choice = "square";
                            break;
                        case 1:
                            shapes_choice = "circle";
                            break;
                        case 2:
                            shapes_choice = "star";
                            break;
                        case 3:
                            shapes_choice = "wavy";
                            break;  
                        case 4:
                            shapes_choice = "plus";
                            break;
                    }
                    String fileName = "psi_cards/"+colors[color] +"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);
                    
                    if(color_choice.equals(randomColor) && shapes_choice.equals(randomShape))
                    {
                        JOptionPane.showMessageDialog(null, """
                            Both Color and Shape perceptions are correct!
                            You perceived,
                                    Color: """ + color_choice + 
                                    "\n"+"           Shape: "+ shapes_choice + 
                            "\nThe card was " + randomColor + ""+ " and " + 
                            randomShape, card_result+introTitle,JOptionPane.INFORMATION_MESSAGE, icon3);
                        shape_score++;
                        color_score++;
                    }
                    else if (color_choice.equals(randomColor))
                    {
                        JOptionPane.showMessageDialog(null,"""
                            Color perception is correct, but Shape perception is incorrect!
                            You perceived,
                                    Color: """ + color_choice + 
                                    "\n"+""+"        Shape: "+ shapes_choice + 
                                    "\nThe card was " + randomColor + " and " +
                                    randomShape, card_result+introTitle, JOptionPane.INFORMATION_MESSAGE,
                                   icon3);
                        color_score++;
                    }
                    else if (shapes_choice.equals(randomShape))
                    {
                        JOptionPane.showMessageDialog(null,
                            """
                            Shape perception is correct, but Color perception is incorrect!
                            You perceived,
                                     Color: """ +color_choice + 
                                     "\n"+"          Shape: " + shapes_choice + 
                            "\nThe card was " + randomColor + " and " + 
                            randomShape, card_result+introTitle, JOptionPane.
                            INFORMATION_MESSAGE, icon3);
                        shape_score++;
                    
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, 
                            """
                            Both Color and Shape perceptions are incorrect!
                            You perceived,
                                     Color:  """+color_choice +
                                     "\n"+"         Shape:  "
                            + shapes_choice + "\nThe card was " + randomColor + " and " 
                            + randomShape, card_result+introTitle, JOptionPane.INFORMATION_MESSAGE,
                            icon3);
                    }
                     counter++;
                }
                int reGame = JOptionPane.showOptionDialog(null, "You have"
                        +" enetered " +total_game+ " perceptions"+"\nYour color score is "
                        +color_score+"\nYour shape score is "+shape_score,result+introTitle                  ,
                         0, 0, icon, endOptions, endOptions[0]);
                if(reGame == 0)
                {
                    playAgain++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, """
                                Thanks for playing the game!
                                The game is now ending....Bye!""","Game Ending",
                                0,icon);
                    System.exit(0);
                }
            }         
        }
    }
}
