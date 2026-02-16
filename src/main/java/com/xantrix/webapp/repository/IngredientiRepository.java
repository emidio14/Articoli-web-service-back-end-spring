package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Ingredienti;

@Repository
public class IngredientiRepository implements IRepositoryReadOnly<Ingredienti> {

	private final DataSource ds;

	public IngredientiRepository(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Ingredienti> getAll() {

		List<Ingredienti> listaIngredienti = new ArrayList<Ingredienti>();

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT codart, info, articolo_codart FROM ingredienti ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Ingredienti ing = new Ingredienti();
				ing.setCodArt(rs.getString("codart"));
				ing.setInfo(rs.getString("info"));
				listaIngredienti.add(ing);
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return listaIngredienti;
	}

	@Override
	public Ingredienti getById(String id) {

		Ingredienti ing = null;

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT codart, info, articolo_codart "
					+ "FROM ingredienti "
					+ "WHERE codart = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ing = new Ingredienti();
				ing.setCodArt(rs.getString("codart"));
				ing.setInfo(rs.getString("info"));

			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return ing;
	}
}
