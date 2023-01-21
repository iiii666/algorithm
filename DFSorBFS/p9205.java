package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9205 {
	/* 맥주 마시면서 걸어가기 g5 
	 * 유형 : 각 지점마다 양방향 이며 , 가중치가 존재 하지 않는다.
	 * 푸는 방법 리스트 배열을 생성해서 각 노드마다 조건을 충족시키는 노드들을 연결.
	 * 후에 bfs 시작돌리는 것
	 * 
	 * */
	static List<int[]> li;
	static boolean[] visited;
	static int n;
	static String result;

	static Queue<Integer> q;
	static List<Integer>[] connect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			result = "sad";
			n = Integer.parseInt(br.readLine());
			li = new ArrayList<>();
			connect = new ArrayList[n + 2];
			q = new LinkedList<>();
			for (int j = 0; j < n + 2; j++) {
				st = new StringTokenizer(br.readLine());
				li.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
				connect[j] = new ArrayList<>();
			}

			// 연결된점
			for (int start = 0; start < li.size(); start++) {
				for (int end = 0; end < li.size(); end++) {
					if (Math.abs(li.get(start)[0] - li.get(end)[0])
							+ Math.abs(li.get(start)[1] - li.get(end)[1]) <= 1000 && start != end) {
						connect[start].add(end);

					}
				}
			}

			visited = new boolean[n + 2];
			visited[0] = true;
			q.add(0);

			bfs();
			System.out.println(result);

		}

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < connect[now].size(); i++) {
				if (!visited[connect[now].get(i)]) {

					if (connect[now].get(i) == connect.length - 1) {
						result = "happy";
						break;
					}
					q.add(connect[now].get(i));
					visited[connect[now].get(i)] = true;
				}
			}

		}

	}

}
