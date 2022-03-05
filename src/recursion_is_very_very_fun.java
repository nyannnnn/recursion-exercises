import java.util.Scanner;

public class recursion_is_very_very_fun {

	public static double sumReciprocal(int num) {

		if (num == 1) {
			return 1;
		} else if (num <= 0) {
			return -1;
		}

		return (1.0 / num) + sumReciprocal(num - 1);

	}

	public static int fib(int n) {

		if (n <= 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);

	}

	public static int multiply(int x, int y) {

		if (y == 1) {
			return x;
		}
		else if(y == 0) {
			return 0;
		}
		else if (y < 0) {
			return -(multiply(x, Math.abs(y)));
		}
		return x + multiply(x, Math.abs(y - 1));
	}

	public static int findVowels(String s) {

		s = s.toLowerCase();

		if (s.length() >= 1) {
			if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o'
					|| s.charAt(0) == 'u') {
				return 1 + findVowels(s.substring(1));
			}
		} else {
			return 0;
		}

		return findVowels(s.substring(1));

	}

	public static String commas(int n) {
		if (Math.abs(n / 1000) < 1 && n > 0)
			return "+" + n;
		else if (Math.abs(n / 1000) < 1 || n == 0)
			return "" + n;
		if (n % 1000 == 0) {
			return commas(n / 1000) + ",000";
		}
		return commas(n / 1000) + "," + Math.abs(n % 1000);
	}

	public static String insert(String s, char ins) {
		if (s.length() == 1) {
			if (!Character.isLetter(s.charAt(0))) {
				return "";
			}

			return s;
		}

		if (Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(1))
				&& s.toLowerCase().charAt(0) == s.toLowerCase().charAt(1)) {
			return"" +  s.charAt(0) + ins + insert(s.substring(1), ins);
		} else if (!((Character.isLetter(s.charAt(0))))) {
			return insert(s.substring(1), ins);
		} else if (!(Character.isLetter(s.charAt(1)))) {
			return insert(("" + s.charAt(0) + s.substring(2)), ins);
		} else {
			return "" + s.charAt(0) + insert(s.substring(1), ins);
		}

	}

	public static int min(int[] num, int index) {

		if (index == 0) {
			return num[0];
		}

		return Math.min(num[index], min(num, index - 1));
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Which program would you like to run?");
		System.out.println("1. Find the nth term of reciprocal sum");
		System.out.println("2. Find the term in Fibonacci sequence");
		System.out.println("3. Multiply two numbers");
		System.out.println("4. Find the number of vowels");
		System.out.println("5. Formatting an integer");
		System.out.println("6. Insert letters in two consecutive letters");
		System.out.println("7. Find the minimum of an array");

		boolean flag = true;
		while (flag) {
			System.out.print("\nEnter the number of program or type \"exit\" to exit program: ");
			String input = in.nextLine();
			int num;
			String multiInput[];
			try {
				if (input.equals("1")) {
					System.out.print("Enter the nth term you would like to find: ");
					num = Integer.parseInt(in.nextLine());
					if (num <= 0) {
						throw new NumberFormatException();
					}
					System.out.println("The term is: " + sumReciprocal(num));
				} else if (input.equals("2")) {
					System.out.print("Enter the nth term you would like to find: ");
					num = Integer.parseInt(in.nextLine());
					if (num <= 0) {
						throw new NumberFormatException();
					}
					System.out.println("The term is: " + fib(num));
				} else if (input.equals("3")) {
					System.out.print("Enter two numbers you would like to multiply (Seperated by space): ");
					multiInput = in.nextLine().split("\\s");
					System.out.println("The sum is: "
							+ multiply(Integer.parseInt(multiInput[0]), Integer.parseInt(multiInput[1])));
				} else if (input.equals("4")) {
					System.out.print("Enter a string: ");
					input = in.nextLine();
					System.out.println("The number of vowels: " + findVowels(input));
				} else if (input.equals("5")) {
					System.out.print("Enter a integer: ");
					num = Integer.parseInt(in.nextLine());
					System.out.println("The number will be: " + commas(num));
				} else if (input.equals("6")) {
					System.out.print("Enter a word and a symbol (Seperated by space): ");
					input = in.nextLine();
					System.out.println("The word will be: " + insert(input.substring(0, input.lastIndexOf(" ")),
							input.charAt(input.lastIndexOf(" ") + 1)));
				} else if (input.equals("7")) {
					System.out.println("The array is: {123, 87123, 1, -83, -9009, 4166211}");
					// second parameter is the length of the array -1
					System.out.println("The smallest number will be: "
							+ min(new int[] { 123, 87123, 1, -83, -9009, 4166211 }, 5));
				} else if (input.equalsIgnoreCase("exit")) {
					flag = false;
					System.out.println("Thank you for testing");
					in.close();
				} else {
					System.out.println("Invalid input. Try again");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again");
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Invalid input. Try again");
			}
		}

	}

}
