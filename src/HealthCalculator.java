import java.util.Scanner;

public class HealthCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите ваш вес(кг):");
        double weight = scanner.nextDouble();

        System.out.println("введите ваш рост(м):");
        double height = scanner.nextDouble();

        System.out.println("введите ваш возраст:");
        int age = scanner.nextInt();

        double bmi = calculateBMI(weight, height);
        double idealWeight = calculateIdealWeight(height);
        int recommendedCalories = calculateRecommendedCalories(weight, height, age, bmi);

        if (bmi > 24.9) {
            double weightDifference = weight - idealWeight;
            System.out.println("рекомендуется снизить вес. идеальный вес: " + idealWeight +
                    ". необходимо сбросить: " + weightDifference + " кг. рекомендуемый дневной прием калорий: " + recommendedCalories);
        } else if (bmi < 18.5) {
            double weightDifference = idealWeight - weight;
            System.out.println("рекомендуется увеличить потребление пищи для набора веса. идеальный вес: " + idealWeight +
                    ". необходимо набрать: " + weightDifference + " кг. рекомендуемый дневной прием калорий: " + recommendedCalories);
        } else {
            System.out.println("ваш вес находится в пределах нормы. идеальный вес: " + idealWeight +
                    ". рекомендуемый дневной прием калорий: " + recommendedCalories);
        }
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static double calculateIdealWeight(double height) {
        return 24.9 * height * height;
    }

    public static int calculateRecommendedCalories(double weight, double height, int age, double bmi) {
        double bmr;
        if (bmi > 24.9) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height * 100) - (5.677 * age);
            return (int) (bmr - 500);
        } else if (bmi < 18.5) {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height * 100) - (4.330 * age);
            return (int) (bmr + 500);
        } else {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height * 100) - (5.677 * age);
            return (int) bmr; 
        }
    }
}