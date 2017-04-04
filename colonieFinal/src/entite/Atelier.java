package entite;

import java.util.Date;

public class Atelier {
	protected Integer numAtelier;
	protected Enfant idEnfant;
	protected Integer nbMaxEnfant;
	protected String nomAtelier;
	protected Date dateDebut;
	protected Date dateFin;
	protected Integer ageLimite;

	// Constructeurs

	public Atelier() {
	}

	public Atelier(Integer nbMaxEnfant, String nomAtelier, Date dateDebut, Date dateFin, Integer ageLimite) {
		super();
		this.nbMaxEnfant = nbMaxEnfant;
		this.nomAtelier = nomAtelier;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ageLimite = ageLimite;
	}

	// methodes
	/**
	 * methode qui limite le nombre de personne dans un atelier
	 * 
	 * @return boolean
	 */
//	protected Boolean nbLimit(Enfant enf) {
//		Boolean limiteAtteinte = false;
//		for ( iterable_element : iterable) {
//
//		}
//		if () {
//			limiteAtteinte = true;
//		}
//		return limiteAtteinte;
//	}

	// Accesseurs

	public Integer getNumAtelier() {
		return numAtelier;
	}

	public void setNumAtelier(Integer numAtelier) {
		this.numAtelier = numAtelier;
	}

	public Enfant getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(Enfant idEnfant) {
		this.idEnfant = idEnfant;
	}

	public Integer getNbMaxEnfant() {
		return nbMaxEnfant;
	}

	public void setNbMaxEnfant(Integer nbMaxEnfant) {
		this.nbMaxEnfant = nbMaxEnfant;
	}

	public String getNomAtelier() {
		return nomAtelier;
	}

	public void setNomAtelier(String nomAtelier) {
		this.nomAtelier = nomAtelier;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getAgeLimite() {
		return ageLimite;
	}

	public void setAgeLimite(Integer ageLimite) {
		this.ageLimite = ageLimite;
	}

	// To string
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atelier [numAtelier=");
		builder.append(numAtelier);
		builder.append(", idEnfant=");
		builder.append(idEnfant);
		builder.append(", nbMaxEnfant=");
		builder.append(nbMaxEnfant);
		builder.append(", nomAtelier=");
		builder.append(nomAtelier);
		builder.append(", dateDebut=");
		builder.append(dateDebut);
		builder.append(", dateFin=");
		builder.append(dateFin);
		builder.append(", ageLimite=");
		builder.append(ageLimite);
		builder.append("]");
		return builder.toString();
	}
}
