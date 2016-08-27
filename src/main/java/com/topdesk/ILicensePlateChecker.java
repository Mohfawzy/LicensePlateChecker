package main.java.com.topdesk;

/**
 * A {@link ILicensePlateChecker} checks license plates for their validity
 * according to a {@link LicensePlateSpecification}.
 * 
 * @author annah
 *
 */
public interface ILicensePlateChecker {

	/**
	 * Set the current {@link LicensePlateSpecification} 
	 * 
	 * @param specification the {@code LicensePlateSpecification}
	 */
	void setSpecification(LicensePlateSpecification specification);
	
	/**
	 * Checks if a given {@link LicensePlate} is valid according to the currently set {@link LicensePlateSpecification}.
	 * <p>
	 * The {@code LicensePlate} is valid if the following holds:
	 * <ul>
	 * <li>The town code of the {@code LicensePlate} is in the list of valid town codes</li>
	 * <li>The letter sequence of the {@code LicensePlate} has at least the minimum length specified</li>
	 * <li>The digit sequence of the {@code LicensePlate} has at least the minimum length specified</li>
	 * <li>The total length of all parts of the {@code LicensePlate} is exactly the total length specified</li> 
	 * </ul>
	 * 
	 * @param licensePlate the {@code LicensePlate}
	 * @return true if the {@code LicensePlate} is valid, false otherwise
	 */
	boolean isValid(LicensePlate licensePlate);
	
}
