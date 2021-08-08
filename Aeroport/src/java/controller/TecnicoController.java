package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TecnicoDAO;
import model.Tecnico;

/**
 * Servlet implementation class TecnicoServlet
 */
@WebServlet(name="Tecnico", urlPatterns={"/TecnicoController"})
public class TecnicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/tecnico.jsp";
    private static String LIST_TECNICO = "/listaTecnicos.jsp";
    private TecnicoDAO tecnicoDAO;
    public TecnicoController() {
        super();
        tecnicoDAO = new TecnicoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	Integer nmatricula = Integer.parseInt(request.getParameter("nmatricula"));
        	try {
        		tecnicoDAO.delete(nmatricula);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_TECNICO;
        	try {
				request.setAttribute("tecnicos", tecnicoDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
	        Integer nmatricula = Integer.parseInt(request.getParameter("nmatricula"));
	        try {
	        	tecnicoDAO.select(nmatricula);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("nmatricula", nmatricula);
	        } 
        else if (action.equalsIgnoreCase("listaTecnicos")){
        	forward = LIST_TECNICO;
        	try {
				request.setAttribute("tecnicos",  tecnicoDAO.selectALL());
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
		Tecnico tec = new Tecnico();
		tec.setNmatricula(Integer.parseInt(request.getParameter("nmatricula")));
		tec.setTelefone(request.getParameter("telefone"));
		tec.setSalario(Float.parseFloat(request.getParameter("salario")));
		tec.setEndereco(request.getParameter("endereco"));
		tec.setNmembro(Integer.parseInt(request.getParameter("nmembro")));
		tec.setNome(request.getParameter("nome"));
		tec.setCodmodelo(request.getParameter("codmodelo"));
        RequestDispatcher view = request.getRequestDispatcher(LIST_TECNICO);
        try {
			request.setAttribute("tecnicos", tecnicoDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}
}
