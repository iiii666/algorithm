package DFSorBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p13913 {
	/* 숨바꼭질 5 g4 
	 * 유형 :  bfs 로 최소경로, 그리고 그 경로를 구하는 것
	 * 
	 * 해결 :  parent[] 로 이전의 위치를 찍어줌
	 * 
	 * */
	
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	static int[] distance = new int[100001];
	static int[] parent = new int[100001];// 이전 위치 찍기
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N ==K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		q.add(N);
		visited[N] = true;
		distance[N] = 0;
		parent[N] = N;
		bfs(N, K);
		System.out.println(distance[K]);
		int temp = K;
		stack.add(K);
		while (true) {

			stack.add(parent[temp]);

			temp = parent[temp];
			if (temp == N) {
				break;

			}
		}
		while (!stack.isEmpty()) {
			if (stack.size() != 1) {
				System.out.print(stack.pop() + " ");
			} else {
				System.out.println(stack.pop());
			}

		}

	}

	public static void bfs(int N, int K) {
		while (!q.isEmpty()) {
			int now = q.poll();

			int next = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 0)
					next = now + 1;
				if (i == 1)
					next = now - 1;
				if (i == 2)
					next = now * 2;

				if (next < 0 || next > 100000) {
					continue;
				}

				if (next == K) {
					distance[next] = distance[now] + 1;
					parent[next] = now; //다음 위치에 전위치가 어딘지 찍어주기
					return;
				}

				if (!visited[next]) {
					visited[next] = true;
					distance[next] = distance[now] + 1;

					parent[next] = now;//다음 위치에 전위치가 어딘지 찍어주기

					q.add(next);

				}
			}
		}
	}
}
