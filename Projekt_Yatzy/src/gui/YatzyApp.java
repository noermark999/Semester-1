package gui;

import javafx.application.Application;
import model.Yatzy;

import java.util.Arrays;

public class YatzyApp {

	public static void main(String[] args) {
		Yatzy test = new Yatzy();
		int[] values = {3, 3, 3, 3, 3};
		test.setValues(values);
		System.out.println(Arrays.toString(test.getValues()));
		System.out.println(Arrays.toString(test.calcCounts()));
		System.out.println(test.sameValuePoints(6));
		System.out.println(test.onePairPoints());
		System.out.println(test.twoPairPoints());
		System.out.println(test.fullHousePoints());
		//Application.launch(YatzyGui.class);
	}
}
