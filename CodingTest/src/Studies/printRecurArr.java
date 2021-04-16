package Studies;

public class printRecurArr {

	static int[] arr= {1,2,3,4,5};
	static int[][] arr2= {{1,2,3,4,5},
						{1,2,3,4,5},
						{1,2,3,4,5},
						{1,2,3,4,5},
						{1,2,3,4,5}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printArr1(0);
	}
	
	public static void printArr1(int i,int j) {
		if(j==arr2[i].length)
			return;
		System.out.println(arr2[i][j]);
		printArr1(i,j+1);
	}
	
	public static void printArr2(int n) {
		//printArr2(i)
	}
}
