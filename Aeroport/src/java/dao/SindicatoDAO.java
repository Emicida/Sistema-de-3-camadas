package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import util.DButil;
import model.Sindicato;

import java.util.ArrayList;


public class SindicatoDAO {
	private static SindicatoDAO sindDAO = null;
	private Connection connection;
	
	public SindicatoDAO() {
        connection = DButil.getConnection();
    }
	
	public static SindicatoDAO getInstance() throws ClassNotFoundException, SQLException{
		if(sindDAO == null){
			sindDAO = new SindicatoDAO();
		}
		return sindDAO;
	}
	
	public Sindicato select(int nmembro) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from sindicato where nmembro = ?");
		preparedStatement.setInt(0, nmembro);
		ResultSet rs = preparedStatement.executeQuery();
		Sindicato s = null;
		if(rs.next()) {
			s = new Sindicato();
			s.setNmembro(rs.getInt("nmembro"));
		}
		return s;
	}
	
	public void delete(int nmembro) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("delete from sindicato where nmembro = ?");
		preparedStatement.setInt(1, nmembro);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Sindicato s) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("insert into sindicato values(?)");
		preparedStatement.setInt(1, s.getNmembro());
		preparedStatement.executeUpdate();
	}
	
	public void update(Sindicato s) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("update sindicato set nmembro = ? where nmembro = ?");
		preparedStatement.setInt(1, s.getNmembro());
		preparedStatement.executeUpdate();
	}
	
	public List<Sindicato> selectALL() throws ClassNotFoundException, SQLException{
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from sindicato order by nmembro");
		Sindicato s = null;
		List<Sindicato> listaSindicatos = new ArrayList<Sindicato>();
		while(rs.next()) {
			s = new Sindicato();
			s.setNmembro(rs.getInt("nmembro"));
			listaSindicatos.add(s);
		}
		return listaSindicatos;
	}

}
