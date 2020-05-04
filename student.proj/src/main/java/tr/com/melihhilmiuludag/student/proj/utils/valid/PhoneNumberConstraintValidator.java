package tr.com.melihhilmiuludag.student.proj.utils.valid;

import tr.com.melihhilmiuludag.student.proj.utils.valid.annotations.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author muludag on 4.05.2020
 */
public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber, String> {

	private Pattern pattern;

	private static final String PHONE_NUMBER_PATTERN = "^[+]?[0-9]+$";

	public void initialize(PhoneNumber a) {
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
	}

	public boolean isValid(String value, ConstraintValidatorContext cvc) {
		if(value == null)
			return true;
		else
			return pattern.matcher(value.toString()).matches();
	}

}
