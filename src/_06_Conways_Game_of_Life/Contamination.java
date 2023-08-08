package _06_Conways_Game_of_Life;

public class Contamination {
	public static void main(String[] args) {

		String map = "";
		// String map = "XXXXX";
		int[] inf = new int[map.length()];
		System.out.println("Before " + map);
		char[] cr;
		cr = map.toCharArray();
		String[] crs = new String[map.length()];

		for (int i = 0; i < map.length(); i++) {
			crs[i] = String.valueOf(cr[i]);
		}

		for (int j = 0; j < map.length(); j++) {
			if (crs[j].equals("0")) {
				inf[j] = 0;
			}
			if (crs[j].equals("1")) {
				inf[j] = 1;
			}
			if (crs[j].equals("X")) {
				inf[j] = 3;
			}

		}

//the part that infects people
		for (int i = 0; i < crs.length - 1; i++) {

			if (i > 0 && i < map.length()) {
				if (inf[i - 1] == 1 || inf[i + 1] == 1) {
					if (inf[i] != 3) {
						inf[i] = 1;

					}
				}
			}
		}

		if (crs.length>1 && inf[map.length() - 2] == 1 ) {
			inf[map.length() - 1] = 1;
		}
		for (int i = crs.length-2; i >= 0; i--) {

			if (i > 0 && i < map.length()) {
				if (inf[i - 1] == 1 || inf[i + 1] == 1) {
					if (inf[i] != 3) {
						inf[i] = 1;

					}
				}
			}
		}
		if ( crs.length>1 && inf[1] == 1 && inf[0]!=3 && crs.length>1) {
			inf[0] = 1;
		}

		// the output
		System.out.print("After  ");
		for (int i = 0; i < crs.length; i++) {
			System.out.print(inf[i]);
		}

		float total = 0;
		float infected = 0;
		for (int i = 0; i < crs.length; i++) {
			if (inf[i] != 3) {
				total++;
				if (inf[i] == 1) {
					infected++;
				}
			}
		}

		System.out.println("");
		float perc = 0;
		if (total != 0) {
			System.out.println(total + " " + infected);
			perc = (100 / total) * infected;
			System.out.println("percentage = " + perc);
		} else {
			System.out.println("percentage = 0, there is no population");
perc=0;
		}
		 //return perc;

	}

}
