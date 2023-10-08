package uz.nazarovctrl.bandla.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.nazarovctrl.bandla.annotations.validation.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    @Override
    public boolean isValid(String phoneNumberField, ConstraintValidatorContext context) {
        Phonenumber.PhoneNumber phoneNumber;
        try {
            phoneNumber = PhoneNumberUtil.getInstance()
                    .parse(phoneNumberField, Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        } catch (NumberParseException e) {
            return false;
        }
        return phoneNumberUtil.isValidNumberForRegion(phoneNumber, "UZ");
    }
}