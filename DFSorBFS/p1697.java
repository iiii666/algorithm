package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697 {
	/* 숨바꼭질 */
	static int[] dx = { 1, -1, 2 };
	static Queue<Integer> q = new LinkedList<>();
	// static boolean[] visited = new boolean[100001];
	static boolean[] visited = new boolean[100001];
	static int[] distance;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited[N] = true;
		distance = new int[100001];
		distance[N] = 0;
		q.add(N);
		bfs(N, K);
		System.out.println(result);
	}

	public static void bfs(int N, int K) {
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < 3; i++) {
				int x;
				if (i == 2) {
					x = now * dx[i];
				} else {
					x = now + dx[i];
				}
				if (x < 0 || x > 100000 || visited[x]) {
					continue;
				}
				visited[x] = true;
				distance[x] = distance[now] + 1;
				if (x == K) {
					result = distance[x];
					return;
				}
				q.add(x);
			}
		}
	}
}
