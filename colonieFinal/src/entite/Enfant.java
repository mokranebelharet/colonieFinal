package entite;

import java.util.Calendar;
import java.util.Date;

public class Enfant {

	// Attributs
	protected Integer id;
	protected String nomEnfant;
	protected String prenomEnfant;
	protected Date ddnEnfant;
	protected Atelier inscrit;

	// Constructeurs
	public Enfant() {
	}

	public Enfant(String nomEnfant, String prenomEnfant, Date ddnEnfant) {
		super();
		this.nomEnfant = nomEnfant;
		this.prenomEnfant = prenomEnfant;
		this.ddnEnfant = ddnEnfant;
	}

	public Integer getAge() {
		Integer result = 0;

		Calendar dsaCal = Calendar.getInstance();
		Integer anneeA = dsaCal.get(Calendar.YEAR);

		Calendar dsnCal = Calendar.getInstance();
		dsnCal.setTime(this.ddnEnfant);
		Integer anneeN = dsnCal.get(Calendar.YEAR);

		result = anneeA - anneeN;
		return result;
	}

	// Accesseurs
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEnfant() {
		return nomEnfant;
	}

	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}

	public String getPrenomEnfant() {
		return prenomEnfant;
	}

	public void setPrenomEnfant(String prenomEnfant) {
		this.prenomEnfant = prenomEnfant;
	}

	public Date getDdnEnfant() {
		return ddnEnfant;
	}

	public void setDdnEnfant(Date ddnEnfant) {
		this.ddnEnfant = ddnEnfant;
	}

	// To string
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enfant [id=");
		builder.append(id);
		builder.append(", nomEnfant=");
		builder.append(nomEnfant);
		builder.append(", prenomEnfant=");
		builder.append(prenomEnfant);
		builder.append(", ddnEnfant=");
		builder.append(ddnEnfant);
		builder.append("]");
		return builder.toString();
	}
}
