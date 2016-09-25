import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pancakes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("B-small.in"));
			PrintWriter printWriter = new PrintWriter(new File("B-small.out"));
			int testCases = sc.nextInt();
			for (int t = 0; t < testCases; t++) {
				int dishes = sc.nextInt();
				int[] pans = new int[dishes];
				for (int i = 0; i < dishes; i++) {
					pans[i] = sc.nextInt();
				}
				int currentMax = 0;
				int minutes = 0;
				while (true) {
					int max = getMaxIndex(pans);
					if (pans[max] <= 3) {
						currentMax = currentMax < pans[max] ? pans[max] : currentMax;
						break;
					}
					if (pans[max] == 4) {
						pans[max] -= 2;
					} else {
						pans[max] -= 3;
						currentMax = 3;
					}
					minutes++;
				}
				printWriter.println("Case #" + (t + 1) + ": " + (minutes + currentMax));
			}
			sc.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int getMaxIndex(int[] pans) {
		int maxIndex = 0;
		for (int i = 1; i < pans.length; i++) {
			int newnumber = pans[i];
			if ((newnumber > pans[maxIndex])) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
