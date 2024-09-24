import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Preception_TestImpl {

    public static void main(String[] args) {
        
        // Introduction
        String name  = JOptionPane.showInputDialog(null, """
                                                         <html><h1 style = 'font-family: Serif; font-size= 14pt; '>In this test, you will be asked to percieve from mentioned five colors,shapes or both." 
                                                         There will be five rounds in this perception test.
                                                         You can now reprsent yourself in the test.
                                                         Please enter your first name:""", "WELCOME!", 1);

        // String Values Used Throughout The Program

        String cardGenerated = ("Your card has been generated.");
        String whatShapes = (cardGenerated + "\nWhat Shape  do you perceive?");
        String whatColor = (cardGenerated + "\nWhat Color do you perceive?");

        String[] colorList = {"red", "blue", "green", "yellow", "black"};
        String[] ShapeList = {"square","circle","star","wavy","plus"};

        // Images
       
        ImageIcon WelcomeIcon = new ImageIcon("psi_cards/welcome1.png");
        ImageIcon question = new ImageIcon(("psi_cards/question.png"));
        ImageIcon unknownIcon = new ImageIcon("psi_cards/unknown.png");

        // Welcome Screen

        String[] welcomeOptions = {"Play","Quit"};

        int play = JOptionPane.showOptionDialog(null, "Would you like to continue the Perception Game!", "Perception Test",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, WelcomeIcon , welcomeOptions , welcomeOptions[0]);

        if (play != 0) System.exit(0);

        int colorRight = 0;
        int ShapeRight = 0;
        int bothRight = 0;

        // Play 5 More Loop

        int continueOrEndGame = 1;
        int Counter = 0;

        String scoreboard = "";

        while (continueOrEndGame == 1) {

            // Choose Test Screen

            String chooseTestString = ("Which perception test would you like to preform?");
            String testString = ("");
            String[] testButtons = {"Shapes", "Color", "Both"};

            int testChosen = JOptionPane.showOptionDialog(null, chooseTestString, "Choose Test",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, question , testButtons, testButtons[0]);

            switch (testChosen) {
                case 0 -> testString = "Shapes";
                case 1 -> testString = "Color";
                case 2 -> testString = "Both";
            }

            int roundNumber = 1;

            while (roundNumber <= 5) {

                // Random Image Generator

                Random randGen = new Random();
                int color = randGen.nextInt(5);
                int shapes = randGen.nextInt(5);

                String colorDialog = ("The color generated was : " + colorList[color]);
                String shapesDialog = ("The Shape generated was : " + ShapeList[shapes]);

                String randomFileName = "psi_cards/" + colorList[color] + "AND" + ShapeList[shapes] + ".png";
                ImageIcon randomIcon = new ImageIcon(randomFileName);

                //

                String winningRound = ("Congrats! You were correct!");
                String losingRound = ("Sorry, better luck next time.");

                String[] next = {"Next"};

                String testPerception;

                switch (testString) {
                    case "Shapes" -> {
                        testPerception = ("The Shape you perceived : ");

                        int ShapeRepeatInt = JOptionPane.showOptionDialog(null, whatShapes, "Choose Shape",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, ShapeList, ShapeList[0]);

                        testPerception += (ShapeList[ShapeRepeatInt] + "\n" + shapesDialog + "\n");
                        if (Objects.equals(ShapeList[ShapeRepeatInt], ShapeList[shapes])) {
                            testPerception += winningRound;
                            ShapeRight += 1;
                        } else {
                            testPerception += losingRound;
                        }

                        int results = JOptionPane.showOptionDialog(null, testPerception, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, next[0]);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        Counter++;

                    }
                    case "Color" -> {
                        testPerception = ("The color you perceived : ");
                        int colorRepeatInt = JOptionPane.showOptionDialog(null, whatColor, "Choose Color",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, colorList, colorList[0]);

                        testPerception += (colorList[colorRepeatInt] + "\n" + colorDialog + "\n");
                        if (Objects.equals(colorList[colorRepeatInt], colorList[color])) {
                            testPerception += winningRound;
                            colorRight += 1;
                        } else {
                            testPerception += losingRound;
                        }

                        int results = JOptionPane.showOptionDialog(null, testPerception, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, next[0]);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        Counter++;

                    }

                    case "Both" -> {

                        String bothColorDialog = (cardGenerated + "\nwhat color would you like to perceive?");
                        String bothShapesDialog = ("Please enter your second choice. \nWhich Shape would you like to perceive?");
                        String colorResults = ("The color you perceived : ");
                        String ShapeResults = ("The Shape you perceived : ");

                        int colorRepeatInt = JOptionPane.showOptionDialog(null, bothColorDialog, "Choose Color",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, colorList, colorList[0]);

                        String repeatString = ("Your choice of color was " + "");
                        String bothSecDialog = (repeatString + colorList[colorRepeatInt] + "\n" + bothShapesDialog);

                        int ShapeRepeatInt = JOptionPane.showOptionDialog(null, bothSecDialog, "Choose Shape",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, ShapeList, 0);

                        String bothIfString;

                        String colorChosenUser = colorList[colorRepeatInt];
                        String colorChosenRandom = colorList[color];
                        String ShapeChosenUser = ShapeList[ShapeRepeatInt];
                        String ShapeChosenRandom = ShapeList[shapes];

                        if (Objects.equals(colorChosenUser, colorChosenRandom) && (!Objects.equals(ShapeChosenUser, ShapeChosenRandom))) {

                            bothIfString = (colorResults + colorChosenUser + "\n" + colorDialog + "\n" + "Good perception on color!\n\n");
                            colorRight++;
                            bothIfString += (ShapeResults + ShapeChosenUser + "\n" + shapesDialog + "\n" + "perceptions could differ!");

                        } else if (!Objects.equals(colorChosenUser, colorChosenRandom) && (Objects.equals(ShapeChosenUser, ShapeChosenRandom))) {

                            bothIfString = (ShapeResults + ShapeChosenUser + "\n" + shapesDialog + "\n" + "Good perception on Shape!\n\n");
                            ShapeRight++;
                            bothIfString += (colorResults + colorChosenUser + "\n" + colorDialog + "\n" + "perceptions could differ!\n\n");

                        } else if (Objects.equals(colorChosenUser, colorChosenRandom) && (Objects.equals(ShapeChosenUser, ShapeChosenRandom))) {

                            bothIfString = (colorResults + colorChosenUser + "\n" + colorDialog + "\n"  + "Good perception on color!\n\n");
                            bothIfString += (ShapeResults + ShapeChosenUser + "\n" + shapesDialog + "\n" + "Good perception on Shape!");
                            bothRight++;

                        } else {

                            bothIfString = (ShapeResults + ShapeChosenUser + "\n" + shapesDialog + "\n" + "perceptions could differ!\n\n");
                            bothIfString += (colorResults + colorChosenUser + "\n" + colorDialog + "\n" + "perceptions could differ!");

                        }

                        int results = JOptionPane.showOptionDialog(null, bothIfString, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, 0);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        Counter++;

                    }

                }
            }

            String colorScore = "";
            String ShapeScore = "";
            String bothScore = "";
            String roundCount = "Total Rounds Played -> " + Counter;

            if (colorRight > 0 && ShapeRight == 0 && bothRight == 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                scoreboard = (roundCount + "\n" + colorScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && ShapeRight > 0 && bothRight == 0) {
                ShapeScore = "Your Total Shapes Score ->  -> " + ShapeRight;
                scoreboard = (roundCount + "\n" + ShapeScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && ShapeRight == 0 && bothRight > 0) {
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && ShapeRight > 0 && bothRight == 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                ShapeScore = "Your Total Shapes Score ->  -> " + ShapeRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + ShapeScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && ShapeRight == 0 && bothRight > 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && ShapeRight > 0 && bothRight > 0) {
                ShapeScore = "Your Total Shapes Score ->  -> " + ShapeRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + ShapeScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && ShapeRight > 0 && bothRight > 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                ShapeScore = "Your Total Shapes Score ->  -> " + ShapeRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + ShapeScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else {
                scoreboard = (roundCount + "\n" + "You scored no points" +
                        "\nWould you like to play again?");
            }

            String[] endGame = {"Quit", "Play Another 5 Rounds"};
            continueOrEndGame = JOptionPane.showOptionDialog(null, scoreboard, "Test Over",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, question, endGame, 0);
    
        }
        String end = "<html><h2 style = 'font-family: Sans-Serif; font-seize: 18pt;'> Thank you " +name+ " for playing.\n\n";
                    end += "<html><h2 style = 'font-family: Sans-Serif; font-seize: 12pt;'> Hope you had a good time \n";
            JOptionPane.showMessageDialog(null, end , "END OF THE GAME", 0);
    }
}