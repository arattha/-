package Studies;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(10));
	}
	
	public static int fact(int n) {
		
		if(n==1)
			return 1;
		return n*fact(n-1);
	}
}
