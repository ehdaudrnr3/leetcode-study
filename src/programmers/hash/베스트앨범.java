package programmers.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class º£½ºÆ®¾Ù¹ü {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop", "classic"};
		int[] plays = {500, 600, 150, 800, 2500, 500};
		Solution.solution(genres, plays);
	}
	static class Solution {
	    public static int[] solution(String[] genres, int[] plays) {
	        int len = genres.length;

	        Map<String, Integer> rank = new TreeMap<>((a,b)->b.compareTo(a));
	        Map<String, Queue<Album>> m = new HashMap<>();
	        Queue<Rank> rankQ = new PriorityQueue<>((a, b)->b.total - a.total);
	        for(int i = 0; i < len; i++) {
	            String genre = genres[i];
	            Queue q = m.getOrDefault(genre, new PriorityQueue<>(Comparator
	            		.comparing(Album::getPlays)
	            		.reversed()
	            		.thenComparing(Album::getId)));
	            q.offer(new Album(i, plays[i]));
	            m.put(genre, q);
	            
	            rank.put(genre, rank.getOrDefault(genre, 0) + plays[i]);
	        }
	        
	        for (String genre : rank.keySet()) {
	        	rankQ.add(new Rank(genre, rank.get(genre)));
	        }
	        List<Integer> rs = new ArrayList<>();
	        while(!rankQ.isEmpty()) {
	        	Rank item = rankQ.poll();
	        	String genre = item.genre;
	        	if(m.get(genre).size() > 1) {
	        		for (int i = 0; i < 2; i++) {
	        			Album poll = m.get(genre).poll();
	        			rs.add(poll.id);
					}
	        	} else {
	        		rs.add(m.get(genre).poll().id);
	        	}
			}
	        
	        return rs.stream().mapToInt(i->i).toArray();
	    }
	    static class Rank {
	    	String genre;
	    	int total;
			public Rank(String genre, int total) {
				super();
				this.genre = genre;
				this.total = total;
			}
	    }
	    static class Album {
	        int id;
	        int plays;
	        
	        public Album(int id, int plays) {
	            this.id = id;
	            this.plays = plays;
	        }

			public int getId() {
				return id;
			}


			public int getPlays() {
				return plays;
			}
	    }
	}
}
