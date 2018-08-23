import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int linesOfCode;
        int yearsExp;
        int bonus;
        int jobChance;
        String result;
        int count;
        String yearsOfExperience;

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many years of experience do you have?");
        yearsOfExperience = scanner.nextLine();

        linesOfCode = 9000;
        bonus = 0;
        count = 5;

        yearsExp = Integer.parseInt(yearsOfExperience);

        if (isGettingBonus(linesOfCode, yearsExp)) {
            bonus = 1000;
        }

        if ((bonus > 0) && (yearsExp > 1)) {
            jobChance = calcJobChance(linesOfCode, yearsExp, bonus);
        } else {
            jobChance = calcJobChance(linesOfCode);
        }

        result = resultString(jobChance);

        System.out.println("Counting down to results:");

        while (count != 0) {
            System.out.println(count);
            count--;
        }

        System.out.println(result + jobChance);

        scanner.close();
    }

    private static boolean isGettingBonus(int linesOfCode, int yearsExp) {
        switch (yearsExp) {
            case 0:
                return (linesOfCode > 1000);
            case 1:
                return (linesOfCode > 5000);
            case 2:
            case 3:
            case 4:
                return (linesOfCode > (yearsExp * 7000));
            case 5:
                return (linesOfCode > 5000);
            default:
                return false;
        }
    }

    private static boolean isFirstProject() {
        return (Math.random() < 0.4);
    }

    private static boolean isCustomerFacing() {
        return (Math.random() < 0.6);
    }

    private static int calcJobChance(int linesOfCode) {
        if (isFirstProject()) {
            return 0;
        }

        return linesOfCode;
    }

    private static int calcJobChance(int linesOfCode, int yearsExp, int bonus) {
        if (!isFirstProject()) {
            return linesOfCode + (yearsExp * bonus);
        }

        return 0;
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
