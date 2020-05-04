package tr.com.melihhilmiuludag.student.proj.utils.valid;

import tr.com.melihhilmiuludag.student.proj.utils.valid.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author muludag on 4.05.2020
 */
public class EmailConstraintValidator implements ConstraintValidator<Email, String> {

	private Pattern pattern;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public void initialize(Email a) {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean isValid(String value, ConstraintValidatorContext cvc) {
		if(value == null)
			return true;
		else
			return pattern.matcher(value.toString()).matches();
	}

}
