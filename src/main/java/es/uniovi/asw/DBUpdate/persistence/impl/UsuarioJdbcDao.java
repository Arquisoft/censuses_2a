package es.uniovi.asw.DBUpdate.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.Jdbc;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;

public class UsuarioJdbcDao implements UsuarioDao{
	
	private String SAVE_SQL="INSERT INTO Votantes (Login,Nombre,Email,NIF,CodColegio,Password) VALUES (?,?,?,?,?,?);";
	private String RESET_ID="ALTER TABLE Votantes ALTER COLUMN 'ID' RESTART WITH 1;";
	private String DELETE_ALL = "delete from Votantes;";
	private String FIND_USER="select * from Votantes where nif = ?";
	private String FIND_ALL_USERS="select * from Votantes";
	private String DELETE_USER="delete from Votantes where nif=?";
	
	@Override
	public List<Usuario> getUsuarios() {
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Usuario> usuarios= new ArrayList<Usuario>();
		try {
			con = Jdbc.getConnection();
			
			ps=con.prepareStatement(FIND_ALL_USERS);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getString("nombre"),
						rs.getString("Email"),
						rs.getString("NIF"),
						rs.getString("Password"),
						rs.getInt("CodColegio"),
						rs.getInt("id"),
						rs.getString("login"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return usuarios;
		
	}

	@Override
	public boolean save(Usuario user) {
		
		Connection con = null;
		
		PreparedStatement ps =null;
		int rows=0;
		
		if(findByNIF(user.getNIF())==null){
		
			try {
				
				con = Jdbc.getConnection();
				
				ps = con.prepareStatement(SAVE_SQL);
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getNombre());
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getNIF());
				ps.setInt(5, user.getCodColElectoral());
				ps.setString(6, user.getPassword());
	
				rows = ps.executeUpdate();
				if (rows != 1) {
					System.out.println("User" + user.getNombre() + " already exist");
					return false;
				} 
							
				return true;
				
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
				
			}finally  {
				if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
				if (con != null) {try{ con.close(); } catch (Exception ex){}};
			}
		
		}
		
		return false;
				
	}

	@Override
	public boolean update(Usuario a) {
		
		return false;
		
	}

	@Override
	public boolean delete(String nif) {
		
		Connection con = null;
		
		PreparedStatement ps =null;
		
		try {
			
			con = Jdbc.getConnection();
			ps=con.prepareStatement(DELETE_USER);
			ps.setString(1, nif);
			
			int row=ps.executeUpdate();
			
			if(row>=1){
				
				return true;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return false;
		
	}

	@Override
	public Usuario findByNIF(String nif) {
		
		Connection con = null;
		
		PreparedStatement ps =null;

		try {
			
			con = Jdbc.getConnection();
			
			ps = con.prepareStatement(FIND_USER);
			ps.setString(1, nif);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs != null){
				
				while(rs.next()){
					
					String nombre = rs.getString(3);
					String password = rs.getString(7);
					String email = rs.getString(4);
					int CodColegio = rs.getInt(6);
					int id= rs.getInt(1);
					String login = rs.getString(2);
					
					return new Usuario(nombre, email, nif, password, CodColegio,id,login);
					
				}
				
			}else{
				
				return null;
				
			}
			
		
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());

		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
			
		return null;
		
	}

	@Override
	public boolean deleteUsuarios() {
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			
			con = Jdbc.getConnection();
			ps = con.prepareStatement(DELETE_ALL);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		return false;
		
	}

	@Override
	public void reiniciaID() {
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			
			con = Jdbc.getConnection();
			ps = con.prepareStatement(RESET_ID);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
	}

}
