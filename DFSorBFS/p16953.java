package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class p16953 {
	/* A -> B s2 
	 * 
	 * 메모리 초과 
	 * 원인 : 입력값이 최대 10의 9승 이어서 int 는 불가했고 long으로 해야한다
	 * 실수 : 배열은 [] 안에 int 가 들어가서 long으로 distance 불가능했다
	 * 		  리스트 역시 long타입으로 설정해도 set(int, long) 이어서 인덱스가 불가능했다
	 * 		  방문 배열역시 불가능했다
	 * 해결 : map 으로 <Long, Long> 으로 key 는 위치, value 는 거리 값으로 사용해서 distance 구했음
	 * 	      set 으로 방문 배열을 대신하였다. contains() 함수 사용
	 * 	  	  if에 들어가기전에 계산해서 할당하면 long 타입도 오버 될수 있다. 주의..
	 * */
	static Queue<Long> q = new LinkedList<>();
	static Set<Long> set = new HashSet<>();
	static Map<Long, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		set.add(A);
		q.add(A);
		map.put(A, 1);
		bfs(A, B);
		System.out.println(map.get(B));
	}

	static public void bfs(long A, long B) {
		while (!q.isEmpty()) {
			long temp = q.poll();
	
			for (int i = 0; i < 2; i++) {// 두 가지 방법(더하거나 곱하거나)
				if (i == 0) {// 곱셈
					if (temp * 2 < B && !set.contains(temp * 2)) {		
						set.add(temp * 2);
						map.put(temp * 2, map.get(temp) + 1);
						q.add(temp * 2);
					} else if (temp * 2 == B) {
						map.put(B, map.get(temp) + 1);
						return;
					}
				} else {// 더하기
					String s = Long.toString(temp) + "1";
					if (Long.parseLong(s) < B && !set.contains(Long.parseLong(s))) {
						set.add(Long.parseLong(s));
						map.put(Long.parseLong(s), map.get(temp) + 1);
						q.add(Long.parseLong(s));
					} else if (Long.parseLong(s) == B) {
						map.put(B, map.get(temp) + 1);
						return;
					}
				}
			}
		}
		map.put(B, -1); //return 못하고 나온것 = 즉 B에 못 도달하는 경우
	}
}
