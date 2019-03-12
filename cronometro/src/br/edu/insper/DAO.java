package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "130879");
	}
	
	public List<Dados> getLista() throws SQLException {
		
		List<Dados> dados = new ArrayList<Dados>();
		
		PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM historico");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Dados dados1 = new Dados();
			dados1.setId(rs.getInt("id"));
			dados1.setHora(rs.getInt("hora"));
			dados1.setMinuto(rs.getInt("minuto"));
			dados1.setSegundo(rs.getInt("segundo"));
			dados1.setData(rs.getDate("data"));
			
			dados.add(dados1);
		}
		rs.close();
		stmt.close();
		
		return dados;

}

	public void close() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Dados dado) {
		String sql = "INSERT INTO historico"
				+"(hora, minuto, segundo) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, dado.getHora());
			stmt.setInt(2, dado.getMinuto());
			stmt.setInt(3, dado.getSegundo());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void remove(Integer id) {
		try {
			
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM historico WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
	
}
