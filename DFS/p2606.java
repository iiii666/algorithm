package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p2606 {
	static List<Integer>[] li;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerN = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		li = new ArrayList[computerN + 1];
		visited = new boolean[computerN + 1];

		StringTokenizer st;
		for (int i = 1; i < computerN + 1; i++) {
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
		DFS(1);
		System.out.println(count);

	}

	static void DFS(int i) {
		if (visited[i] == true) {
			return;
		}
		visited[i] = true;
		if (i != 1) {
			count++;

		}

		for (int temp : li[i]) {
			if (visited[temp] == false) {
				DFS(temp);
			}
		}
	}
}
