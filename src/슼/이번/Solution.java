package 슼.이번;

import java.util.Arrays;

/*
 * 구현 (X)
 *
 * 시계방향 - 반시계방향 -> 사각형 대각선으로 반전시키기
 * 백준 1913 달팽이
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//5	true	[[1,2,3,4,1],[4,5,6,5,2],[3,6,7,6,3],[2,5,6,5,4],[1,4,3,2,1]]
		//6	false	[[1,5,4,3,2,1],[2,6,8,7,6,5],[3,7,9,9,8,4],[4,8,9,9,7,3],[5,6,7,8,6,2],[1,2,3,4,5,1]]
		//9	false	[[1,8,7,6,5,4,3,2,1],[2,9,14,13,12,11,10,9,8],[3,10,15,18,17,16,15,14,7],[4,11,16,19,20,19,18,13,6],[5,12,17,20,21,20,17,12,5],[6,13,18,19,20,19,16,11,4],[7,14,15,16,17,18,15,10,3],[8,9,10,11,12,13,14,9,2],[1,2,3,4,5,6,7,8,1]]
		System.out.println(Arrays.deepToString(solution.solution(5, true)));
		System.out.println(Arrays.deepToString(solution.solution(6, false)));
		System.out.println(Arrays.deepToString(solution.solution(9, false)));
	}

	public int[][] solution(int n, boolean clockwise) {
		int[][] map = new int[n][n];

		// 동남서북
		int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		Snail[] snails = new Snail[]{
			new Snail(0, 0, 0),
			new Snail(0, n - 1, 1),
			new Snail(n - 1, n - 1, 2),
			new Snail(n - 1, 0, 3)
		};

		while (true) {
			boolean flag = false;
			for (Snail snail : snails) {
				map[snail.getX()][snail.getY()] = snail.getNum();
				flag |= snail.move(n, move, map);
			}

			if (!flag) {
				break;
			}
		}

		if (!clockwise) {
			int[][] antiMap = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					antiMap[i][j] = map[j][i];
				}
			}
			return antiMap;
		}

		return map;
	}

	static class Snail {

		private int num;
		private int x;
		private int y;
		private int dir;

		public Snail(int x, int y, int dir) {
			this.num = 1;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public int getNum() {
			return num;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		boolean move(int size, int[][] move, int[][] map) {
			// 이동할 수 있으면 이동, 흔적 남기고 true return
			// 없으면 false return
			int nx = this.x + move[dir][0];
			int ny = this.y + move[dir][1];

			if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx][ny] != 0) {
				dir = (dir + 1) % 4;
			}

			nx = this.x + move[dir][0];
			ny = this.y + move[dir][1];

			if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx][ny] != 0) {
				return false;
			}

			x = nx;
			y = ny;
			map[x][y] = num;
			num += 1;

			return true;
		}
	}
}
