package model;

/** PickUp class héritante de la class Vehicule*/
public class PickUpModel extends VehiculeModel {
  private Short nbrPhareSurPlafond;

  public PickUpModel() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  public PickUpModel(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    Short nbrPhareSurPlafond,
    Carburant carburant,
    Double prixVente,
    Double prixAchat,
    FournisseurModel fournisseur
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
    this.nbrPhareSurPlafond = nbrPhareSurPlafond;
  }

  public Short getNbrPhareSurPlafond() {
    return this.nbrPhareSurPlafond;
  }

  public void setNbrPhareSurPlafond(Short nbrPhareSurPlafond) {
    this.nbrPhareSurPlafond = nbrPhareSurPlafond;
  }

  @Override
  public String toString() {
    return "{" + " nbrPhareSurPlafond='" + getNbrPhareSurPlafond() + "'" + "}";
  }
}
