package it.lipari.academy.model.vo;

import java.util.Objects;

public abstract class Animal {

	private String codiceChip;
	private int zampe;
	private String nome;
	
	public abstract String faiIlVerso();

	public abstract void foo();

	public int getZampe() {
		return zampe;
	}

	public void setZampe(int zampe) {
		this.zampe = zampe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceChip() {
		return codiceChip;
	}

	public void setCodiceChip(String codiceChip) {
		this.codiceChip = codiceChip;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceChip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Animal)) {
			return false;
		}
		Animal other = (Animal) obj;
		return Objects.equals(codiceChip, other.codiceChip);
	}
	
	
	
}
