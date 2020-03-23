import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// DECLARATIE VARIABELEN
		String alfabet_Latijns = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i, k, index, aantal_conversies;
		String letter_Latijns, letter_braille;
		String inputLine_1, inputLine_2, inputLine_3;
		String s2 = "";
		HashMap<String, String> alfabet = new HashMap<String, String>(); // formaat [x.....=A]
		List<String> output = new ArrayList<String>(); // [output1, output2 ,...]

		// INLEZEN VAN HET BRAILLE-ALFABET
		inputLine_1 = sc.nextLine();
		inputLine_2 = sc.nextLine();
		inputLine_3 = sc.nextLine();

		// MAPPING BRAILLE-ALFABET MET LATIJNS-ALFABET
		for (i = 0; i < 26; i++) {
			index = i * 2; // i itereert over latijns, index over braille (x2 zo lange string)
			// read in latijnse letter
			letter_Latijns = Character.toString(alfabet_Latijns.charAt(i));
			// read in braille letter
			letter_braille = Character.toString(inputLine_1.charAt(index));
			letter_braille += Character.toString(inputLine_1.charAt(index + 1));
			letter_braille += Character.toString(inputLine_2.charAt(index));
			letter_braille += Character.toString(inputLine_2.charAt(index + 1));
			letter_braille += Character.toString(inputLine_3.charAt(index));
			letter_braille += Character.toString(inputLine_3.charAt(index + 1));
			// put in HashMap
			alfabet.put(letter_braille, letter_Latijns);
		}

		aantal_conversies = Integer.parseInt(sc.nextLine()); // AANTAL CONVERSIES
		// OMZETTEN
		for (k = 0; k < aantal_conversies; k++) {
			inputLine_1 = sc.nextLine();
			inputLine_2 = sc.nextLine();
			inputLine_3 = sc.nextLine();
			s2 = "";
			for (i = 0; i < inputLine_1.length(); i++) {
				letter_braille = Character.toString(inputLine_1.charAt(i));
				letter_braille += Character.toString(inputLine_1.charAt(i + 1));
				letter_braille += Character.toString(inputLine_2.charAt(i));
				letter_braille += Character.toString(inputLine_2.charAt(i + 1));
				letter_braille += Character.toString(inputLine_3.charAt(i));
				letter_braille += Character.toString(inputLine_3.charAt(i + 1));
				s2 += alfabet.get(letter_braille);// zzoek latijns in hashmap
				i++;// i moet met 2 opgehoogd worden (1x bovenaan for-lus, 1x in for-lus)
			}
			output.add(k + 1 + " " + s2);// voeg output toe aan lijst
		}
		// PRINT OUTPUT-LIJST
		for (String s3 : output) {
			System.out.println(s3);
		}
		sc.close();
	}
}