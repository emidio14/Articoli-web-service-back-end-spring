package com.xantrix.webapp.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IVA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Iva 
{
	@Id
	@Column(name = "idiva")
	private String idIva;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "aliquota")
	private String aliquota;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "iva")
	@JsonIgnoreProperties("iva")
	@JsonIgnore
	private Set<Articoli> articoli = new HashSet<>();
	
}
