
/**
 * Title:       DiceOddsTester
 * Semester:    COP3337-Summer2022
 * @author:     Dianelys Rocha
 * 
 
 
 * This program simulates the wins and losses for
 * two different games of dice.
 */
public class GameSimulator {

    private int tries;
    private Die d1, d2;
    private int wins;
    private int losses;

    /**
     * Construct a simulator object for die games.
     *
     * @param numSides the number of sides on the die.
     * @param numTries the number of times to run the simulation.
     */
    public GameSimulator(int numSides, int numTries) {
        tries = numTries;
        d1 = new Die(numSides);
        d2 = new Die(numSides);
    }

    /**
     * Runs a single die simulation. One die is cast 4 times. If a six appears
     * in those 4 casts, then wins is incremented, otherwise losses is
     * incremented. Simulation is run according to the number of tries set.
     */


    public void runSingleDieSimulation()
    {
        //making sure wins and losses do not hold values from previous runs
        wins = 0;
        losses = 0;

        //creating variaables to hold if there was a 6 in the cast, and the cast itself
        boolean isSix;
        int d1Value;


        //outter loop for the number of tries
        for (int i = 0; i < tries; i++) {
            //setting the value to false each time a new try beggins
            isSix = false;
            for (int j = 0; j < 4; j++) {
                d1Value = d1.cast();//holds the cast this time
                if (d1Value == 6) {
                    isSix = true;//if it was a 6, this turns to true
                }
            }

            //updates the wins/losses if there was a 6 or not
            if (isSix) {
                wins++;
            } else {
                losses++;
            }
        }
    }

    /**
     * Runs a double die simulation. A pair of dice are cast 24 times. If a
     * double-six appears in those 24 casts, then wins is incremented, otherwise
     * losses is incremented. The simulation is run according to the number of
     * tries set.
     */


    public void runDoubleDieSimulation()
    {
        //making sure wins and losses do not hold values from previous runs
        wins = 0;
        losses = 0;

        //boolean to hold if both dice were 6
        boolean areBothSix;

        for (int i = 0; i < tries; i++)
        {
            //initializing boolean to false each new try
            areBothSix = false;

            for (int j = 0; j < 24; j++)
            {
                if (d1.cast() == 6 && d2.cast() == 6)
                    areBothSix = true;// if both dice are 6, update boolean
            }

            //update wins/looses
            if (areBothSix)
                    wins++;
            else
                    losses++;
        }
    }

    /**
     * Returns the % of wins.
     *
     * @return the % of wins.
     */
    public double getWinPercent() {
        return (double) (wins) / (wins + losses);
    }

    /**
     * Returns the number of wins.
     *
     * @return the number of wins.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns the number of losses.
     *
     * @return the number of losses.
     */
    public int getLosses() {
        return losses;
    }
}
