package Studies;

public class 행열대각합 {
	static int arr[][]= {{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {//행합열합
			int sum=0;
			for (int j = 0; j < arr.length; j++) {
				sum+=arr[j][i];
			}
			System.out.println(sum);
		}
		int sum=0;
		int sum2=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i==j)
					sum+=arr[i][j];//왼쪽대각합
				if(i==4-j)
					sum2+=arr[i][j];//오른쪽 대각합
			}
		}
		System.out.println(sum+" "+sum2);
	}

}
