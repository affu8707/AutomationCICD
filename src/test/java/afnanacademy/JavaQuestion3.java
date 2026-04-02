package afnanacademy;

public class JavaQuestion3 {
	
	public static void main(String[] args) {
		// initiaze the variable
		int num = 786;
		int sum=0;
		while(num>0) {
			int rem = num%10;
			sum=sum+rem;
			num=num/10;
		}
		System.out.println(sum);
	}

}
