package tr.com.melihhilmiuludag.student.proj.utils.valid;

import org.primefaces.validate.ClientValidator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author muludag on 4.05.2020
 */
@FacesValidator("custom.phoneNumberValidator")
@ManagedBean
@Named
public class PhoneNumberValidator implements Validator, ClientValidator {

	private Pattern pattern;

	private static final String PHONE_NUMBER_PATTERN = "^[+]?[0-9]+$";


	public PhoneNumberValidator() {
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
	}

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}

		if(!pattern.matcher(value.toString()).matches()) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
					value + " is not a valid phone number;"));
		}
	}

	public Map<String, Object> getMetadata() {
		return null;
	}

	public String getValidatorId() {
		return "custom.phoneNumberValidator";
	}

}
