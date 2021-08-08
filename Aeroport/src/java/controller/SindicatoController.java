package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SindicatoDAO;
import model.Sindicato;

/**
 * Servlet implementation class SindicatoServlet
 */
@WebServlet(name="Sindicato", urlPatterns={"/SindicatoController"})
public class SindicatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/sindicato.jsp";
    private static String LIST_CONTROLADOR = "/listaSindicatos.jsp";
    private SindicatoDAO sindicatoDAO;
    public SindicatoController() {
        super();
        sindicatoDAO = new SindicatoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	Integer nmembro = Integer.parseInt(request.getParameter("nmembro"));
        	try {
        		sindicatoDAO.delete(nmembro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_CONTROLADOR;
        	try {
				request.setAttribute("sindicato", sindicatoDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
        	Integer nmembro = Integer.parseInt(request.getParameter("nmembro"));
	        try {
	        	sindicatoDAO.select(nmembro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("nmembro", nmembro);
	        } 
        else if (action.equalsIgnoreCase("listaSindicatos")){
        	forward = LIST_CONTROLADOR;
        	try {
				request.setAttribute("sindicato",  sindicatoDAO.selectALL());
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
		Sindicato sindicato = new Sindicato();
		sindicato.setNmembro(Integer.parseInt(request.getParameter("nmembro")));
        RequestDispatcher view = request.getRequestDispatcher(LIST_CONTROLADOR);
        try {
			request.setAttribute("sindicato", sindicatoDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}

}
