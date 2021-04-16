package BaekJoonIM대비;

import java.util.Arrays;
import java.util.Scanner;

public class 경비원 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int height = sc.nextInt();
		int N = sc.nextInt();
		int arr[][] = new int[N][2];
		
		
		for (int i = 0; i < N; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		int man[]= new int[2];
		man[0]=sc.nextInt();
		man[1]=sc.nextInt();
		//1 북 2 남 3 서 4 동
		int sum=0;
		for (int i = 0; i < N; i++) {
			if(man[0]==1) {//내가 북쪽이면
				if(arr[i][0]==1) {
					sum+=Math.abs(man[1]-arr[i][1]);
				}
				else if(arr[i][0]==2){
					int temp=man[1]+arr[i][1];
					if(temp>width)
						temp=(width*2)-temp;
					sum+=height+temp;
				}
				else if(arr[i][0]==3){
					sum+=man[1]+arr[i][1];
				}
				else if(arr[i][0]==4){
					sum+=(width-man[1])+arr[i][1];
				}
			}
			if(man[0]==2) {//내가 남쪽이면
				if(arr[i][0]==1) {
					int temp=man[1]+arr[i][1];
					if(temp>width)
						temp=(width*2)-temp;
					sum+=height+temp;
				}
				else if(arr[i][0]==2){
					sum+=Math.abs(man[1]-arr[i][1]);
				}
				else if(arr[i][0]==3){
					sum+=man[1]+(height-arr[i][1]);
				}
				else if(arr[i][0]==4){
					sum+=(width-man[1])+(height-arr[i][1]);
				}
				
			}
			if(man[0]==3) {
				if(arr[i][0]==1) {
					sum+=man[1]+arr[i][1];
				}
				else if(arr[i][0]==2){
					sum+=(height-man[1])+arr[i][1];
				}
				else if(arr[i][0]==3){
					sum+=Math.abs(man[1]-arr[i][1]);
				}
				else if(arr[i][0]==4){
					int temp=man[1]+arr[i][1];
					if(temp>height)
						temp=(height*2)-temp;
					sum+=width+temp;
				}
			}
			if(man[0]==4) {
				if(arr[i][0]==1) {
					sum+=man[1]+(width-arr[i][1]);
				}
				else if(arr[i][0]==2){
					sum+=(height-man[1])+(width-arr[i][1]);
				}
				else if(arr[i][0]==3){
					int temp=man[1]+arr[i][1];
					if(temp>height)
						temp=(height*2)-temp;
					sum+=width+temp;
				}
				else if(arr[i][0]==4){
					sum+=Math.abs(man[1]-arr[i][1]);
					
				}
			}
			
		}
		System.out.println(sum);
		
	}
	
}
