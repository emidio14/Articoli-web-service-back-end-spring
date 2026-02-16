package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Barcode;

@Repository
public class BarcodeRepository implements IRepositoryReadOnly<Barcode> {

	private final DataSource ds;

	public BarcodeRepository(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Barcode> getAll() {

		List<Barcode> listaBarcode = new ArrayList<Barcode>();

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT barcode, idtipoart, codart FROM barcode";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Barcode bc = new Barcode();
				bc.setBarcode(rs.getString("barcode"));
				bc.setIdTipoArt(rs.getString("idtipoart"));
				listaBarcode.add(bc);
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return listaBarcode;
	}

	@Override
	public Barcode getById(String id) {

		Barcode bar = null;

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT barcode, idtipoart, codart FROM barcode WHERE barcode = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bar = new Barcode();
				bar.setBarcode(rs.getString("barcode"));
				bar.setIdTipoArt(rs.getString("idtipoart"));
				
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bar;
	}
}
