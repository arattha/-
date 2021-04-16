package D4;

import java.io.*;
import java.util.StringTokenizer;

public class 사칙연산 {
	
	static Node node[];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			node=new Node[N+1];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str=st.nextToken();
				if( str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") ) {
					node[i]=new Node(str);
					node[i].left=Integer.parseInt(st.nextToken());
					node[i].right=Integer.parseInt(st.nextToken());
				}
				else {
					node[i]=new Node(Integer.parseInt(str));
				}
			}
			inorder(1);
			
			sb.append("#").append(tc).append(" ").append((int)node[1].num).append("\n");
			
		}
		System.out.println(sb);	
	}
	
	public static void inorder(int idx) {
		if(node[idx].left != 0)
			inorder(node[idx].left);
		
		if(node[idx].right != 0)
			inorder(node[idx].right);
		
		if(!node[idx].var.equals("")) {
					
			double leftNum=node[node[idx].left].num;
			double rightNum=node[node[idx].right].num;
			
			switch (node[idx].var.charAt(0)) {
				case '+':
					node[idx].num = leftNum + rightNum;
					break;
				case '-':
					node[idx].num = leftNum - rightNum;			
					break;
				case '*':
					node[idx].num = leftNum * rightNum;
					break;
				case '/':
					node[idx].num = leftNum / rightNum;
					break;
			}
			node[idx].var="";
			node[idx].left=0;
			node[idx].right=0;
		}
	}

}

class Node {
	
	String var="";
	
	double num=-1;
	
	int left;
	int right;
	
	public Node(String var) {
		super();
		this.var = var;
	}
	
	public Node(int num) {
		super();
		this.num = num;
	}
	
}