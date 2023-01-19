package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5014 {
	/* 스타트링크 s1
	 * 유형: 최소경로1개, 몇가지 방법의 비용이 동일한 bfs
	 * */
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static Queue<Integer> q = new LinkedList<>();
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if (S == G) {
			System.out.println(0);
			return;
		}
		distance = new int[F + 1];
		visited = new boolean[F + 1];
		distance[S] = 0;
		visited[S] = true;
		q.add(S);
		bfs();
		if (distance[G] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(distance[G]);
		}

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int now = q.poll();
			int next = 0;
			for (int i = 0; i < 2; i++) {// up and down
				if (i == 0 && now + U <= F) {// up 비용(결과에 영향)은 같음 == 1초
					next = now + U;
				} else if (i == 1 && now - D >= 1) {// down
					next = now - D;
				}

				// 범위 예외처리
				if (next < 1 || next > F) {
					continue;
				}
				// 목적지 도착
				if (next == G) {
					distance[next] = distance[now] + 1;
					return;
				}

				// 거리 비교 add 방문 안했거나 거리상 가도되겠다 싶으면
				if (!visited[next]) {
					visited[next] =true;
					q.add(next);
					distance[next] = distance[now] + 1;
				}
			}
		}

	}
}
