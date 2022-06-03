package cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.domain;


import javax.persistence.*;


@Entity
@Table (name="fruites")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name="nom")
	private String nom;
	@Column (name="quantitatEnKg")
	private int quantitatKg;
	
	public Fruita(){}
	
	public Fruita(String nom, int id, int quantitatKg) {
		this.nom=nom;
		this.id=id;
		this.quantitatKg=quantitatKg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantitatKg() {
		return quantitatKg;
	}
	public void setQuantitatKg(int quantitatKg) {
		this.quantitatKg = quantitatKg;
	}
	
	public String toString() {
		return "La fruita "+nom+" amb ID "+id+", té "+quantitatKg+"kg." ;
	}
	

}
