package storeregistrationdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import registrationdao.RegistrationDao;
import servelet.RegistrationForm;

/**
 * Servlet implementation class Storeregistrationdetail
 */
@WebServlet("/Storeregistrationdetail")
public class Storeregistrationdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Storeregistrationdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		RegistrationForm form =(RegistrationForm) session.getAttribute("formData");
		
		RegistrationDao dao= new RegistrationDao();
		try {
			dao.insert(form);
			response.sendRedirect("thankyou.jsp");
		}
		catch(DataAccessException e) {
			//log the exception
			e.printStackTrace();
			response.sendRedirect("Register.jsp");
		}
	}



	}

