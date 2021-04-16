package Studies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class shift {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr= {1,2,3,4,5,6};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			rightRotate();
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void leftRotate(){
	    int temp = arr[0];
	    for(int i =1; i<=arr.length-1;i++){
	        arr[i-1] = arr[i]; //[2,3,1]
	    }
	    arr[arr.length-1] = temp;
	} // 2, 3, 4, 5, 1
	
	public static void rightRotate(){
	    int temp = arr[arr.length-1];
	    for(int i =arr.length-1;i>=1;i--){
	        arr[i] = arr[i-1];
	    }
	    arr[0] = temp;
	} // 5, 1, 2, 3, 4
	
}