
public class recursion_is_very_very_fun {

	
	public static double sumReciprocal(int num) {
		
		if(num == 1) {
			return 1;
		}
		else if(num <= 0) {
			return -1;
		}
		
		return (1.0/num) + sumReciprocal(num-1);
		
	}

	public static int fib(int n) {
		
		if(n <= 2) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
		
	}
	
	public static int multiply (int x, int y) {
		
		if(y == 1) {
			return x;
		}
		
		return x + multiply(x, y-1);
	}
	
	public static int findVowels(String s) {
		
		s = s.toLowerCase();
		int count = 0;
		
		if(s.length()>=1) {
			if(s.charAt(0) == 'a' || s.charAt(0) == 'e'|| s.charAt(0) == 'i'|| s.charAt(0) == 'o'|| s.charAt(0) == 'u'){
				count++;
			}
		}
		else {
			return 0;
		}
		
		return count+findVowels(s.substring(1));
		
	}
	
	public static String commas(int n) {
		
		
		
	}
	
	public static void main(String[] args) {

		System.out.println(sumReciprocal(5));
		System.out.println(fib(6));
		System.out.println(multiply(8,7));
		System.out.println(findVowels("AWEsome"));
		
	}

}