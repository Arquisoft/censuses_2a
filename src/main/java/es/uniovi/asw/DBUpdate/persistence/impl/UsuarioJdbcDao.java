package es.uniovi.asw.DBUpdate.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.Jdbc;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;

public class UsuarioJdbcDao implements UsuarioDao{
	
	private String SAVE_SQL="INSERT INTO Votantes (Nombre,Email,NIF,CodColegio,Password) VALUES (?,?,?,?,?);";
	private String RESET_ID="ALTER TABLE Votantes ALTER COLUMN 'ID' RESTART WITH 1;";
	private String DELETE_ALL = "delete from Votantes;";
	private String FIND_USER="select * from Votantes where email = ?";
	
	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Usuario user) {
		
		Connection con = null;
		
		PreparedStatement ps =null;
		int rows=0;

		try {
			
			con = Jdbc.getConnection();
			
			ps = con.prepareStatement(SAVE_SQL);
			
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getNIF());
			ps.setInt(4, user.getCodColElectoral());
			ps.setString(5, user.getPassword());

			rows = ps.executeUpdate();
			if (rows != 1) {
				System.out.println("User" + user.getNombre() + " already exist");
				return false;
			} 
			
			con.close();
			
			return true;
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return false;
		
	}

	@Override
	public boolean update(Usuario a) {
		
		return false;
		
	}

	@Override
	public boolean delete(String email) {
		
		return false;
		
	}

	@Override
	public Usuario findByNIF(String email) {
		
		Connection con = null;
		
		PreparedStatement ps =null;

		try {
			
			con = Jdbc.getConnection();
			
			ps = con.prepareStatement(FIND_USER);
			ps.setString(1, email);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs != null){
				
				while(rs.next()){
					
					String nombre = rs.getString(2);
					String password = rs.getString(6);
					String NIF = rs.getString(4);
					int CodColegio = rs.getInt(5);
					
					return new Usuario(nombre, email, NIF, password, CodColegio);
					
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
