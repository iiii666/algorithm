package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260 {
	static ArrayList<Integer>[] li;
	static boolean[] visited;
	static List<Integer> dfslineUp = new ArrayList<>();
	static Queue<Integer> q;
	static List<Integer> bfslineUp = new ArrayList<>();
	static int temp = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		li = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			li[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			li[s].add(e);
			li[e].add(s);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(li[i]);
		}
		dfslineUp.add(V);
		dfs(V);
		for (int i = 0; i < dfslineUp.size(); i++) {
			System.out.print(dfslineUp.get(i));
			if (i != dfslineUp.size() - 1) {
				System.out.print(" ");
			}
		}

		visited = new boolean[N + 1];

		q.add(V);// 큐에 첫 번째순서 넣고
		visited[V] = true;// 방문했다고 찍고
		bfslineUp.add(V); //이 문제 답인 순서 list에 담고
		temp = q.poll(); //뽑아낸 것을 담아 놓는다 큐에선 이 부분이 중요
		bfs(temp);// 그걸 bfs 돌린다
		System.out.println();
		for (int i = 0; i < dfslineUp.size(); i++) {
			System.out.print(bfslineUp.get(i));
			if (i != dfslineUp.size() - 1) {
				System.out.print(" ");
			}
		}

	}

	private static void dfs(int v) {
		visited[v] = true;
		for (int i = 0; i < li[v].size(); i++) {
			if (visited[li[v].get(i)] == false) {
				dfslineUp.add(li[v].get(i));
				dfs(li[v].get(i));
			}
		}

	}

	private static void bfs(int v) {

		for (int i = 0; i < li[v].size(); i++) {//그럼 poll된 값의 인접해있는 애들을 다 add해준다
			if (visited[li[v].get(i)] == false && !q.contains(li[v].get(i))) {//그럴 때 혹시 방문했거나 큐안에 있으면 add하지않는다
				q.add(li[v].get(i));
			}
		}
		int poll2 = 0; //poll하기위한 변수 생성 이거 중요하다고 생각
		if (!q.isEmpty()) {//q가 비어있지 않으면
			poll2 = q.poll();//다음 탐색할 값 빼내주고
			visited[poll2] = true;//탐색했다는 정보 저장
			bfslineUp.add(poll2);//이 문제 해결하기위한 list임
			bfs(poll2);//탐색한노드에서 bfs실행
		}

	}

}
