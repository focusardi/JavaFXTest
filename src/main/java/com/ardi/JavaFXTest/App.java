package com.ardi.JavaFXTest;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        System.out.println( "main" );
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {

		System.out.println( "start" );
		
		
		stage.setTitle("My JavaFX Test");
		
		Scene scene;
		scene = new Scene(new Browser("http://tw.yahoo.com"),1024,768, Color.web("#666970"));
        stage.setScene(scene);		
		stage.show();
		//stage.setFullScreen(true);
	}
}


class Browser extends Region {
	 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public Browser(String url) {
    	//apply the styles
        getStyleClass().add("browser");
        // load the web page
        webEngine.load(url);
        //add the web view to the scene
        getChildren().add(browser);
    }
    
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}