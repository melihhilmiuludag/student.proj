package tr.com.melihhilmiuludag.student.proj.utils.valid.annotations;

import org.primefaces.validate.bean.ClientConstraint;
import tr.com.melihhilmiuludag.student.proj.utils.valid.PhoneNumberClientValidationConstraint;
import tr.com.melihhilmiuludag.student.proj.utils.valid.PhoneNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author muludag on 4.05.2020
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy= PhoneNumberConstraintValidator.class)
@ClientConstraint(resolvedBy= PhoneNumberClientValidationConstraint.class)
@Documented
public @interface PhoneNumber {

	String message() default "{org.primefaces.examples.primefaces}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
