package cjameskeller;

public class Candidate {

    public Candidate(int yearsExp, int count) {
        this.yearsExp = yearsExp;
        this.count = count;
    }

    private int linesOfCode = 9000;
    public int yearsExp;
    public int bonus = 0;
    public int jobChance;
    public String result;
    public int count = 5;
    public String yearsOfExperience;

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getLinesOfCode() {
        return this.linesOfCode;
    }
}
