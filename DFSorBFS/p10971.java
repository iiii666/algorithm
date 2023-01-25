package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10971 {
	/*외판원 순회 s2 
	 * 유형 : 가지가 3개 로 선택이아닌 모두 가봐야하는 트리형태
	 * for 문으로 가지 숫자만큼 , 깊이 까지 가서 비교 하기
	 * 
	 * 모든경우중 최소라서 중간 중간 가지치기 가능
	 * 
	 * */
	static int[][] cost;
	static boolean[] visited;
	static int N;
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);
		}
		System.out.println(minCost);
	}

	public static void dfs(int start, int now, int result, int depth) {
		if (result > minCost) {//가지치기
			return;
		}
		if (depth == N - 1) {
			if (cost[now][start] != 0) {
				minCost = Math.min(minCost, result + cost[now][start]);

			}
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i] && cost[now][i] != 0) {
					visited[i] = true;
					dfs(start, i, result + cost[now][i], depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
