import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dijkstra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C-small.in"));
			PrintWriter printWriter = new PrintWriter(new File("C-small.out"));
			int testCases = sc.nextInt();
			for (int t = 0; t < testCases; t++) {
				sc.nextInt();
				int x = sc.nextInt();
				String shortQu = sc.next();
				StringBuilder qu = new StringBuilder(shortQu);
				for (int i = 0; i < x - 1; i++) {
					qu.append(shortQu);
				}
				String answer = null;
				if (qu.length() < 3) {
					answer = "NO";
				} else if (qu.length() == 3) {
					answer = qu.toString().equalsIgnoreCase("ijk") ? "YES" : "NO";
				} else {
					char ijk = qu.charAt(0);
					boolean iFound = false, jFound = false, kFound = false;
					for (int i = 0; i < qu.length(); i++) {
						if (!iFound) {
							iFound = ijk == 'i';
							if (iFound && i + 1 < qu.length()) {
								ijk = qu.charAt(i + 1);
								continue;
							}
						} else if (!jFound) {
							jFound = ijk == 'j';
							if (jFound && i + 1 < qu.length()) {
								ijk = qu.charAt(i + 1);
								continue;
							}
						} else {
							kFound = ijk == 'k';
						}
						if (i + 1 < qu.length()) {
							ijk = multy(ijk, qu.charAt(i + 1));
						}
					}
					if (iFound && jFound && kFound) {
						answer = "YES";
					} else {
						answer = "NO";
					}
				}
				printWriter.println("Case #" + (t + 1) + ": " + answer);
			}
			sc.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static char multy(char first, char second) {
		if (first == second) {
			return '1';
		}
		if (first == '1') {
			return second;
		} else if (second == '1') {
			return first;
		} else if (first == 'i' && second == 'j' || first == 'j' && second == 'i') {
			return 'k';
		} else if (first == 'i' && second == 'k' || first == 'k' && second == 'i') {
			return 'j';
		} else {
			return 'i';
		}
	}
}
