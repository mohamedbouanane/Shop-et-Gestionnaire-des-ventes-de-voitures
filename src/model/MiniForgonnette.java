package model;

/** MiniForgonnette class héritante de la class Vehicule*/
public class MiniForgonnette extends Vehicule {
  private Integer poidMaxChargmenKg;

  public MiniForgonnette() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  public MiniForgonnette(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    Carburant carburant,
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

  public Integer getPoidMaxChargmenKg() {
    return this.poidMaxChargmenKg;
  }

  public void setPoidMaxChargmenKg(Integer poidMaxChargmenKg) {
    this.poidMaxChargmenKg = poidMaxChargmenKg;
  }

  @Override
  public String toString() {
    return "{" + " poidMaxChargmenKg='" + getPoidMaxChargmenKg() + "'" + "}";
  }
}
