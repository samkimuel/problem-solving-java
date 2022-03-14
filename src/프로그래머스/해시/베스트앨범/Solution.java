package 프로그래머스.해시.베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
		System.out.println(
			Arrays.toString(solution.solution(
				new String[]{"classic", "pop", "classic", "classic", "pop"},
				new int[]{500, 600, 150, 800, 2500}
			))
		);
	}

	public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Song>> songs = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (songs.get(genres[i]) == null) {
				songs.put(genres[i], new ArrayList<>());
			}

			songs.get(genres[i]).add(new Song(i, plays[i]));
		}

		List<Album> albums = new ArrayList<>();
		for (String key : songs.keySet()) {
			albums.add(new Album(key, songs.get(key)));
		}

		albums.sort(Comparator.comparing(Album::getTotalPlay).reversed());

		List<Song> result = new ArrayList<>();
		for (Album album : albums) {
			result.addAll(album.getTopTwo());
		}

		int[] bestAlbum = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			bestAlbum[i] = result.get(i).getNumber();
		}

		return bestAlbum;
	}
}

class Album {

	private String genre;
	private List<Song> songs;

	public Album(String genre, List<Song> songs) {
		this.genre = genre;
		this.songs = songs;
	}

	public boolean add(Song song) {
		return songs.add(song);
	}

	public int getTotalPlay() {
		return songs.stream()
			.mapToInt(Song::getPlay)
			.reduce(Integer::sum)
			.getAsInt();
	}

	public List<Song> getTopTwo() {
		return songs.stream()
			.sorted(Comparator.comparing(Song::getPlay).reversed())
			.limit(2)
			.collect(Collectors.toList());
	}
}

class Song {

	private int number;
	private int play;

	public Song(int number, int play) {
		this.number = number;
		this.play = play;
	}

	public int getNumber() {
		return this.number;
	}

	public int getPlay() {
		return this.play;
	}
}
