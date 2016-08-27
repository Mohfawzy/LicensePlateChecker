package main.java.com.topdesk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link LicensePlateSpecification} defines how a valid {@link LicensePlate} should look like.
 * 
 * @author annah
 *
 */
public class LicensePlateSpecification {
	
	private final int minNumLetters;
	private final int minNumDigits;
	private final List<String> validTownCodes;
	private final int totalLength;

	/**
	 * Create a new {@link LicensePlateSpecification}
	 * 
	 * @param validTownCodes the list of town codes allowed for the {@code LicensePlate}
	 * @param minNumLetters the minimal length the the letter sequence of the {@code LicensePlate}
	 * @param minNumDigits the minimal length of the digit sequence of the {@code LicensePlate}
	 * @param totalLength the total length of all parts of the {@code LicensePlate}
	 */
	public LicensePlateSpecification(List<String> validTownCodes, int minNumLetters, int minNumDigits, int totalLength) {
		this.validTownCodes = Collections.unmodifiableList(new ArrayList<>(validTownCodes));
		this.minNumLetters = minNumLetters;
		this.minNumDigits = minNumDigits;
		this.totalLength = totalLength;
	}
	
	public List<String> getValidTownCodes() {
		return validTownCodes;
	}
	
	public int getMinNumLetters() {
		return minNumLetters;
	}
	
	public int getMinNumDigits() {
		return minNumDigits;
	}
	
	public int getTotalLength() {
		return totalLength;
	}
	
}
