package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16928 {
	/* 뱀과 사다리 게임 */
	static int result = 0;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[101];
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] distance = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i =0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		q.add(1);
		distance[1] = 0;
		visited[1] = true;
		bfs();
		System.out.println(distance[100]);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i =1;i<=6;i++) { //주사위로 갈수있는 경우
				int next = now + i;
				if(map.containsKey(next) && !visited[next] && !visited[map.get(next)]) {//뱀 사다리가 있는 곳이면
					visited[next] = true;
					visited[map.get(next)] = true;// 다음간곳 방문체크
					q.add(map.get(next));
					distance[map.get(next)] = distance[now] + 1;
					if(map.get(next)==100) {
						return;
					}
				}else if(!map.containsKey(next) && next <= 100 && !visited[next]) {
					visited[next] = true;
					q.add(next);
					distance[next] = distance[now] + 1;
					if(next==100) {
						return;
					}
				}
				
			}
		}
	}
}
