package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.entities.Ingredienti;
import com.xantrix.webapp.entities.Iva;

@Repository
public class ArticoliRepository implements IRepositoryReadOnly<Articoli>, IRepositoryWrite<Articoli> {
	
	private final DataSource ds;
	
	public ArticoliRepository(DataSource datasource) {
		this.ds = datasource;
	}

	@Override
	public List<Articoli> getAll() {

		List<Articoli> listaArticoli = new ArrayList<Articoli>();

		try {

			Connection conn = ds.getConnection();

			String query = "SELECT a.codart AS codart_art, a.codstat, a.datacreazione, a.descrizione AS descr_art, "
		             + "a.idstatoart, a.pesonetto, a.pzcart, a.um, a.idfamass, a.idiva, b.codart AS codart_bar, b.barcode AS barcode_b, "
		             + "f.descrizione AS descr_fam, iva.descrizione AS descr_iva, aliquota, b.idtipoart as bar_idtipoart, i.codart AS codart_ingr, "
		             + "i.info AS info_ingr "
		             + "FROM articoli a "
		             + "INNER JOIN famassort f ON a.idfamass = f.id "
		             + "INNER JOIN iva on iva.idiva = a.idiva "
					 + "LEFT JOIN barcode b ON b.codart = a.codart "
					 + "LEFT JOIN ingredienti i ON i.articolo_codart = a.codart ";
			
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Articoli articoli = new Articoli();
				articoli.setCodArt(rs.getString("codart_art"));
				articoli.setCodStat(rs.getString("codstat"));
				articoli.setDataCreaz(rs.getDate("datacreazione"));
				articoli.setDescrizione(rs.getString("descr_art"));
				articoli.setIdStatoArt(rs.getString("idstatoart"));
				articoli.setPesoNetto(rs.getDouble("pesonetto"));
				articoli.setPzCart(rs.getInt("pzcart"));
				articoli.setUm(rs.getString("um"));
				
				FamAssort famass = new FamAssort();
				famass.setId(rs.getString("idfamass"));
				famass.setDescrizione(rs.getString("descr_fam"));
				articoli.setFamAssort(famass);
				
				Iva iva = new Iva();
				iva.setIdIva(rs.getString("idiva")); 
				iva.setDescrizione(rs.getString("descr_iva"));
				iva.setAliquota(rs.getString("aliquota"));
				articoli.setIva(iva);
				
				Barcode barcode = new Barcode();
				barcode.setBarcode(rs.getString("barcode_b"));
				barcode.setIdTipoArt(rs.getString("bar_idtipoart"));
				articoli.setBarcode(barcode);
				
				Ingredienti ingredienti = new Ingredienti();
				ingredienti.setCodArt(rs.getString("codart_ingr"));
				ingredienti.setInfo(rs.getString("info_ingr"));
				articoli.getIngredienti().add(ingredienti);
				
				listaArticoli.add(articoli);

			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return listaArticoli;
	}

	@Override
	public Articoli getById(String id) {
		
		Articoli art = null;

		try {
			
			Connection conn = ds.getConnection();

			String query = "SELECT a.codart AS codart_art, a.codstat, a.datacreazione, a.descrizione AS descr_art, "
		             + "a.idstatoart, a.pesonetto, a.pzcart, a.um, a.idfamass, a.idiva, b.codart AS codart_bar, b.barcode AS barcode_b, "
		             + "f.descrizione AS descr_fam, iva.descrizione AS descr_iva, aliquota, b.idtipoart as bar_idtipoart, i.codart AS codart_ingr, "
		             + "i.info AS info_ingr "
		             + "FROM articoli a "
		             + "INNER JOIN famassort f ON a.idfamass = f.id "
		             + "INNER JOIN iva on iva.idiva = a.idiva "
					 + "LEFT JOIN barcode b ON b.codart = a.codart "
					 + "LEFT JOIN ingredienti i ON i.articolo_codart = a.codart "
					 + "WHERE a.codart = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				art = new Articoli();
				art.setCodArt(rs.getString("codart_art"));
				art.setCodStat(rs.getString("codstat"));
				art.setDataCreaz(rs.getDate("datacreazione"));
				art.setDescrizione(rs.getString("descr_art"));
				art.setIdStatoArt(rs.getString("idstatoart"));
				art.setPesoNetto(rs.getDouble("pesonetto"));
				art.setPzCart(rs.getInt("pzcart"));
				art.setUm(rs.getString("um"));
				
				FamAssort famass = new FamAssort();
				famass.setId(rs.getString("idfamass"));
				famass.setDescrizione(rs.getString("descr_fam"));
				art.setFamAssort(famass);
				
				Iva iva = new Iva();
				iva.setIdIva(rs.getString("idiva")); 
				iva.setDescrizione(rs.getString("descr_iva"));
				iva.setAliquota(rs.getString("aliquota"));
				art.setIva(iva);
				
				Barcode barcode = new Barcode();
				barcode.setBarcode(rs.getString("barcode_b"));
				barcode.setIdTipoArt(rs.getString("bar_idtipoart"));
				art.setBarcode(barcode);
				
				Ingredienti ingredienti = new Ingredienti();
				ingredienti.setCodArt(rs.getString("codart_ingr"));
				ingredienti.setInfo(rs.getString("info_ingr"));
				art.getIngredienti().add(ingredienti);

			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return art;
	}

	@Override
	public boolean Insert(Articoli obj) {
		boolean result = false;

		try {
			
			Connection conn = ds.getConnection();

			String query = "INSERT INTO articoli (codart, codstat, datacreazione, descrizione, idstatoart, pesonetto, pzcart, um, idfamass, idiva)"
					+ " VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getCodArt());
			ps.setString(2, obj.getCodStat());
			ps.setDate(3, obj.getDataCreaz());
			ps.setString(4, obj.getDescrizione());
			ps.setString(5, obj.getIdStatoArt());
			ps.setDouble(6, obj.getPesoNetto());
			ps.setInt(7, obj.getPzCart());
			ps.setString(8, obj.getUm());
			ps.setString(9, obj.getFamAssort().getId());
			ps.setString(10, obj.getIva().getIdIva());


			int affRows = ps.executeUpdate();

			if (affRows > 0)
				result = true;

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean Delete(String id) {

		boolean result = false;

		try {

			Connection conn = ds.getConnection();
			
			String query = "DELETE FROM articoli WHERE codart = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);

			int affRows = ps.executeUpdate();

			if (affRows > 0)
				result = true;

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean Update(Articoli obj) {
	    boolean result = false;
	    try {
	    	
	    	Connection conn = ds.getConnection();

	        String id = obj.getCodArt();
	        Articoli art = this.getById(id); // Recupero i dati attuali dal DB

	        if (art != null) {

	            art.setCodStat(obj.getCodStat() == null ? art.getCodStat() : obj.getCodStat());
	            art.setDataCreaz(obj.getDataCreaz() == null ? art.getDataCreaz() : obj.getDataCreaz());
	            art.setDescrizione(obj.getDescrizione() == null ? art.getDescrizione() : obj.getDescrizione());
	            art.setIdStatoArt(obj.getIdStatoArt() == null ? art.getIdStatoArt() : obj.getIdStatoArt());
	            art.setPesoNetto(obj.getPesoNetto() == 0.000 ? art.getPesoNetto() : obj.getPesoNetto()); 
	            art.setPzCart(obj.getPzCart() == 0 ? art.getPzCart() : obj.getPzCart());
	            art.setUm(obj.getUm() == null ? art.getUm() : obj.getUm());
	            art.setFamAssort(obj.getFamAssort() == null ? art.getFamAssort() : obj.getFamAssort());
	            art.setIva(obj.getIva() == null ? art.getIva() : obj.getIva());

	            String query = "UPDATE articoli SET codstat = ?, datacreazione = ?, descrizione = ?, "
	                         + "idstatoart = ?, pesonetto = ?, pzcart = ?, um = ?, idfamass = ?, idiva = ? "
	                         + "WHERE codart = ? ";

	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, art.getCodStat());
	            ps.setDate(2, art.getDataCreaz());
	            ps.setString(3, art.getDescrizione());
	            ps.setString(4, art.getIdStatoArt());
	            ps.setDouble(5, art.getPesoNetto());            
	            ps.setInt(6, art.getPzCart());
	            ps.setString(7, art.getUm());
	            ps.setString(8, (art.getFamAssort() != null) ? art.getFamAssort().getId() : null);
	            ps.setString(9, (art.getIva() != null) ? art.getIva().getIdIva() : "0");           
	            ps.setString(10, art.getCodArt());

	            int affRows = ps.executeUpdate();
	            if (affRows > 0) result = true;
	        }
	        conn.close();
	    } catch (SQLException e) {
	        System.out.println("Errore Update: " + e.getMessage());
	    }
	    return result;
	}

}
