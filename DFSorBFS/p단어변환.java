package DFSorBFS;

public class p단어변환 {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(s.solution("hit", "cog", words));
	}
	static class Solution {
		static boolean[] visited;
		static int result = 51;

		public int solution(String begin, String target, String[] words) {
			visited = new boolean[words.length];

			dfs(begin, target, words, 0);

			if (result == 51) {
				return 0;
			}

			return result;
		}

		public void dfs(String begin, String target, String[] words, int sum) {
			if (begin.equals(target)) {// 탈출조건
				result = Math.min(sum, result);
				return;
			} else {
				for (int i = 0; i < words.length; i++) {
					if ( visited[i] == false && check(begin, words[i]) ) {// 1글자만 다르면
						visited[i] = true;
						dfs(words[i], target, words, sum + 1);
						visited[i] = false;
					}
				}

			}
		}
		public boolean check(String begin, String target) {// 1글자만 다른지 체크
			int count = 0;
			for (int i = 0; i < target.length(); i++) {
				if (begin.charAt(i) == target.charAt(i)) {
					count++;
				}
			}
			if (count == target.length() - 1) {
				return true;
			} else {
				return false;
			}
		}

	}
}

