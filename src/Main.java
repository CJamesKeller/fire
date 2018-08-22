public class Main {

    public static void main(String[] args) {
        int linesOfCode;
        int yearsExp;
        int bonus;
        int jobChance;
        String result;

        linesOfCode = 9000;
        yearsExp = 1;
        bonus = 1000;

        jobChance = calcJobChance(linesOfCode, yearsExp, bonus);
        result = resultString(jobChance);

        System.out.println(result + jobChance);
    }

    private static boolean isFirstProject() {
        return (Math.random() < 0.4);
    }

    private static boolean isCustomerFacing() {
        return (Math.random() < 0.6);
    }

    private static int calcJobChance(int linesOfCode, int yearsExp, int bonus) {
        if (isFirstProject()) {
            return linesOfCode + (yearsExp * bonus);
        }

        return -1;
    }

    private static String resultString(int jobChance) {
        String result;
        int minimum;

        result = "";
        minimum = 1000;

        if (isCustomerFacing()) {
            if (jobChance < minimum) {
                result += "We're sorry, ";
            } else {
                result += "Congratulations, ";
            }

            result += "your ";
        }

        result += "chances of getting a job are ";

        return result;
    }
}
