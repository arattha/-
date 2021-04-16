package Studies;


import java.util.ArrayList;
import java.util.Scanner;

public class 모진혁 {
static int x,y;
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int garo =sc.nextInt();
    int sero =sc.nextInt();
    int n=sc.nextInt();
    ArrayList<int[]> result=new  ArrayList<int[]>(); 
    for(int i=0;i<n;i++) {
        int dir=sc.nextInt();
        int which=sc.nextInt();
        if(dir==1) {
            result.add(new int[] {0,which});
        }
        else if(dir==2) {
            result.add(new int[] {sero,which});
        }
        else if(dir==3) {
            result.add(new int[] {which,0});
        }
        else if(dir==4) {
            result.add(new int[] {which,garo});
        }
    }
    int dir=sc.nextInt();
    y=sc.nextInt();
    if(dir==1) {
        x=0;
    }
    else if(dir==2) {
        x=sero;
    }
    else if(dir==3) {
        x=y;
        y=0;
    }
    else if(dir==4) {
        x=y;
        y=garo;
    }
    int ans=0;
    for(int i=0;i<n;i++) {
        int[] arr=result.get(i);
        int dr=arr[0];
        int dc=arr[1];
        if((dr==0&&x==sero)||(dc==0&&y==garo)) {
            if((dr==0&&x==sero)) {
                int cnt=0;
                cnt=Math.min(dr+x+dc+y, dr+x+garo-dc+garo-y);
                ans+=cnt;
                continue;
            }
            else {
                int cnt=0;
                cnt=Math.min(dc+y+dr+x,dc+y+sero+sero-dr-x);
                ans+=cnt;
                continue;
            }
        }
        else {
            int cnt=0;
            int garo1;
            int sero1;
            garo1=x-dr;
            sero1=y-dc;
            cnt+=Math.abs(garo1);
            cnt+=Math.abs(sero1);
            ans+=cnt;

        }
    }
    System.out.println(ans);
}

}

