package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 전화번호목록trie {
	
	public static class TrieNode{
		
		private Map<Character,TrieNode> childNodes = new HashMap<>();
		
		private boolean isLastChar;
		
		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
		
		
		
	}
	
	public static class Trie {
		private TrieNode rootNode;

		public Trie() {
			this.rootNode = new TrieNode();
		}
		
		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			
			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setLastChar(true);
		}
		
		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;
			
			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				
				if(node == null)
					return false;
				thisNode = node;
			}
			
			if(thisNode.isLastChar()) {
				if(thisNode.getChildNodes().isEmpty()) {//검색어 끝에 도달했는데, 뒤에 더없으면 접두어 아님.
					return false;
				}
			}
			
			return true;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		loop :for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			Trie trie = new Trie();
			List<String> arr = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				trie.insert(str);
				arr.add(str);
			}
			
			for (String str : arr) {
				if(trie.contains(str)) {
					System.out.println("NO");
					continue loop;
				}
			}
			System.out.println("YES");
		}
		
	}

}
