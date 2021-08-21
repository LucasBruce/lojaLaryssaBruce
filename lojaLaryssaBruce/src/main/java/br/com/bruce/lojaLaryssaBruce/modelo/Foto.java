package br.com.bruce.lojaLaryssaBruce.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeFoto1;
	private String nomeFoto2;
	private String nomeFoto3;
	private String nomeFoto4;
	private String nomeFoto5;
	private String nomeFoto6;

	public String getNomeFoto6() {
		return nomeFoto6;
	}

	public void setNomeFoto6(String nomeFoto6) {
		this.nomeFoto6 = nomeFoto6;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFoto1() {
		return nomeFoto1;
	}

	public void setNomeFoto1(String nomeFoto1) {
		this.nomeFoto1 = nomeFoto1;
	}

	public String getNomeFoto2() {
		return nomeFoto2;
	}

	public void setNomeFoto2(String nomeFoto2) {
		this.nomeFoto2 = nomeFoto2;
	}

	public String getNomeFoto3() {
		return nomeFoto3;
	}

	public void setNomeFoto3(String nomeFoto3) {
		this.nomeFoto3 = nomeFoto3;
	}

	public String getNomeFoto4() {
		return nomeFoto4;
	}

	public void setNomeFoto4(String nomeFoto4) {
		this.nomeFoto4 = nomeFoto4;
	}

	public String getNomeFoto5() {
		return nomeFoto5;
	}

	public void setNomeFoto5(String nomeFoto5) {
		this.nomeFoto5 = nomeFoto5;
	}

}
