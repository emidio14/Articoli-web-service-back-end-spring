package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Articoli;


@Repository
public class ArticoliRepository implements IRepositoryReadOnly<Articoli>, IRepositoryWrite<Articoli>{

	@Override
	public List<Articoli> getAll() {
		
		List<Articoli> listaArticoli = new ArrayList<Articoli>();
					
		try {
			Connection	conn = ConnectionSingleton.getInstance().getConnection();

			String query = "SELECT codart, codstat, datacreazione, descrizione, idstatoart, pesonetto, pzcart, um, idfamass, idiva FROM articoli";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Articoli articoli = new Articoli();
				articoli.setCodArt(rs.getString("codart"));
				articoli.setCodStat(rs.getString("codstat"));
				articoli.setDataCreaz(rs.getDate("datacreazione"));
				articoli.setDescrizione(rs.getString("descrizione"));
				articoli.setIdStatoArt(rs.getString("idstatoart"));
				articoli.setPesoNetto(rs.getDouble("pesonetto"));
				Integer pzcartParse = rs.getObject("pzcart", Integer.class);
				articoli.setPzCart(pzcartParse);
				articoli.setUm(rs.getString("um"));
				
				listaArticoli.add(articoli);
				
			}
			
			conn.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return listaArticoli;
	}
	
	@Override
	public Articoli getById(String id) {
		Articoli art = null;
		
		try {
			
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "SELECT codart, codstat, datacreazione, descrizione, idstatoart, pesonetto, pzcart, um, idfamass, idiva "
					+ "FROM articoli WHERE codart = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				art = new Articoli();
				art.setCodArt(rs.getString("codart"));
				art.setCodStat(rs.getString("codstat"));
				art.setDataCreaz(rs.getDate("datacreazione"));
				art.setDescrizione(rs.getString("descrizione"));
				art.setIdStatoArt(rs.getString("idstatoart"));
				art.setPesoNetto(rs.getInt("pesonetto"));
				Integer parsePzcart = rs.getObject("pzcart", Integer.class);
				art.setPzCart(rs.getInt(parsePzcart));
				art.setUm(rs.getString("um"));
				
			}
			
			conn.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return art;
	}

	@Override
	public boolean Insert(Articoli obj) {
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "INSERT INTO articoli (codart, codstat, datacreazione, descrizione, idstatoart, pesonetto, pzcart, um, idfamass, idiva ) VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getCodArt());
			ps.setString(2, obj.getCodStat());
			ps.setDate(3, obj.getDataCreaz());
			ps.setString(4, obj.getDescrizione());
			ps.setString(5, obj.getIdStatoArt());
			ps.setDouble(6, obj.getPesoNetto());
			ps.setInt(7, obj.getPzCart());
			ps.setString(4, obj.getUm());
			ps.setString(4, obj.getIdStatoArt());
			ps.setString(4, obj.getDescrizione());

			
			conn.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean Update(Articoli obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Articoli getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
