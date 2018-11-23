package servelet;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFormValidation {
	
	public List<String> validate(RegistrationForm registrationForm)
	{
		List<String> errors = new ArrayList<>();
		
		if(registrationForm.getName().length() < 3)
			errors.add("****Name entered is too short****");
		if(!registrationForm.getEmail().contains("@"))
			errors.add("****Email address is invalid*****");
		if(registrationForm.getCity().length() < 3)
			errors.add("*****city entered is too short*****");
		if(registrationForm.getUsername().length() < 3)
			errors.add("******UserName entered is too short*****");
		
		
		return errors;
	}

}
