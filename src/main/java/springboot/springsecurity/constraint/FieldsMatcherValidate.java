package springboot.springsecurity.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldsMatcherValidate implements ConstraintValidator<FieldsMatcher, Object> {

	private String secondField;
    private String firstField;
    

    @Override
    public void initialize(final FieldsMatcher constraintAnnotation) {
        firstField = constraintAnnotation.first();
        secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final Object firstObj = BeanUtils.getProperty(value, firstField);
            final Object secondObj = BeanUtils.getProperty(value, secondField);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}
        return true;
    }
}