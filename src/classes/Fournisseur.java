package classes;

/** Fournisseur de Véhicule */
public class Fournisseur {
  // ________________________ Attributes ________________________

  private String nom;
  private String adresse;
  private String telephone;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public Fournisseur() {}

  /** Constructeur complet */
  public Fournisseur(String nom, String adresse, String telephone) {
    this.nom = nom;
    this.adresse = adresse;
    this.telephone = telephone;
  }

  // ________________________ Accesseurs ________________________

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      ", nom='" +
      getNom() +
      "'" +
      ", adresse='" +
      getAdresse() +
      "'" +
      ", telephone='" +
      getTelephone() +
      "'" +
      "}"
    );
  }
}
