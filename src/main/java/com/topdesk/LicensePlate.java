package main.java.com.topdesk;

/**
 * A {@link LicensePlate} consists of three parts:
 * <ul>
 * <li>A town code</li>
 * <li>A sequence of letters</li>
 * <li>A sequence of digits</li>
 * </ul>
 * 
 * @author annah
 *
 */
public class LicensePlate {

	private final String townCode;
	private final String letterSequence;
	private final String digitSequence;
	
	public LicensePlate(String townCode, String letterSequence, String digitSequence) {
		this.townCode = townCode;
		this.letterSequence = letterSequence;
		this.digitSequence = digitSequence;
	}

	public String getTownCode() {
		return townCode;
	}

	public String getLetterSequence() {
		return letterSequence;
	}

	public String getDigitSequence() {
		return digitSequence;
	}

	@Override
	public String toString() {
		return townCode + "-" + letterSequence + " " + digitSequence;
	}
	
}
