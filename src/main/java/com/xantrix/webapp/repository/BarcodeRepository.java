package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.entities.Ingredienti;

@Repository
public class BarcodeRepository implements IRepositoryReadOnly<Ingredienti>{
	
	private final DataSource ds;
	
	public BarcodeRepository(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Ingredienti> getAll() {
		
		List<Barcode> listaBarcode = new ArrayList<Barcode>();
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "SELECT barcode, idtipoart, codart FROM barcode";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Barcode bc = new Barcode();
				bc.setBarcode(rs.getString("barcode"));
				bc.setIdTipoArt(rs.getString("idtipoart"));
				//TODO: Aggiungere campo dell'entity che è un oggetto
			}
			
		}catch() {
			
		}
		
		return null;
	}

	@Override
	public Articoli getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
