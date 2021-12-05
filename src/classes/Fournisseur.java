package classes;

/** Fournisseur de Vehicule */
public class Fournisseur {
  // ________________________ Attributes

  private String nomComplet;
  private String adresse;
  private String telephone;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public Fournisseur() {}

  /** Constructeur complet */
  public Fournisseur(String nomComplet, String adresse, String telephone) {
    this.nomComplet = nomComplet;
    this.adresse = adresse;
    this.telephone = telephone;
  }

  // ________________________ Accesseurs

  public String getNomComplet() {
    return this.nomComplet;
  }

  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
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

  // ________________________ Methodes

  @Override
  public String toString() {
    return nomComplet + " (" + telephone + ")";
  }
}
