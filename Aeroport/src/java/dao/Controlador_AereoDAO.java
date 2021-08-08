package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import util.DButil;

import model.Controlador_Aereo;

import java.util.ArrayList;


public class Controlador_AereoDAO {
	private static Controlador_AereoDAO controlDAO = null;
private Connection connection;
	
	public Controlador_AereoDAO() {
        connection = DButil.getConnection();
    }
	
	public static Controlador_AereoDAO getInstance() throws ClassNotFoundException, SQLException{
		if(controlDAO == null){
			controlDAO = new Controlador_AereoDAO();
		}
		return controlDAO;
	}
	
	public Controlador_Aereo select(int nmembro) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from controlado_aereo where nmembro = ?");
		preparedStatement.setInt(0, nmembro);
		ResultSet rs = preparedStatement.executeQuery();
		Controlador_Aereo c = null;
		if(rs.next()) {
			c = new Controlador_Aereo();
			c.setNmembro(rs.getInt("nmembro"));
			c.setExame(rs.getDate("exame"));
			c.setSindicato(SindicatoDAO.getInstance().select(rs.getInt("nmembro")));
		}
		return c;
	}
	
	public void delete(int nmembro) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("delete from controlado_aereo where nmembro = ?");
		preparedStatement.setInt(1, nmembro);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Controlador_Aereo c) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("insert into controlado_aereo values(?,?)");
		preparedStatement.setInt(1,c.getNmembro());
		preparedStatement.setDate(2,c.getExame());
		preparedStatement.executeUpdate();
	}
	
	public void update(Controlador_Aereo c) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("update controlado_aereo set exame=? where nmembro = ?");
		preparedStatement.setInt(1,c.getNmembro());
		preparedStatement.setDate(2,c.getExame());
		preparedStatement.executeUpdate();
	}
	
	public List<Controlador_Aereo> selectALL() throws ClassNotFoundException, SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from controlado_aereo oder by nmembro");
		Controlador_Aereo c = null;
		List<Controlador_Aereo> listaControladores = new ArrayList<Controlador_Aereo>();
		while(rs.next()) {
			c = new Controlador_Aereo();
			c.setNmembro(rs.getInt("nmembro"));
			c.setExame(rs.getDate("exame"));
			c.setSindicato(SindicatoDAO.getInstance().select(rs.getInt("nmembro")));
			listaControladores.add(c);
		}
		return listaControladores;
	}
}
