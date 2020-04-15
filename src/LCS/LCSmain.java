package LCS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LCSmain 
{

	public static void main(String[] args) 
	{
		Webscrape.extractData();
		//launch(args);
		
	}
	
	//public void start(Stage primaryStage) throws Exception
	//{
	//	primaryStage.setTitle("League of Legends Champ Statistics");
	//}
}
