import java.util.*;

public class Grading_Program {

	// method for User entry with logic limits

	static int scoring(String prompt, Scanner scanner, int min, int max) {

		// displaying prompt

		System.out.print(prompt);

		// reading integer value

		int score = scanner.nextInt();

		// Logic check

		if (score >= min && score <= max) {

			// Within spec

			return score;

		} else {

			// Error message

			System.out.println("Score is outside expected range. The score should be between " + min

					+ " and " + max + ", try again!");

			// Try again loop

			return scoring(prompt, scanner, min, max);

		}

	}

	public static void main(String[] args) throws java.lang.Exception {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter how many students");

		int n = scan.nextInt();

		int a[] = new int[100];

		int b[] = new int[100];

		int total[] = new int[100];

		for (int s = 1; s <= n; s++) {

			int sum = 0;

			System.out.println("Enter the student " + s + " Scores");

			for (int i = 1; i <= 4; i++) {

				// input a score between 0 and 50 for exam

				a[i] = scoring("Exam #" + i + " Score(0-50): ", scan, 0, 50);

				// input a score between 0 and 75 for assignment

				b[i] = scoring("Assigment #" + i + " Score(0-75): ", scan, 0, 75);

				sum = a[i] + b[i] + sum;

			}

			total[s] = sum;

		}

		double average = 0.0, sd = 0.0;

		for (int i = 1; i <= n; i++) {

			average += total[i];

		}

		average /= n;

		for (int i = 1; i <= n; i++) {

			sd += (total[i] - average) * (total[i] - average);

		}

		sd /= n;

		sd = Math.sqrt(sd);

		for (int i = 1; i <= n; i++) {

			// Final grade output

			System.out.print("Student " + (i) + " Total Score (" + total[i] + ")," + " Final Grade is ");

			if (total[i] >= average + (2 * sd)) {

				System.out.println("A");

			} else if (total[i] >= average + (1 * sd)) {

				System.out.println("B");

			} else if (total[i] >= average) {

				System.out.println("C");

			} else if (total[i] >= average - (1 * sd)) {

				System.out.println("D");

			} else {

				System.out.println("F");

			}

		}

	}

}