package classes;

/**
 * Ce Formulaire est remplie par le client lors de l'envoi d'une commande d'achat d'un Vehicule
 */
public class FormulaireAchatVehicule {
  // ________________________ Attributes ________________________

  private AbstractVehicule vehicule;
  private Acheteur acheteur;
  private Boolean achatFinalise; // si true : L'achat de la voiture est donc confirmé

  // ________________________ Constructeurs ________________________

  /** Constructeur avec just l'identifiant incrémenté */
  public FormulaireAchatVehicule() {}

  /** Constructeur sans identifiant (ce dernier se génère automatiquement) */
  public FormulaireAchatVehicule(
    AbstractVehicule vehicule,
    Acheteur acheteur,
    Boolean achatFinalise
  ) {
    this.vehicule = vehicule;
    this.acheteur = acheteur;
    this.achatFinalise = achatFinalise;
  }

  // ________________________ Accesseurs ________________________

  public Acheteur getAcheteur() {
    return this.acheteur;
  }

  public void setAcheteur(Acheteur acheteur) {
    this.acheteur = acheteur;
  }

  public AbstractVehicule getVehicule() {
    return this.vehicule;
  }

  public void setVehicule(AbstractVehicule vehicule) {
    this.vehicule = vehicule;
  }

  public Boolean getIsAchatFinalise() {
    return this.achatFinalise;
  }

  public void setIsAchatFinalise(Boolean achatFinalise) {
    this.achatFinalise = achatFinalise;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " vehicule='" +
      getVehicule() +
      "'" +
      ", acheteur='" +
      getAcheteur() +
      "'" +
      ", achatFinalise='" +
      getIsAchatFinalise() +
      "'" +
      "}"
    );
  }
}
