package tr.com.melihhilmiuludag.student.proj.utils.valid;

import tr.com.melihhilmiuludag.student.proj.utils.valid.annotations.Email;

/**
 * @author muludag on 4.05.2020
 */
public class EmailClientValidationConstraint extends AbstractClientValidationConstraint {

	public static final String MESSAGE_METADATA = "data-p-email-msg";

	public EmailClientValidationConstraint() {
		super(null, MESSAGE_METADATA);
	}

	public String getValidatorId() {
		return Email.class.getSimpleName();
	}

}
