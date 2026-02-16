package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Iva;

@Repository
public class IvaRepository implements IRepositoryReadOnly<Iva> {

	private final DataSource ds;

	public IvaRepository(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Iva> getAll() {

		List<Iva> listaIva = new ArrayList<Iva>();

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT idiva, aliquota, descrizione FROM iva";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Iva i = new Iva();
				i.setIdIva(rs.getString("idiva"));
				i.setAliquota(rs.getString("aliquota"));
				i.setDescrizione(rs.getString("descrizione"));
				listaIva.add(i);
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return listaIva;
	}

	@Override
	public Iva getById(String id) {

		Iva iva = null;

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT idiva, aliquota, descrizione FROM iva WHERE idiva = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				iva = new Iva();
				iva.setIdIva(rs.getString("idiva"));
				iva.setAliquota(rs.getString("aliquota"));
				iva.setDescrizione(rs.getString("descrizione"));
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return iva;
	}
}
