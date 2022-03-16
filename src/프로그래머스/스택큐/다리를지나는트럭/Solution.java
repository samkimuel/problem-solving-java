package 프로그래머스.스택큐.다리를지나는트럭;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//2	10	[7,4,5,6]	8
		//100	100	[10]	101
		//100	100	[10,10,10,10,10,10,10,10,10,10]	110
		System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6}));
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Truck> bridgeQ = new LinkedList<>();
		Queue<Truck> waitQ = Arrays.stream(truck_weights)
			.mapToObj(Truck::new)
			.collect(Collectors.toCollection(LinkedList::new));

		int time = 0;
		int weightOnBridge = 0;
		while (!bridgeQ.isEmpty() || !waitQ.isEmpty()) {
			time++;
			bridgeQ.forEach(Truck::move);

			if (!bridgeQ.isEmpty()) {
				Truck truck = bridgeQ.peek();
				if (truck.getTimeOnBridge() > bridge_length) {
					bridgeQ.poll();
					weightOnBridge -= truck.getWeight();
				}
			}

			if (!waitQ.isEmpty()) {
				Truck truck = waitQ.peek();
				if (truck.getWeight() + weightOnBridge <= weight && bridgeQ.size() < bridge_length) {
					bridgeQ.offer(waitQ.poll());
					weightOnBridge += truck.getWeight();
				}
			}
		}

		return time;
	}
}

class Truck {

	private int weight;
	private int timeOnBridge;

	public Truck(int weight) {
		this.weight = weight;
		this.timeOnBridge = 1;
	}

	public int getWeight() {
		return weight;
	}

	public int getTimeOnBridge() {
		return timeOnBridge;
	}

	public void move() {
		timeOnBridge += 1;
	}
}
