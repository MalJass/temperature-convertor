package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MyMain extends Application {


	@Override
	public void init() throws Exception {
		System.out.println("main");
		super.init();
	}

	@Override
	public void start(Stage primarystage) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(MyMain.class.getResource("app_layout.fxml"));
		VBox rootNode =fxmlLoader.load();

		Scene scene = new Scene(rootNode, 330, 350);

		MenuBar menuBar= createMenu();
		rootNode.getChildren().add(0 ,menuBar); // index zero priorities  menuBar (menuBar will be always at top)
		primarystage.setTitle("temperature converter tool ");
		primarystage.setScene(scene);
		primarystage.show();
	}
	private MenuBar createMenu(){

		//file menu
		Menu fileMenu = new Menu("file");

		MenuItem newItem =new MenuItem("new"); //file menu item1
		SeparatorMenuItem separator = new SeparatorMenuItem();//a separator line between 1&2
		MenuItem quitItem =new MenuItem("quit");//file menu item2

		newItem.setOnAction(actionEvent -> System.out.println("new item clicked"));
		quitItem.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newItem,separator,quitItem);

		//help menu

		Menu helpMenu = new Menu("help");

		MenuItem aboutItem =new MenuItem("about");//help menu item

		aboutItem.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().addAll(aboutItem);

		// menu bar
		MenuBar menuBar=new MenuBar();

		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
	public static void main(String[] args) {
		launch();
	}

	public  static void aboutApp(){
		// alert dialog
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("my first desktop app");
		alertDialog.setHeaderText("learning javaFx");
		alertDialog.setContentText("i am a beginner learning java");


		// customize button

		ButtonType yes =new ButtonType("yes");
		ButtonType no =new ButtonType("no");
		Optional<ButtonType> clicked = alertDialog.showAndWait();

		if (clicked.isPresent() && clicked.get() == yes){
			System.out.println("yes button clicked");
		}
		else {
			System.out.println("no button clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}