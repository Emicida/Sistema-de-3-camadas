package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import util.DButil;

import model.Modelo;

import java.util.ArrayList;

public class ModeloDAO {
	private static ModeloDAO modelDAO = null;
	private Connection connection;
	
	public ModeloDAO() {
        connection = DButil.getConnection();
    }
	
	public static ModeloDAO getInstance() throws ClassNotFoundException, SQLException{
		if(modelDAO == null){
			modelDAO = new ModeloDAO();
		}
		return modelDAO;
	}
	
	public Modelo select(String codmodelo) throws ClassNotFoundException, SQLException { 
		PreparedStatement preparedStatement = connection.prepareStatement("select * from modelo where codmodelo = ?");
		preparedStatement.setString(0, codmodelo);
		ResultSet rs = preparedStatement.executeQuery();
		Modelo m = null;
		if(rs.next()) {
			m = new Modelo();
			m.setCodmodelo(rs.getString("codmodelo"));
			m.setCapacidade(rs.getInt("capacidade"));
			m.setPeso(rs.getFloat("peso"));
		}
		return m;
	}
	
	public void delete(String codmodelo) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("delete * from modelo where codmodelo = ?");
		preparedStatement.setString(1, codmodelo);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Modelo m) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("insert into modelo values(?,?,?)");
		preparedStatement.setString(1,m.getCodmodelo());
		preparedStatement.setInt(2, m.getCapacidade());
		preparedStatement.setFloat(3, m.getPeso());
		preparedStatement.executeUpdate();
	}
	
	public void update(Modelo m) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("update modelo set capacidade=?,peso=? where codmodelo = ?");
		preparedStatement.setString(1,m.getCodmodelo());
		preparedStatement.setInt(2, m.getCapacidade());
		preparedStatement.setFloat(3, m.getPeso());
		preparedStatement.executeUpdate();
	}
	
	public List<Modelo> selectALL() throws ClassNotFoundException, SQLException { 
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from modelo order by codmodelo");
		Modelo m = null;
		List<Modelo> listaModelos = new ArrayList<Modelo>();
		if(rs.next()) {
			m = new Modelo();
			m.setCodmodelo(rs.getString("codmodelo"));
			m.setCapacidade(rs.getInt("capacidade"));
			m.setPeso(rs.getFloat("peso"));
			listaModelos.add(m);
		}
		return listaModelos;
	}

}
