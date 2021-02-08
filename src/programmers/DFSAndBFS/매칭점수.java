package programmers.DFSAndBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ¸ÅÄªÁ¡¼ö {

	public static void main(String[] args) {
		//String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		//String word = "blind";
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		String word = "Muzi";
		Solution sol = new Solution();
		int answer = sol.solution(word, pages);
		System.out.println("answer : " + answer);
	}
	
	static class Solution {
		
		public int solution(String word, String[] pages) {
	        Map<String, Double> basicScore = new HashMap<>();
	        Map<String, Double> linkScore = new HashMap<>();
	        List<String> urls = new ArrayList<>();
	        for (int i = 0; i < pages.length; i++) {
	        	Pattern compile;
	        	Matcher matcher;
				String html = pages[i];
				
				//site 
				compile = Pattern.compile("content=\"\\S+\"", Pattern.CASE_INSENSITIVE);
				matcher = compile.matcher(html.split("</head>")[0]);
				String url = matcher.find() ? matcher.group() : "";
				url = url.split("=")[1].replace("\"", "");
				urls.add(url);
				
				//word
				compile = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
				matcher = compile.matcher(html.replaceAll("[0-9]", " "));
				while(matcher.find()) {
					basicScore.put(url, basicScore.getOrDefault(url, 0.0) + 1);
				}
				basicScore.put(url, basicScore.getOrDefault(url, 0.0));
				
				//link
				List<String> links = new ArrayList<>();
				compile = Pattern.compile("href=\"\\S+\"", Pattern.CASE_INSENSITIVE);
				matcher = compile.matcher(html.split("<body>")[1]);
				while(matcher.find()) {
					String link = matcher.group();
					link = link.split("=")[1].replace("\"", "");
					links.add(link);
				}
				
				for (int j = 0; j < links.size(); j++) {
					String link = links.get(j);
					Double score = linkScore.getOrDefault(link, 0.0) + (double) basicScore.get(url) / links.size(); 
					linkScore.put(link, score);
				}				
			}
	        double max = Double.MIN_VALUE;
	        for (String url : basicScore.keySet()) {
				basicScore.computeIfPresent(url, (k, v)->v+=linkScore.getOrDefault(url, 0.0));
				max = Math.max(max, basicScore.get(url));
			}
	        
	        for (int i = 0; i < urls.size(); i++) {
				if(basicScore.get(urls.get(i)) == max) return i;
			}
	        return 0;
	    }
	}
}
