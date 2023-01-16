package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p13549 {
	/* 숨바꼭질 3 g5
	 * 실수 : 곱셈의경우 시간이 0이라 이거먼저 우선으로 해야한다
	 * 		  거리가 같을때 예외로else처리 안함
	 * 유형 : bfs인데 우선으로 실행해야할것이있음
	 * 
	 * 팁 : 가중치가 다르면 bfs 고려해야한다
	 * */
	
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	static int[] distance = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
		}else { 
			q.add(N);
			visited[N] = true;
			distance[N] = 0;
			bfs(N, K);
			System.out.println(distance[K]);
		}
		
	}

	public static void bfs(int N, int K) {
		while (!q.isEmpty()) {

			int now = q.poll();

			for (int i = 0; i < 3; i++) {

				int next;

				if (i == 0) {
					next = now * 2;
					if (next < 0 || next > 100000) {
						continue;
					}

					if (next == K) {
						distance[next] = distance[now];
						return;
					}

					if (!visited[next]) {
						distance[next] = distance[now];
						visited[next] = true;
						q.add(next);
					}
				} else if (i == 1) {
					next = now - 1;

					if (next < 0 || next > 100000) {
						continue;
					}

					if (next == K) {	
						distance[next] = distance[now] + 1;
						return;
					}

					if (!visited[next]) {
						distance[next] = distance[now] + 1;
						visited[next] = true;
						q.add(next);
					}
				} else {
					next = now + 1;
					if (next < 0 || next > 100000) {
						continue;
					}

					if (next == K) {
						distance[next] = distance[now] + 1;
						return;
					}

					if (!visited[next]) {
						distance[next] = distance[now] + 1;
						visited[next] = true;
						q.add(next);
					}
					

				}

			}

		}
	}
}
