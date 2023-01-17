package GUI;

import Application.Controller.Controller;
import Storage.Storage;
import javafx.application.Application;

public class App {

	public static void main(String[] args) {
		Controller.initStorage();

		System.out.println(Controller.holdUdenTutorer());

		System.out.println(Storage.getUddannelser().get(0).tutorOversigt());

		Controller.tutorOversigtTilFil("test");

		Application.launch(StartWindow.class);
	}
}
