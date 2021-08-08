package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import util.DButil;

import model.Aviao;

import java.util.ArrayList;

public class AviaoDAO {
	private static AviaoDAO aviaDAO = null;
	private Connection connection;
	
	public AviaoDAO() {
        connection = DButil.getConnection();
    }
	
	public static AviaoDAO getInstance() throws ClassNotFoundException, SQLException{
		if(aviaDAO == null){
			aviaDAO = new AviaoDAO();
		}
		return aviaDAO;
	}
	
	public Aviao select(int registro) throws ClassNotFoundException, SQLException { 
		PreparedStatement preparedStatement = connection.prepareStatement("select * from aviao where registro = ?");
		preparedStatement.setInt(0, registro);
		ResultSet rs = preparedStatement.executeQuery();
		Aviao a = null;
		if(rs.next()) {
			a = new Aviao();
			a.setRegistro(rs.getInt("registro"));
			a.setNome(rs.getString("nome"));
			a.setCodmodelo(rs.getString("codmodelo"));
			a.setModelo(ModeloDAO.getInstance().select(rs.getString("codmodelo")));
			a.setAeroporto(AeroportoDAO.getInstance().select(rs.getString("nome")));
		}
		return a;
	}
	
	public void delete(int registro) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("delete from aviao where registro = ?");
		preparedStatement.setInt(1, registro);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Aviao a) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("insert into aviao values(?,?,?)");
		preparedStatement.setInt(1, a.getRegistro());
		preparedStatement.setString(1, a.getNome());
		preparedStatement.setString(1, a.getCodmodelo());
		preparedStatement.executeUpdate();
	}
	
	public void update(Aviao a) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("update aviao set nome=?,codmodelo=? where registro = ?)");
		preparedStatement.setInt(1, a.getRegistro());
		preparedStatement.setString(1, a.getNome());
		preparedStatement.setString(1, a.getCodmodelo());
		preparedStatement.executeUpdate();
	}
	
	public List<Aviao> selectALL() throws ClassNotFoundException, SQLException{
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from aeroporto order by nome");
		Aviao a = null;
		List<Aviao> listaAvioes = new ArrayList<Aviao>();
		while(rs.next()) {
			a = new Aviao();
			a.setRegistro(rs.getInt("registro"));
			a.setNome(rs.getString("nome"));
			a.setCodmodelo(rs.getString("codmodelo"));
			a.setModelo(ModeloDAO.getInstance().select(rs.getString("codmodelo")));
			a.setAeroporto(AeroportoDAO.getInstance().select(rs.getString("nome")));
			listaAvioes.add(a);
		}
		return listaAvioes;
	}

}
