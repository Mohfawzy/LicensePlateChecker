package main.java.com.topdesk;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyLicensePlateChecker implements ILicensePlateChecker {

	LicensePlateSpecification licensePlateSpecification;

	@Override
	public void setSpecification(LicensePlateSpecification specification) {
		// TODO: implement
		if (specification != null && specification.getValidTownCodes() != null) {
			licensePlateSpecification = new LicensePlateSpecification(specification.getValidTownCodes(),
					specification.getMinNumLetters(), specification.getMinNumDigits(), specification.getTotalLength());
		}
	}

	@Override
	public boolean isValid(LicensePlate licensePlate) {
		// TODO: implement
		// First check the Specification is created and all the elements in the
		// LicensePlate aren't null
		if (licensePlateSpecification == null || licensePlate == null || licensePlate.getDigitSequence() == null
				|| licensePlate.getLetterSequence() == null || licensePlate.getTownCode() == null) {
			return false;
		}

		// Get the list of the cities and check if the user input one of them
		List<String> validTownCodes = licensePlateSpecification.getValidTownCodes();
		if (!validTownCodes.contains(licensePlate.getTownCode())) {
			return false;
		}

		// Create String builder to create dynamic regex expression
		StringBuilder regexExpression = new StringBuilder();
		regexExpression.append("\\d{");
		regexExpression.append(licensePlateSpecification.getMinNumLetters());
		regexExpression.append(",}");

		// Create a Pattern object
		Pattern pattern = Pattern.compile(regexExpression.toString());

		// Create matcher object.
		Matcher matcher = pattern.matcher(licensePlate.getDigitSequence());
		if (!matcher.matches()) {
			return false;
		}
		// Create the old regex expression to create new one for the letters
		regexExpression.setLength(0);
		regexExpression.append("\\p{Alpha}{");
		regexExpression.append(licensePlateSpecification.getMinNumLetters());
		regexExpression.append(",}");
		pattern = Pattern.compile(regexExpression.toString());
		matcher = pattern.matcher(licensePlate.getLetterSequence());
		if (!matcher.matches()) {
			return false;
		}

		regexExpression.setLength(0);
		regexExpression.append("\\w{");
		regexExpression.append(licensePlateSpecification.getTotalLength());
		regexExpression.append("}\\b");
		pattern = Pattern.compile(regexExpression.toString());
		// create a string builder to check the length of the plate
		// Other solution could be call the toString method in the LicensePlate
		// Class and trim and remove the '-'
		StringBuilder licensePlateText = new StringBuilder();
		licensePlateText.append(licensePlate.getTownCode());
		licensePlateText.append(licensePlate.getLetterSequence());
		licensePlateText.append(licensePlate.getDigitSequence());
		matcher = pattern.matcher(licensePlateText.toString());
		if (!matcher.matches()) {
			return false;
		}

		// if all of the checks are passed then the plate is correct and return true
		return true;
	}
}
