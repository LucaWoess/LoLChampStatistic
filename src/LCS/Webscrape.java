package LCS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Webscrape 
{
	static String URL = "https://euw.leagueoflegends.com/de-de/champions/";
	public static void extractData() {
		
		Map<String, Map<String, Object>> champions = new HashMap<>(); 
		try
		{
			Document doc = Jsoup.connect(URL).get();
			for(Element c : doc.select("span.style__Text-sc-12h96bu-3.gPUACV")) {
				String Champ = c.text();
				champions.put(Champ, new HashMap<String, Object>());
				extractCategoryAndDifficulty(champions,Champ);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(champions);
	}

	private static void extractCategoryAndDifficulty(Map<String, Map<String, Object>> champions, String champ) {
		champ.replace("'", "-");
		if(champ.equals("Nunu & Willump")) { champ = "nunu";}
		champ = champ.toLowerCase();
		String Category = "";
		try {
			Category = Jsoup.connect(URL+champ).get().select("li.style__SpecsItem-sc-1o884zt-12.hwEUco> .ieHviE.style__SpecsItemValue-sc-1o884zt-15").text();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String Difficulty = "";
		try {
			Difficulty = Jsoup.connect(URL+champ).get().select("li.style__SpecsItem-sc-1o884zt-12.TZXkX> .ieHviE.style__SpecsItemValue-sc-1o884zt-15").text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		champions.get(champ).put(Category, Difficulty);
	}
}
