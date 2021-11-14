package model;

/**
 * Ce Formulaire est remplie par le client l'ors de l'envoi d'une commande d'achat d'un Vehicule
 */
public class FormulaireAchatVehicule {
  // ________________________ Attributes ________________________

  /** Variable d'incrémentation pour les identifiants de cette classe */
  private static Long cptIdFormulaireAchat = 0L;

  // Identifiant pour le formulaire d'achat
  private Long idFormulaireAchat;
  private Vehicule véhicule;
  private String nomComplet;
  private String email;
  private String telephone;
  private Boolean achatFinalisé;

  // ________________________ Constructeurs ________________________

  /** Constructeur avec just l'identifiant incrémenté */
  public FormulaireAchatVehicule() {
    this.idFormulaireAchat = cptIdFormulaireAchat++;
  }

  /** Constructeur sans identifiant (ce dernier se génére automatiquement) */
  public FormulaireAchatVehicule(
    Vehicule véhicule,
    String nomComplet,
    String email,
    String telephone,
    Boolean achatFinalisé
  ) {
    this(); // fait appel au constructeur 'FormulaireAchatVehicule()' de cette classe à fin d'incrémenter et définir l'identifiant 'idFormulaireAchat' de l'objet en cours
    this.véhicule = véhicule;
    this.nomComplet = nomComplet;
    this.email = email;
    this.telephone = telephone;
    this.achatFinalisé = achatFinalisé;
  }

  // ________________________ Accesseurs ________________________

  public Long getIdFormulaireAchat() {
    return this.idFormulaireAchat;
  }

  public void setIdFormulaireAchat(Long idFormulaireAchat) {
    this.idFormulaireAchat = idFormulaireAchat;
  }

  public Vehicule getVéhicule() {
    return this.véhicule;
  }

  public void setVéhicule(Vehicule véhicule) {
    this.véhicule = véhicule;
  }

  public String getNomComplet() {
    return this.nomComplet;
  }

  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Boolean isAchatFinalisé() {
    return this.achatFinalisé;
  }

  public Boolean getAchatFinalisé() {
    return this.achatFinalisé;
  }

  public void setAchatFinalisé(Boolean achatFinalisé) {
    this.achatFinalisé = achatFinalisé;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " idFormulaireAchat='" +
      getIdFormulaireAchat() +
      "'" +
      ", véhicule='" +
      getVéhicule() +
      "'" +
      ", nomComplet='" +
      getNomComplet() +
      "'" +
      ", email='" +
      getEmail() +
      "'" +
      ", telephone='" +
      getTelephone() +
      "'" +
      ", achatFinalisé='" +
      isAchatFinalisé() +
      "'" +
      "}"
    );
  }
}
