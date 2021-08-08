package dao;
import model.Aeroporto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import util.DButil;



public class AeroportoDAO {
	private static AeroportoDAO aeroDAO = null;
	private Connection connection;
	
	public AeroportoDAO() {
        connection = DButil.getConnection();
    }
	
	public static AeroportoDAO getInstance() throws ClassNotFoundException, SQLException {
		if(aeroDAO == null){
			aeroDAO = new AeroportoDAO();
		}
		return aeroDAO;
	}
	public Aeroporto select(String nome) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from aeroporto where nome = ?");
		preparedStatement.setString(1, nome);
		ResultSet rs = preparedStatement.executeQuery();
		Aeroporto a = null;
		if(rs.next()) {
			a = new Aeroporto();
			a.setNome(rs.getString("nome"));
			a.setEndereco(rs.getString("endereco"));
			a.setNaviões(rs.getInt("naviões"));
		}
		return a;
	}
	
	public void delete(String nome) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("delete from aeroporto where nome = ?");
		preparedStatement.setString(1, nome);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Aeroporto a) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("insert into aeroporto values(?,?,?)");
		preparedStatement.setString(1, a.getNome());
		preparedStatement.setString(2, a.getEndereco());
		preparedStatement.setInt(3, a.getNaviões());
		preparedStatement.executeUpdate();
	}
	
	public void update(Aeroporto a) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("update aeroporto set endereco=?, naviões=? where nome = ?");
		preparedStatement.setString(1, a.getNome());
		preparedStatement.setString(2, a.getEndereco());
		preparedStatement.setInt(3, a.getNaviões());
		preparedStatement.executeUpdate();
		
	}
	
	public List<Aeroporto> selectALL() throws ClassNotFoundException, SQLException {
        Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from aeroporto order by nome");
		Aeroporto a = null;
		List<Aeroporto> listaAeroportos = new ArrayList<Aeroporto>();
		while(rs.next()) {
			a = new Aeroporto();
			a.setNome(rs.getString("nome"));
			a.setEndereco(rs.getString("endereco"));
			a.setNaviões(rs.getInt("naviões"));
			listaAeroportos.add(a);
		}
		return listaAeroportos;
	}

}
