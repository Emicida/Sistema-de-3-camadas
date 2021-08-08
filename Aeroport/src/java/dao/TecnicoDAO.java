package dao;
import java.util.List;

import model.Tecnico;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import util.DButil;

public class TecnicoDAO {
	private static TecnicoDAO tecDAO = null;
	private Connection connection;
	
	public TecnicoDAO() {
        connection = DButil.getConnection();
    }
	
	public static TecnicoDAO getInstance() throws ClassNotFoundException, SQLException{
		if(tecDAO == null){
			tecDAO = new TecnicoDAO();
		}
		return tecDAO;
	}
	
	public Tecnico select(int nmatricula) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from tecnico where nmatricula = ?");
		preparedStatement.setInt(0, nmatricula);
		ResultSet rs = preparedStatement.executeQuery();
		Tecnico t = null;
		if(rs.next()) {
			t = new Tecnico();
			t.setNmatricula(rs.getInt("nmatricula"));
			t.setTelefone(rs.getString("telefone"));
			t.setSalario(rs.getFloat("salario"));
			t.setEndereco(rs.getString("endereco"));
			t.setNmembro(rs.getInt("nmembro"));
			t.setNome(rs.getString("nome"));
			t.setCodmodelo(rs.getString("codmodelo"));
			t.setSindicato(SindicatoDAO.getInstance().select(rs.getInt("nmembro")));
			t.setModelo(ModeloDAO.getInstance().select(rs.getString("codmodelo")));
		}
		return t;
	}
	
	public void delete(int nmatricula) throws ClassNotFoundException, SQLException{ 
		PreparedStatement preparedStatement = connection.prepareStatement("delete * from tecnico where nmatricula = ?");
		preparedStatement.setInt(1, nmatricula);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Tecnico t) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("insert into tecnico(nmatricula,telefone,salario,endereco,nmembro,nome,codmodelo) values(?,?,?,?,?,?,?)");
		preparedStatement.setInt(1,t.getNmatricula());
		preparedStatement.setString(2, t.getTelefone());
		preparedStatement.setFloat(3, t.getSalario());
		preparedStatement.setString(4, t.getEndereco());
		preparedStatement.setString(6, t.getNome());
		preparedStatement.setString(7, t.getCodmodelo());
		preparedStatement.executeUpdate();
	}
	
	public void update(Tecnico t) throws ClassNotFoundException, SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement("update tecnico set telefone=?,salario=?,endereco=?,nmembro=?,nome=?,codmodelo=? where nmatricula=?");
		preparedStatement.setInt(1,t.getNmatricula());
		preparedStatement.setString(2, t.getTelefone());
		preparedStatement.setFloat(3, t.getSalario());
		preparedStatement.setString(4, t.getEndereco());
		preparedStatement.setInt(5, t.getNmembro());
		preparedStatement.setString(6, t.getNome());
		preparedStatement.setString(7, t.getCodmodelo());
		preparedStatement.executeUpdate();
	}
	
	public List<Tecnico> selectALL() throws ClassNotFoundException, SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from tecnico order by nmatricula");
		Tecnico t = null;
		List<Tecnico> listaTecnicos = new ArrayList<Tecnico>();
		if(rs.next()) {
			t = new Tecnico();
			t.setNmatricula(rs.getInt("nmatricula"));
			t.setTelefone(rs.getString("telefone"));
			t.setSalario(rs.getFloat("salario"));
			t.setEndereco(rs.getString("endereco"));
			t.setNmembro(rs.getInt("nmembro"));
			t.setNome(rs.getString("nome"));
			t.setCodmodelo(rs.getString("codmodelo"));
			t.setSindicato(SindicatoDAO.getInstance().select(rs.getInt("nmatricula")));
			t.setModelo(ModeloDAO.getInstance().select(rs.getString("codmodelo")));
			t.setSindicato(SindicatoDAO.getInstance().select(rs.getInt("nmembro")));
			t.setModelo(ModeloDAO.getInstance().select(rs.getString("codmodelo")));
			listaTecnicos.add(t);
		}
		return listaTecnicos;
	}
}
