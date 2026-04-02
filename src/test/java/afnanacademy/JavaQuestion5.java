package afnanacademy;

public class JavaQuestion5 {
	public static void main(String[] args) {
		String str = "I am working in infosys";
		String reversed = " ";
		
		String[] words = str.split(" ");
		
		for(int i=words.length-1;i>=0;i--) {
			reversed = reversed + words[i] + " ";
		}
		
		System.out.println("Original String :"+ str);
		System.out.println("Reversed String :"+reversed);
		
	}

}
