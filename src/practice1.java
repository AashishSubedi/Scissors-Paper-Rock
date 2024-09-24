import javax.swing.*;
import java.util.*;

public class practice1 {
    public static void main(String[] args) {
        
       
         // Step 1 - Introduction
        String intro = "<html>Hello, welcome to<br> "+
        "<h2>Perception Test</h2>"+
        "Choose whether you want to guess shape, color or both.<br>"+
        "You get 5 chances to guess before your score is revealed <br>"+
        "You can also keep choosing to play more rounds.<br>"+
        "Each round will consist of five guesses<br>"
        +"Good luck!";
        
        ImageIcon icon = new ImageIcon("psi_cards/question.png");
    
        JOptionPane.showMessageDialog(null, intro,
            "Perception Test", 0, icon);
        
        
        String[] colors = {"red","blue","green","yellow","black"};
        String[] shapes = {"square","circle","star","wavy","plus"};
        
       
        //Ask whether player wants to play color or shape or both
        String prompt = "Which perception test would you like to perform?\n";
        
        String[] choices = {"Shape", "Color", "Both","Quit"};
        int choice = JOptionPane.showOptionDialog(null, prompt,
                        "Perception Test"                  ,
                         0, 0, icon, choices, choices[0]);
        int gameNumber = 1;
        int score = 0;
        while(true){
            if (choice == 0){ // Player has chosen shape
                int count = 1;
                while (count < 6)
                    {Random randGen = new Random();
                    int color = randGen.nextInt(5);
                    int shape = randGen.nextInt(5);
            
                    String message = "Your card has been generated."+"\n"+"What shape do you guess?";
            
                    ImageIcon icon2 = new ImageIcon("psi_cards/unknown.png");
                    int guessShape = JOptionPane.showOptionDialog(null, message,
                        "Perception Test"                  ,
                         0, 0, icon2, shapes, shapes[0]);
            
                    String fileName = "psi_cards/"+colors[color]
                    +"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);
                    if (guessShape == shape)
                        {score ++;
                        String cardResult = "You guessed \""+shapes[guessShape]+"\""+"\n"
                        +"and the shape was \""+shapes[shape]+"\""+"\n"
                        +"Good Perception, Well done!";
                        JOptionPane.showMessageDialog(null, cardResult,"Card Result",0, icon3);
                        }
                    else {
                        String cardResult = "You guessed \""+shapes[guessShape]+"\""+"\n"
                        +"and the shape was \""+shapes[shape]+"\""+"\n"
                        +"Sorry, wrong guess!";
                        JOptionPane.showMessageDialog(null, cardResult,"Card Result",0, icon3);}
          
                    count= count+1;
                    }
    
            String[] cycles = {"Quit", "Another 5 trials"};
            String result = "You have entered "+5*gameNumber+" perceptions.\n"+
            "Your shape perception score is "+score+".";
        
            int continuePlay = JOptionPane.showOptionDialog(null, result,
                        "Perception Test"                  ,
                         0, 0, icon, cycles, cycles[0]);
        
            if (continuePlay == 0)
                break;
            else if (continuePlay == 1)
                gameNumber++;

        }
        
            
        else if (choice == 1)
            {int count = 1;
            while (count < 6)
                {Random randGen = new Random();
                int color = randGen.nextInt(5);
                int shape = randGen.nextInt(5);
            
                String message = "Your card has been generated."+"\n"+"What color do you guess?";
            
                ImageIcon icon2 = new ImageIcon("psi_cards/unknown.png");
                int guessColor = JOptionPane.showOptionDialog(null, message,
                        "Perception Test"                  ,
                         0, 0, icon2, colors, colors[0]);
            
                    String fileName = "psi_cards/"+colors[color]+"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);
                    if(guessColor == color)
                        {score ++;
                        String cardResult = "You guessed \""+colors[guessColor]+"\""+"\n"
                        +"and the color was \""+colors[color]+"\""+"\n"
                        +"Good Perception, Well done!";
                        JOptionPane.showMessageDialog(null, cardResult,"Card Result",0, icon3);}
                    else 
                        {String cardResult = "You guessed \""+colors[guessColor]+"\""+"\n"
                        +"and the shape was \""+colors[color]+"\""+"\n"
                        +"Sorry, wrong guess!";
                        JOptionPane.showMessageDialog(null, cardResult,"Card Result",0, icon3);}
          
            count= count+1;
            }
        
        //int cycleNumber = 1;
            String[] cycles = {"Quit", "Another 5 trials"};
            String result = "You have entered "+5*gameNumber+" .\n"+
            "Your color perception score is "+score+".";
        
            int continuePlay = JOptionPane.showOptionDialog(null, result,
                        "Perception Test"                  ,
                         0, 0, icon, cycles, cycles[0]);
                
        if (continuePlay == 0)
                break;
        else if (continuePlay == 1)
                gameNumber++;
        }
        
        
        else if (choice == 2){
            int count = 1;
            int colorScore = 0;
            int shapeScore = 0;
            int Totalscore = colorScore + shapeScore;
            while (count < 6)
                {Random randGen = new Random();
                int color = randGen.nextInt(5);
                int shape = randGen.nextInt(5);
            
                String messageColor = "Your card has been generated.\n"+
                        "Your first perception is color.\n"+
                        "What color do you guess?";
            
                ImageIcon icon2 = new ImageIcon("psi_cards/unknown.png");
                int guessColor = JOptionPane.showOptionDialog(null, messageColor,
                        "Perception Test"                  ,
                         0, 0, icon2, colors, colors[0]);
                
                String messageShape = "Your card has been generated.\n"+
                        "Your second perception is shape.\n"+
                        "What shape do you guess?";
            
                int guessShape = JOptionPane.showOptionDialog(null, messageShape,
                        "Perception Test"                  ,
                         0, 0, icon2, shapes, shapes[0]);
            
                    String fileName = "psi_cards/"+colors[color]+"AND"+shapes[shape]+".png";
                    ImageIcon icon3 = new ImageIcon(fileName);
                    String cardResultColor = "";
                    String cardResultShape = "";
                    //String cardResult = cardResultColor+ cardResultShape;
                    if (guessColor == color)
                        {colorScore ++;
                        cardResultColor = "You guessed \""+colors[guessColor]+"\""+"\n"
                        +"and the color was \""+colors[color]+"\""+"\n"
                        +"Good Perception, Well done!";
                        }
                    else if (guessShape == shape)
                        {shapeScore ++;
                        cardResultShape = "You guessed \""+shapes[guessShape]+"\""+"\n"
                        +"and the shape was \""+shapes[shape]+"\""+"\n"
                        +"Good Perception, Well done!";
                        }
                    else {
                        cardResultColor = "You guessed \""+colors[guessColor]+"\""+"\n"
                        +"and the color was \""+colors[color]+"\""+"\n"
                        +"Sorry, wrong guess!";
                       
                        cardResultShape = "You guessed \""+shapes[guessShape]+"\""+"\n"
                        +"and the shape was \""+shapes[shape]+"\""+"\n"
                        +"Sorry, wrong guess!";}
                    JOptionPane.showMessageDialog(null, cardResultColor+cardResultShape,"Card Result",0, icon3);
          
            count= count+1;
        }
        
        //int cycleNumber = 1;
            String[] cycles = {"Quit", "Another 5 trials"};
            String result = "You have entered "+5*gameNumber+" perceptions.\n"+
            "Your color perception score is "+colorScore+".\n"
            +"Your shape perception score is "+shapeScore+".\n"
            +"You got both color and shape correct in "+Totalscore+".";
        
            int continuePlay = JOptionPane.showOptionDialog(null, result,
                        "Perception Test"                  ,
                         0, 0, icon, cycles, cycles[0]);
        
            if (continuePlay == 0)
                break;
            else if (continuePlay == 1)
                gameNumber++; 
        }
        
        else if (choice == 3)
            return;
        }
        //end message
        String ending = "Thank you for playing.\n"
                         +"This Program is now ending";
        JOptionPane.showMessageDialog(null, ending,
            "The End", 0, icon);
    }
}