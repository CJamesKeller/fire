public class Main {

    public static void main(String[] args) {

        boolean firstProject = true;
        int linesOfCode = 9000;
        int yearsExp = 1;
        int bonus = 1000;

        int jobChance = calcJobChance(firstProject, linesOfCode, yearsExp, bonus);
        System.out.println("Your chances of getting a job are " + jobChance);
    }

    public static int calcJobChance(boolean firstProject, int linesOfCode, int yearsExp, int bonus) {
        if (firstProject) {
            int chances = linesOfCode + (yearsExp * bonus);
            return chances;
        }

        return -1;
    }
}
