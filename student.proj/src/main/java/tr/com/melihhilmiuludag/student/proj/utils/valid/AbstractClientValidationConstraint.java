package tr.com.melihhilmiuludag.student.proj.utils.valid;

/**
 * @author muludag on 4.05.2020
 */


import org.primefaces.validate.bean.ClientValidationConstraint;

import javax.validation.metadata.ConstraintDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractClientValidationConstraint implements ClientValidationConstraint {

	public static final String CONSTRAINT_PACKAGE = "javax.validation.constraints";

	private final String messageId;
	private final String messageMetadata;

	public AbstractClientValidationConstraint(String messageId, String messageMetadata) {
		this.messageId = messageId;
		this.messageMetadata = messageMetadata;
	}

	@Override
	public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor) {
		Map<String, Object> metadata = new HashMap<>();
		Map<String, Object> attrs = constraintDescriptor.getAttributes();
		Object message = attrs.get(ATTR_MESSAGE);

		processMetadata(metadata, attrs);

		if (!Objects.equals(message, messageId)) {
			metadata.put(messageMetadata, message);
		}

		return metadata;
	}

	protected void processMetadata(Map<String, Object> metadata, Map<String, Object> attrs) {
		// NOOP
	}
}
