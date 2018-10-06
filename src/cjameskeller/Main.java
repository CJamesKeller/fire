package cjameskeller;

import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Candidate candidate = new Candidate(5, 4);

        candidate.setLinesOfCode(10000);

        if (0 > candidate.yearsExp) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many years of experience do you have?");
            candidate.yearsOfExperience = scanner.nextLine();

            candidate.yearsExp = Integer.parseInt(candidate.yearsOfExperience);
            scanner.close();
        }

        if (isGettingBonus(candidate.getLinesOfCode(), candidate.yearsExp)) {
            candidate.bonus = 1000;
        }

        if ((candidate.bonus > 0) && (candidate.yearsExp > 1)) {
            candidate.jobChance = calcJobChance(candidate.getLinesOfCode(), candidate.yearsExp, candidate.bonus);
        } else {
            candidate.jobChance = calcJobChance(candidate.getLinesOfCode());
        }

        candidate.result = resultString(candidate.jobChance);

        System.out.println("Counting down to results:");

        while (candidate.count != 0) {
            sleep(1000);
            System.out.println(candidate.count);
            candidate.count--;
        }

        System.out.println(candidate.result + candidate.jobChance);
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
