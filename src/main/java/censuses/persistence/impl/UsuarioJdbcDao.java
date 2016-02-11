package censuses.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import censuses.model.Usuario;
import censuses.persistence.Jdbc;
import censuses.persistence.UsuarioDao;

public class UsuarioJdbcDao implements UsuarioDao{
	
	private String SAVE_SQL="INSERT INTO Votantes (Nombre,Email,NIF,CodColegio,Password) VALUES (?,?,?,?,?);";
	
	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Usuario user) {
		// TODO Auto-generated method stub
		try {
			
			Connection con = Jdbc.getConnection();
			
			PreparedStatement ps = con.prepareStatement(SAVE_SQL);
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getNIF());
			ps.setInt(4, user.getCodColElectoral());
			ps.setString(5, user.getPassword());

			ps.execute();
			
			con.close();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public void update(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUsuarios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reiniciaID() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
