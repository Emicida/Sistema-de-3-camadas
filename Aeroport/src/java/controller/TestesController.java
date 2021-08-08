package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestesDAO;
import model.Testes;

/**
 * Servlet implementation class TestesServlet
 */
@WebServlet(name="Testes", urlPatterns={"/TestesController"})
public class TestesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/testes.jsp";
    private static String LIST_TESTES = "/listatestes.jsp";
    private TestesDAO testesDAO;
    public TestesController() {
        super();
        testesDAO = new TestesDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	Integer n_ANAC = Integer.parseInt(request.getParameter("n_ANAC"));
        	try {
        		testesDAO.delete(n_ANAC);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_TESTES;
        	try {
				request.setAttribute("testes", testesDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
        	Integer n_ANAC = Integer.parseInt(request.getParameter("n_ANAC"));
	        try {
	        	testesDAO.select(n_ANAC);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("n_ANAC", n_ANAC);
	        } 
        else if (action.equalsIgnoreCase("listaTestes")){
        	forward = LIST_TESTES;
        	try {
				request.setAttribute("testes",  testesDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        } 
        else {
        	forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Testes test = new Testes();
		test.setN_ANAC(Integer.parseInt(request.getParameter("n_ANAC")));
		test.setNome(request.getParameter("nome"));
		try {
            Date datateste=null;
            String teste = request.getParameter("datateste");
            System.out.println(teste);
            if(request.getParameter("datateste")!=null){
            	datateste = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("datateste"));
            }
            test.setDatateste(datateste);
            
		} catch (ParseException e) {
            e.printStackTrace();
        }
		test.setNhoras(Float.parseFloat(request.getParameter("datateste")));
		test.setPontuação(Float.parseFloat(request.getParameter("pontuação")));
		test.setNmatricula(Integer.parseInt(request.getParameter("nmatricula")));
        RequestDispatcher view = request.getRequestDispatcher(LIST_TESTES);
        try {
			request.setAttribute("testes", testesDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}

}
