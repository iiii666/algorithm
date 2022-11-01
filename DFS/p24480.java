package DFS;

import java.io.*;
import java.util.*;

public class p24480 {
	static List<Integer>[] li;
	static boolean[] visited;
	static int[] route;
	static int temp = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		route = new int[N + 1];
		li = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			li[i] = new ArrayList<Integer>();
			visited[i] = false;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			li[u].add(v);
			li[v].add(u);
		}
		route[R] = temp;
		DFS(R);
		for (int i = 1; i < route.length; i++) {
			System.out.println(route[i]);
		}

	}

	static void DFS(int u) {
		if (visited[u] == true) {
			return;
		}
		visited[u] = true;
		Collections.sort(li[u], Collections.reverseOrder());
		for (int i : li[u]) {
			if (visited[i] == false) {
				temp++;
				route[i] = temp;
				DFS(i);
			}
		}
	}
}
