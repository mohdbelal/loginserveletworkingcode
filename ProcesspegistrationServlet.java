package servelet;


import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesspegistrationServlet
 */
@WebServlet("/processRegistration")
public class ProcesspegistrationServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//STEP1-- collect form data
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		String pincode=request.getParameter("pincode");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String captchaInput=request.getParameter("captchaInput");
		
		//step 2 --copy/collext store data in object
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setName(name);
		registrationForm.setEmail(email);
		registrationForm.setCity(city);
		registrationForm.setPincode(Integer.parseInt(pincode));
		registrationForm.setUsername(username);
		registrationForm.setPassword(password);
		registrationForm.setConfirmPassword(confirmPassword);
		registrationForm.setCaptchaInput(captchaInput);
		
		//Step 3. Store form data in the user session
				HttpSession session = request.getSession();
				session.setAttribute("formData", registrationForm);
				
				//Step 4. Validation
				RegistrationFormValidation validation = new RegistrationFormValidation();
				List<String> errors = validation.validate(registrationForm);

				if(!errors.isEmpty()) {
					session.setAttribute("errors", errors);
					response.sendRedirect("Register.jsp");
				}
				else {
					response.sendRedirect("confirmation.jsp");
				}
	}

}
