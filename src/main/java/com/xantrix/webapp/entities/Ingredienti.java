package com.xantrix.webapp.entities;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INGREDIENTI")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredienti  
{	
	@Id
	@Column(name = "codart")
	private String codArt;
	
	@Column(name = "info")
	private String info;
	
	@ManyToOne
	@JsonIgnoreProperties("ingredienti")
	@PrimaryKeyJoinColumn
	private Articoli articolo;

    
}
