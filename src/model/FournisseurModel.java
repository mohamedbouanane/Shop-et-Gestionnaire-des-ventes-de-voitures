package model;

/** Fournisseur de Véhicule */
public class FournisseurModel {
  // ________________________ Attributes ________________________

  /** Variable d'incrémentation pour les identifiants de cette classe */
  private static Long cptIdFournisseur = 0L;

  // Identifiant pour le fournisseur
  private Long idFournisseur;
  private String nomComplet;
  private String adresse;
  private String telephone;

  // ________________________ Constructeurs ________________________

  /** Constructeur avec just l'identifiant incrémenté */
  public FournisseurModel() {
    this.idFournisseur = cptIdFournisseur++;
  }

  /** Constructeur sans identifiant (ce dernier se génére automatiquement) */
  public FournisseurModel(String nomComplet, String adresse, String telephone) {
    this(); // fait appel au constructeur 'Fournisseur()' de cette classe à fin d'incrémenter et définir l'identifiant 'idFournisseur' de l'objet en cours
    this.nomComplet = nomComplet;
    this.adresse = adresse;
    this.telephone = telephone;
  }

  // ________________________ Accesseurs ________________________

  public Long getIdFournisseur() {
    return this.idFournisseur;
  }

  public void setIdFournisseur(Long idFournisseur) {
    this.idFournisseur = idFournisseur;
  }

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

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " idFournisseur='" +
      getIdFournisseur() +
      "'" +
      ", nomComplet='" +
      getNomComplet() +
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
