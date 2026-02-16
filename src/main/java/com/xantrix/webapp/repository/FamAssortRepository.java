package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.entities.Iva;

@Repository
public class FamAssortRepository implements IRepositoryReadOnly<FamAssort> {

	private final DataSource ds;

	public FamAssortRepository(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<FamAssort> getAll() {

		List<FamAssort> listaFamAssort = new ArrayList<FamAssort>();

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT id, descrizione FROM famassort ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FamAssort famAss = new FamAssort();
				famAss.setId(rs.getString("id"));
				famAss.setDescrizione(rs.getString("descrizione"));

				listaFamAssort.add(famAss);
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return listaFamAssort;
	}

	@Override
	public FamAssort getById(String id) {

		FamAssort famAss = null;

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT id, descrizione FROM famassort WHERE id = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				famAss = new FamAssort();
				famAss.setId(rs.getString("id"));
				famAss.setDescrizione(rs.getString("descrizione"));

			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return famAss;
	}
}
