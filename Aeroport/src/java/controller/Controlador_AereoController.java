package controller;
import java.io.IOException;
import java.text.ParseException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Controlador_AereoDAO;
import model.Controlador_Aereo;

/**
 * Servlet implementation class Controlador_AereoServlet
 */
@WebServlet(name = "Controlador",urlPatterns={"/Controlador_AereoServlet"})
public class Controlador_AereoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/controlado_aereo.jsp";
    private static String LIST_CONTROLADOR = "/listaControlador.jsp";
    private Controlador_AereoDAO controladorDAO;
    public Controlador_AereoController() {
        super();
        controladorDAO = new Controlador_AereoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
        	Integer nmembro = Integer.parseInt(request.getParameter("nmembro"));
        	try {
        		controladorDAO.delete(nmembro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	forward = LIST_CONTROLADOR;
        	try {
				request.setAttribute("controladores", controladorDAO.selectALL());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	} 
        else if (action.equalsIgnoreCase("edit")){
	        forward = INSERT_OR_EDIT;
        	Integer nmembro = Integer.parseInt(request.getParameter("nmembro"));
	        try {
	        	controladorDAO.select(nmembro);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("nmembro", nmembro);
	        } 
        else if (action.equalsIgnoreCase("listaAeroportos")){
        	forward = LIST_CONTROLADOR;
        	try {
				request.setAttribute("controladores",  controladorDAO.selectALL());
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
		Controlador_Aereo control = new Controlador_Aereo();
		control.setNmembro(Integer.parseInt(request.getParameter("nmembro")));
		try {
            Date exame=null;
            String teste = request.getParameter("exame");
            System.out.println(teste);
            if(request.getParameter("exame")!=null){
                exame = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("exame"));
            }
            control.setExame(exame);
		} catch (ParseException e) {
            e.printStackTrace();
        }
            RequestDispatcher view = request.getRequestDispatcher(LIST_CONTROLADOR);
        try {
			request.setAttribute("avioes", controladorDAO.selectALL());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
	}


}
