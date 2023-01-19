package etc;

import java.util.LinkedList;
import java.util.Queue;

public class p42583 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;// 넣을 조건 다리가 비어있거나 다리무게가
		Queue<Integer> bridge = new LinkedList<>();
		int truckweight = 0;// 초기무게
		bridge.add(truck_weights[0]);// 첫번째 넣기
		truckweight = truckweight + truck_weights[0];
		answer++;
		for (int i = 1; i < truck_weights.length; i++) {

			int truck = truck_weights[i];
			
			boolean flag = false;
			// 들어갈수있을때
			if (((weight - truckweight) >= truck) && bridge_length > bridge.size()) {// 넣기 무게, 길이
				bridge.add(truck);
				truckweight = truckweight + truck;
				flag = true;//다음
			}
			answer++;
			if (answer % (bridge_length + 1) == 0) {// 빼기
				int polltruck = bridge.poll();
				truckweight = truckweight - polltruck;
				if (((weight - truckweight) >= truck) && bridge_length > bridge.size()) {
					bridge.add(truck);
					truckweight = truckweight + truck;
					flag = true;
				}
			}
			
			if(!flag ) {
				i--;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] truck_weights = new int[] { 7, 4, 5, 6 };
		System.out.println(solution(2, 10, truck_weights));

		int[] truck_weights2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		System.out.println(solution(100, 100, truck_weights2));

	}

}