package com.xantrix.webapp.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ARTICOLI")
@Getter
@Setter
@NoArgsConstructor
public class Articoli 
{
	@Id
	@Column(name = "codart")
	private String codArt;
	
	@Column(name = "descrizione")
	private String descrizione;	
	
	@Column(name = "um")
	private String um;
	
	@Column(name = "codstat")
	private String codStat;
	
	@Column(name = "pzcart", nullable = false)
	private int pzCart;
	
	@Column(name = "pesonetto")
	private double pesoNetto;
	
	@Column(name = "idstatoart")
	private String idStatoArt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datacreazione")
	private Date dataCreaz;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "articolo", orphanRemoval = true)
	private Barcode barcode;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "articolo", orphanRemoval = true)
	private Set<Ingredienti> ingredienti = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "idiva",  referencedColumnName = "idiva")
	private Iva iva;
	
	@ManyToOne
	@JoinColumn(name = "idfamass", referencedColumnName = "id", nullable = false)
	private FamAssort famAssort;
	
}
