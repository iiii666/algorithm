package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1707 {
	static List<Integer>[] li;
	static Queue<Integer> q;
	static int[] twograph;
	static String result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {// test case
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			twograph = new int[V + 1];
			li = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			result = "YES";
			for (int l = 0; l < V + 1; l++) {
				li[l] = new ArrayList<>();

			}

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int temp = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());

				li[temp].add(temp2);
				li[temp2].add(temp);
			}
			q.add(1);
			twograph[1] = 1;
			bfs(V, E);
			System.out.println(result);
		}
	}

	public static void bfs(int V, int E) {

		for (int i = 1; i < V + 1; i++) {
//			if (!q.isEmpty()) {
			int now = i;
			for (int j = 0; j < li[now].size(); j++) {
				if (twograph[li[now].get(j)] == 0) {
					q.add(li[now].get(j));
					twograph[li[now].get(j)] = twograph[now] + 1;
				} else if (twograph[li[now].get(j)] != 0) {
					if (twograph[li[now].get(j)] % 2 == twograph[now] % 2) {
						result = "NO";
						return;
					} else {
						q.add(li[now].get(j));
					}
				}
			}
//			} else {
//				break;
//			}

		}

	}
}
