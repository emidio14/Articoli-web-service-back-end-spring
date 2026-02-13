package com.xantrix.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "barcode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barcode 
{
	@Id
	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "idtipoart")
	private String idTipoArt;
	
	@OneToOne
	@JoinColumn(name = "codart", referencedColumnName = "codart")
	@JsonIgnoreProperties("barcode")
	@JsonIgnore
	private Articoli articolo;

}
