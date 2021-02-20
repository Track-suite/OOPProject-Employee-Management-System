package ems.attendanceStatus.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.attendanceStatus.service.AttendanceStatusService;
import ems.attendanceStatus.service.AttendanceStatusServiceImpt;

/**  @author Akeel M.N.M
	IT NO:IT19153414
**/

/**
 * Servlet implementation class UpdateAttendanceStatusServlet
 */
@WebServlet("/UpdateAttendanceStatusServlet")
public class UpdateAttendanceStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendanceStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String emp = request.getParameter("empID");
		
			/** ------------ Resetting AttendanceStatus Table WorkingDays and LeaveDays of Employees in End of Month --------------**/
			
			AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
			attendanceStatusService.resetAttendanceStatusWorkingandLeaveDays();
			
			request.setAttribute("employee", emp);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees AttendanceStatus.jsp");
			dispatcher.forward(request, response);
	}

}
