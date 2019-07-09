package menu;

import java.util.Scanner;

public class UI {

	public Scanner scan = new Scanner(System.in);

	public String readLine() {
		return scan.nextLine();
	}

	public int readInt() {
		String input = scan.nextLine();

		if (tryParseInt(input)) {
			return Integer.parseInt(input);
		} else {
			return -1;
		}
	}

	public boolean tryParseInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void badInput() {
		say("Invalid option");
	}

	public void say(String text) {
		System.out.println(text);
	}

	public void closeScanner() {
		scan.close();
	}

}