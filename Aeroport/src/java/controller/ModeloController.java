package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModeloDAO;
import model.Modelo;

@WebServlet(name = "Modelo", urlPatterns={"/ModeloController"})
public class ModeloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/modelo.jsp";
    private static String LIST_MODELO = "/listaModelos.jsp";
    private ModeloDAO modeloDAO;
    public ModeloController() {
        super();
        modeloDAO = new ModeloDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	String codmodelo = request.getParameter("codmodelo");
        	try {
        		modeloDAO.delete(codmodelo);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_MODELO;
        	try {
				request.setAttribute("modelos", modeloDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
	        String codmodelo = request.getParameter("codmodelo");
	        try {
	        	modeloDAO.select(codmodelo);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("codmodelo", codmodelo);
	        } 
        else if (action.equalsIgnoreCase("listaModelos")){
        	forward = LIST_MODELO;
        	try {
				request.setAttribute("modelos",  modeloDAO.selectALL());
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
		Modelo model = new Modelo();
		model.setCodmodelo(request.getParameter("codmodelo"));
		model.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
		model.setPeso(Float.parseFloat(request.getParameter("peso")));
        RequestDispatcher view = request.getRequestDispatcher(LIST_MODELO);
        try {
			request.setAttribute("modelos", modeloDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}
}
