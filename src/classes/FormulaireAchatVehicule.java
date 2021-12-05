package classes;

import java.util.Date;

/**
 * Ce Formulaire est remplie par le client lors de l'envoi d'une commande d'achat d'un Vehicule
 */
public class FormulaireAchatVehicule {
  // ________________________ Attributes

  private AbstractVehicule vehicule;
  private Acheteur acheteur;
  private Boolean achatFinalise = false; // si true : L'achat de la voiture est donc confirme
  private Date dateCommande;

  // ________________________ Constructeurs

  /** Constructeur avec just l'identifiant incremente */
  public FormulaireAchatVehicule() {}

  /** Constructeur sans identifiant (ce dernier se genère automatiquement) */
  public FormulaireAchatVehicule(
    AbstractVehicule vehicule,
    Acheteur acheteur,
    Date dateCommande
  ) {
    this.vehicule = vehicule;
    this.acheteur = acheteur;
    this.dateCommande = dateCommande;
  }

  // ________________________ Accesseurs

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

  public Date getDateCommande() {
    return this.dateCommande;
  }

  public void setDateCommande(Date dateCommande) {
    this.dateCommande = dateCommande;
  }

  // ________________________ Methodes

  @Override
  public String toString() {
    return (
      dateCommande +
      "\t" +
      acheteur.getNom() +
      " " +
      acheteur.getPrenom() +
      "\t" +
      acheteur.getTelephone() +
      "\t" +
      vehicule.getNom() +
      " " +
      vehicule.getMarque() +
      "\t" +
      vehicule.getPrixVente()
    );
  }
}
