package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p12851 {
	/*
	 * 숨바꼭질 2 g4 BFS인데 최소 비용으로 도달하는 경우가 몇개인지 구하는거 그래서 제일 빠른 경로를 찾아도 계속 찾아야함
	 * vistied배열이 필요가 없고 q에 넣을지 말지를 distance로 판단해서 넣어야함
	 * 
	 * tip : next 포인트를 for 문안에서 선언만하기
	 */

	static Queue<Integer> q = new LinkedList<>();
	static int[] distance = new int[100001];
	static int minValue = Integer.MAX_VALUE;
	static int next;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		q.add(N);
		distance[N] = 1;
		if (N > K) {
			System.out.println(N - K);
			System.out.println(1);
			return;
		} else if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		bfs(N, K);

		System.out.println(minValue);
		System.out.println(count);

	}

	public static void bfs(int N, int K) {
		while (!q.isEmpty()) {
			int now = q.poll();

			if (minValue < distance[now]) { // 1. 지금 현재 기록중 제일 빠른 거보다 느리면 아에 보지도 않음
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int next; // next 변수를 선언부터 하고

				if (i == 0) {
					next = now * 2;
				} else if (i == 1) {
					next = now + 1;
				} else {
					next = now - 1;
				}

				if (next < 0 || next > 100000) {// 2. 범위를 넘어가는 경우
					continue;
				}

				if (next == K) {// 목표지점 도착하게되면
					minValue = distance[now];
					count++;
				}

				if (distance[next] == 0 || distance[next] == distance[now] + 1) {
					//방문을 하지 않았던 포인트 or 현재 거리+1 이 다음 가는 포인트의 비용 이랑 같으면 계속
					// 봐야하니까 q 에 넣어줌 그리고 비용 1 증가
					q.add(next);
					distance[next] = distance[now] + 1;
				}
			}

		}
	}
}
