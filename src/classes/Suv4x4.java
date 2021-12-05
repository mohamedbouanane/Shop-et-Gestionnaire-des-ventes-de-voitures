package classes;

/** MiniForgonnette class heritante de la class Vehicule*/
public class Suv4x4 extends AbstractVehicule {
  // ________________________ Attributs

  private Integer poidMaxChargmenKg;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public Suv4x4() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  /** Constructeur complet */
  public Suv4x4(
    String nom,
    String immatriculation,
    String marque,
    Integer puissance,
    String couleur,
    EnumCarburant carburant,
    Double prixAchat,
    Double prixVente,
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

  // ________________________ Accesseurs

  public Integer getPoidMaxChargmenKg() {
    return this.poidMaxChargmenKg;
  }

  public void setPoidMaxChargmenKg(Integer poidMaxChargmenKg) {
    this.poidMaxChargmenKg = poidMaxChargmenKg;
  }

  // ________________________ Methodes

  @Override
  public String toString() {
    return "{" + " poidMaxChargmenKg='" + getPoidMaxChargmenKg() + "'" + "}";
  }
}
