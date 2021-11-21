package classes;

/** MiniForgonnette class héritante de la class Vehicule*/
public class Suv4x4 extends AbstractVehicule {
  // ________________________ Attributs ________________________

  private Integer poidMaxChargmenKg;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public Suv4x4() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  /** Constructeur complet */
  public Suv4x4(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    EnumCarburant carburant,
    Double prixVente,
    Double prixAchat,
    Integer poidMaxChargmenKg,
    Fournisseur fournisseur
  ) {
    super(
      nom,
      immatriculation,
      marque,
      puissance,
      couleur,
      carburant,
      prixVente,
      prixAchat,
      fournisseur
    ); // Fait appel au constructeur complet de la classe mère
    this.poidMaxChargmenKg = poidMaxChargmenKg;
  }

  // ________________________ Accesseurs ________________________

  public Integer getPoidMaxChargmenKg() {
    return this.poidMaxChargmenKg;
  }

  public void setPoidMaxChargmenKg(Integer poidMaxChargmenKg) {
    this.poidMaxChargmenKg = poidMaxChargmenKg;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return "{" + " poidMaxChargmenKg='" + getPoidMaxChargmenKg() + "'" + "}";
  }
}
