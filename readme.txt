= LicensePlateChecker =

The LicensePlateChecker is a simple program that checks if a license plate is valid according to a specification.
License plates in this program follow a simplified version of the German system and consist of three parts: 
a town code, a sequence of letters and a sequence of digits.

To be valid, the following conditions have to be fulfilled:
- the town code has to be a valid town code according to the specification
- the letter sequence has at least the minimum length specified
- the digit sequence has at least the minimum length specified
- the total length of all the parts of the license plate is exactly the total length specified

= Task = 

The goal is to implement the missing methods in MyLicensePlateChecker.
The LicensePlateCheckerTest helps you find out if your implementation does the right thing.
You are not allowed to change the API. 
