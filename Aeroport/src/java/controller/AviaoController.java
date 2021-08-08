package controller;
import dao.AviaoDAO;
import model.Aviao;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Aviao",urlPatterns={"/AviaoController"})
public class AviaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/aviao.jsp";
    private static String LIST_AVIAO = "/listaAviao.jsp";
    private AviaoDAO aviaoDAO;
    public AviaoController() {
        super();
        aviaoDAO = new AviaoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	Integer registro = Integer.parseInt(request.getParameter("registro"));
        	try {
        		aviaoDAO.delete(registro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_AVIAO;
        	try {
				request.setAttribute("avioes", aviaoDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
        	Integer registro = Integer.parseInt(request.getParameter("registro"));
	        try {
	        	aviaoDAO.select(registro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("registro", registro);
	        } 
        else if (action.equalsIgnoreCase("listaAeroportos")){
        	forward = LIST_AVIAO;
        	try {
				request.setAttribute("avioes",  aviaoDAO.selectALL());
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
		Aviao aviao = new Aviao();
		aviao.setRegistro(Integer.parseInt(request.getParameter("registro")));
		aviao.setNome(request.getParameter("nome"));
		aviao.setCodmodelo(request.getParameter("codmodelo"));
		RequestDispatcher view = request.getRequestDispatcher(LIST_AVIAO);
        try {
			request.setAttribute("avioes", aviaoDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}


}
