package dao;
import java.util.List;
import util.DButil;
import java.sql.Connection;
import model.Testes;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestesDAO {
	private static TestesDAO testDAO = null;
	private Connection connection;
	
	public TestesDAO() {
        connection = DButil.getConnection();
    }
	
	public static TestesDAO getInstance() throws ClassNotFoundException, SQLException {
		if(testDAO == null){
			testDAO = new TestesDAO();
		}
		return testDAO;
	}
	
	public Testes select(int n_ANAC) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from testes where n_ANAC = ?");
		preparedStatement.setInt(0, n_ANAC);
		ResultSet rs = preparedStatement.executeQuery();
		Testes t = null;
		if(rs.next()) {
			t = new Testes();
			t.setN_ANAC(rs.getInt("n_ANAC"));
			t.setNome(rs.getString("nome"));
			t.setDatateste(rs.getDate("datateste"));
			t.setNhoras(rs.getFloat("nhoras"));
			t.setPontuação(rs.getFloat("pontuação"));
			t.setNmatricula(rs.getInt("nmatricula"));
			t.setTecnico(TecnicoDAO.getInstance().select(rs.getInt("nmatricula")));
		}
		return t;
	}
	
	public void delete(int n_ANAC) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("delete * from testes where n_ANAC = ?");
		preparedStatement.setInt(1, n_ANAC);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Testes t) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("insert into testes values(?,?,?,?,?,?)");
		preparedStatement.setInt(1,t.getN_ANAC());
		preparedStatement.setString(2, t.getNome());
		preparedStatement.setDate(3, t.getDatateste());
		preparedStatement.setFloat(4, t.getNhoras());
		preparedStatement.setFloat(5, t.getPontuação());
		preparedStatement.setInt(6, t.getNmatricula());
		preparedStatement.executeUpdate();
	}
	
	public void update(Testes t) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("update testes set nome=?,datateste=?,nhoras=?,pontuação=?,nmatricula=? where n_ANAC=?");
		preparedStatement.setInt(1,t.getN_ANAC());
		preparedStatement.setString(2, t.getNome());
		preparedStatement.setDate(3, t.getDatateste());
		preparedStatement.setFloat(4, t.getNhoras());
		preparedStatement.setFloat(5, t.getPontuação());
		preparedStatement.setInt(6, t.getNmatricula());
		preparedStatement.executeUpdate();
	}
	
	public List<Testes> selectALL() throws ClassNotFoundException, SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from testes order by n_ANAC");
		Testes t = null;
		List<Testes> listaTestes = new ArrayList<Testes>();
		if(rs.next()) {
			t = new Testes();
			t.setN_ANAC(rs.getInt("n_ANAC"));
			t.setNome(rs.getString("nome"));
			t.setDatateste(rs.getDate("datateste"));
			t.setNhoras(rs.getFloat("nhoras"));
			t.setPontuação(rs.getFloat("pontuação"));
			t.setNmatricula(rs.getInt("nmatricula"));
			t.setTecnico(TecnicoDAO.getInstance().select(rs.getInt("nmatricula")));
			listaTestes.add(t);
		}
		return listaTestes;
	}

}
