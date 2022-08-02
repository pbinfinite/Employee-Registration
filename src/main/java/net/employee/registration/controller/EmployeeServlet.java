package net.employee.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.employee.registration.dao.EmployeeDao;
import net.employee.registration.model.*;

import java.io.IOException;


@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();
       
    
    public EmployeeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dp = (RequestDispatcher) request.getRequestDispatcher("views/employeeregister.jsp");
		dp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		Employee employee = new Employee();
		Login login=new Login();
		userDetails det=new userDetails();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		login.setUsername(username);
		login.setPassword(password);
		det.setAddress(address);
		det.setContact(contact);
		
		try {
			employeeDao.registerEmployee(employee,login,det);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dp = (RequestDispatcher) request.getRequestDispatcher("views/employeedetails.jsp");
		dp.forward(request, response);
	}

}
