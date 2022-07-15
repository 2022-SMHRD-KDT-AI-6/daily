package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MonthDateDAO;
import Model.t_expenseDAO;
import Model.t_expenseDTO;


@WebServlet("/MonthListService")
public class MonthListService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MonthDateDAO dao = new MonthDateDAO();

		//1¿ù
		ArrayList<t_expenseDTO> list1 = dao.jan();
				
		int sum1 = 0;
				
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getExp_price());
			sum1 += list1.get(i).getExp_price();
			}
			System.out.println("1ÃÑ ÇÕ" + sum1);
			request.setAttribute("sum1", sum1);		
		
		
		//2¿ù
		ArrayList<t_expenseDTO> list2 = dao.feb();
				
		int sum2 = 0;
				
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).getExp_price());
			sum2 += list2.get(i).getExp_price();
			}
			System.out.println("2ÃÑ ÇÕ" + sum2);
			request.setAttribute("sum2", sum2);		
		

		//3¿ù
		ArrayList<t_expenseDTO> list3 = dao.mar();
				
		int sum3 = 0;
				
		for(int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i).getExp_price());
			sum3 += list3.get(i).getExp_price();
			}
			System.out.println("3ÃÑ ÇÕ" + sum3);
			request.setAttribute("sum3", sum3);		
		
		//4¿ù
		ArrayList<t_expenseDTO> list4 = dao.apr();
				
		int sum4 = 0;
				
		for(int i = 0; i < list4.size(); i++) {
			System.out.println(list4.get(i).getExp_price());
			sum4 += list4.get(i).getExp_price();
			}
			System.out.println("4ÃÑ ÇÕ" + sum4);
			request.setAttribute("sum4", sum4);		
		
		
		//5¿ù
		ArrayList<t_expenseDTO> list5 = dao.may();
		
		int sum5 = 0;
		
		for(int i = 0; i < list5.size(); i++) {
			System.out.println(list5.get(i).getExp_price());
			sum5 += list5.get(i).getExp_price();
		}
		System.out.println("5ÃÑ ÇÕ" + sum5);
		request.setAttribute("sum5", sum5);
		
		
		//6¿ù
		ArrayList<t_expenseDTO> list6 = dao.jun();
		
		int sum6 = 0;
		
		for(int i = 0; i < list6.size(); i++) {
			System.out.println(list6.get(i).getExp_price());
			sum6 += list6.get(i).getExp_price();
		}
		System.out.println("6ÃÑ ÇÕ" + sum6);
		request.setAttribute("sum6", sum6);
		
		
		//7¿ù
		ArrayList<t_expenseDTO> list7 = dao.jul();
		
		int sum7 = 0;
		
		for(int i = 0; i < list7.size(); i++) {
			System.out.println(list7.get(i).getExp_price());
			sum7 += list7.get(i).getExp_price();
		}
		
		System.out.println("7ÃÑ ÇÕ" + sum7);
		request.setAttribute("sum7", sum7);
		
		
		//8¿ù
		ArrayList<t_expenseDTO> list8 = dao.aug();
		
		int sum8 = 0;
		
		for(int i = 0; i < list8.size(); i++) {
			System.out.println(list8.get(i).getExp_price());
			sum8 += list8.get(i).getExp_price();
		}
		
		System.out.println("8ÃÑ ÇÕ" + sum8);
		request.setAttribute("sum8", sum8);		
		
		
		//9¿ù
		ArrayList<t_expenseDTO> list9 = dao.sep();
		
		int sum9 = 0;
		
		for(int i = 0; i < list9.size(); i++) {
			System.out.println(list9.get(i).getExp_price());
			sum9 += list9.get(i).getExp_price();
		}
		
		System.out.println("9ÃÑ ÇÕ" + sum9);
		request.setAttribute("sum9", sum9);
		
		
		//10¿ù
		ArrayList<t_expenseDTO> list10 = dao.oct();
		
		int sum10 = 0;
		
		for(int i = 0; i < list10.size(); i++) {
			System.out.println(list10.get(i).getExp_price());
			sum10 += list10.get(i).getExp_price();
		}
		
		System.out.println("10ÃÑ ÇÕ" + sum10);
		request.setAttribute("sum10", sum10);		
		
		
		//11¿ù
		ArrayList<t_expenseDTO> list11 = dao.nov();
		
		int sum11 = 0;
		
		for(int i = 0; i < list11.size(); i++) {
			System.out.println(list11.get(i).getExp_price());
			sum11 += list11.get(i).getExp_price();
		}
		
		System.out.println("11ÃÑ ÇÕ" + sum11);
		request.setAttribute("sum11", sum11);
		
		
		//12¿ù
		ArrayList<t_expenseDTO> list12 = dao.dec();
		
		int sum12 = 0;
		
		for(int i = 0; i < list12.size(); i++) {
			System.out.println(list12.get(i).getExp_price());
			sum12 += list12.get(i).getExp_price();
		}
		
		System.out.println("12ÃÑ ÇÕ" + sum12);
		request.setAttribute("sum12", sum12);		
		
		
		RequestDispatcher rd7 = request.getRequestDispatcher("Chartsmonth.jsp");
		rd7.forward(request, response);
		
		
		
		
	}

}
