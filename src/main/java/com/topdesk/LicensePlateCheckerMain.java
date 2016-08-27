package main.java.com.topdesk;

import java.util.Arrays;
import java.util.Scanner;

public class LicensePlateCheckerMain {

	private static final LicensePlateSpecification SPECIFICATION = new LicensePlateSpecification(Arrays.asList("KL", "SB", "F", "KO", "MN"), 2, 2, 7);
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter town:");
			String town = scanner.next();
			System.out.println("Enter letter sequence:");
			String letters = scanner.next();
			System.out.println("Enter digit sequence:");
			String digits = scanner.next();
			LicensePlate licensePlate = new LicensePlate(town, letters, digits);
			
			MyLicensePlateChecker checker = new MyLicensePlateChecker();
			
			checker.setSpecification(SPECIFICATION);
			
			boolean valid = checker.isValid(licensePlate);
			
			System.out.println("\n'" + licensePlate + "' is " + (valid ? "valid" : "not valid"));
		}
	}
}
