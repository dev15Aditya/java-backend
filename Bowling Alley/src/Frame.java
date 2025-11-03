public class Frame {
    private int chance1;
    private int chance2;
    private int chance3;
    private boolean strike;
    private boolean spare;
    private int frameScore;

    public Frame(int chance1, int chance2) {
        this.chance1 = chance1;
        this.chance2 = chance2;
        computeScore();
    }

    public Frame(int chance1, int chance2, int chance3) {
        this.chance1 = chance1;
        this.chance2 = chance2;
        this.chance3 = chance3;
        computeScore();
    }

    private void computeScore() {
        if (chance1 == 10) {
            strike = true;
            spare = false;
            frameScore = 10 + 10; // fixed bonus
        } else if (chance1 + chance2 == 10) { // Spare
            strike = false;
            spare = true;
            frameScore = 10 + 5; // fixed bonus
        } else {
            frameScore = chance1 + chance2;
        }

        if (chance3 > 0) {
            frameScore += chance3; // add any extra ball score (final round)
        }
    }

    public int getFrameScore() {
        return frameScore;
    }

    public String getDisplaySymbol() {
        if (strike) return "X, ";
        else if (spare) return chance1 + ",/";
        else return chance1 + "," + chance2;
    }
}
