package DFSorBFS;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class p11724 {
	static List<Integer>[] li;
	static Boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		li = new ArrayList[N + 1];// 연결 리스트 생성
		visited = new Boolean[N + 1]; // 노드들이 방문했는지 안했는지 아는 배열
		for (int i = 1; i < N + 1; i++) {
			li[i] = new ArrayList<Integer>();
			visited[i] = false;
		}
		for (int i = 0; i < M; i++) {// 인접 리스트 초기화
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			li[e].add(v);
			li[v].add(e);

		}
		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			if (visited[i] == false) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

	static void DFS(int v) {
		if (visited[v] == true) {
			return;
		}
		visited[v] = true;
		for (int i : li[v]) {
			if (visited[i] == false) {
				DFS(i);
			}
		}
	}

}
