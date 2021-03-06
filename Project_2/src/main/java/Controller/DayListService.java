package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.t_expenseDAO;
import Model.t_expenseDTO;

@WebServlet("/DayListService")
public class DayListService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("listservice in");	
		
		t_expenseDAO dao = new t_expenseDAO();
		ArrayList<t_expenseDTO> list = dao.bringDayPrice();
		
		if (list != null) {
			request.setAttribute("list", list);
			System.out.println(list.get(0).getUser_id());
			System.out.println(list.get(0).getExp_category());
			System.out.println(list.get(0).getExp_price());
			System.out.println("listservice out");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ChartsDay.jsp");
		rd.forward(request, response);
	}

}
