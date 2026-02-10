package com.xantrix.webapp.entities;

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
@Table(name = "BARCODE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barcode 
{
	@Id
	@Column(name = "BARCODE")
	private String barcode;
	
	@Column(name = "IDTIPOART")
	private String idTipoArt;
	
	@OneToOne
	@JoinColumn(name = "codart", referencedColumnName = "codart")
	@JsonIgnoreProperties("barcode")
	private Articoli articolo;

}
