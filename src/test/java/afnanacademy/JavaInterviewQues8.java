package afnanacademy;

public class JavaInterviewQues8 {
	
	public static void main(String[] args) {
		int num=1234,sum=0;
		
		
		while(num>0) {
			int rem = num%10;
			sum=sum*10+rem;
			num=num/10;
		}
		System.out.println("Reversed number is :"+sum);
	}

}
