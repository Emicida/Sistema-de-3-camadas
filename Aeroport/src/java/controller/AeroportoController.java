package controller;
import dao.AeroportoDAO;
import model.Aeroporto;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Aeroporto",urlPatterns={"/AeroportoController"})
public class AeroportoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/aeroporto.jsp";
    private static String LIST_AERO = "/listaAeroporto.jsp";
    
	private AeroportoDAO aeroDAO;
    public AeroportoController() {
        super();
        aeroDAO = new AeroportoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	String nome = request.getParameter("nome");
        	try {
				aeroDAO.delete(nome);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_AERO;
        	try {
				request.setAttribute("aeroportos", aeroDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
        	String nome = request.getParameter("nome");
	        try {
				aeroDAO.select(nome);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("nome", nome);
	        } 
        else if (action.equalsIgnoreCase("listaAeroportos")){
        	forward = LIST_AERO;
        	try {
				request.setAttribute("aeroportos",  aeroDAO.selectALL());
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
		Aeroporto aero = new Aeroporto();
		aero.setNome(request.getParameter("nome"));
		aero.setEndereco(request.getParameter("endereco"));
		aero.setNaviões(Integer.parseInt(request.getParameter("naviões")));
		RequestDispatcher view = request.getRequestDispatcher(LIST_AERO);
        try {
			request.setAttribute("aeroportos", aeroDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}

}
