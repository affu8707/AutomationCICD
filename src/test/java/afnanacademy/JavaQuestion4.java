package afnanacademy;

public class JavaQuestion4 {
	
	public static void main(String[] args) {
		String str = "selenium";
		String reversed = "";
		
		for(int i=str.length()-1;i>=0;i--) {
			reversed = reversed + str.charAt(i);
		}
		System.out.println("Original String  :"+str);
		System.out.println("Reversed String :"+ reversed);
	}

}
