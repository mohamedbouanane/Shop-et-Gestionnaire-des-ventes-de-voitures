package model;

/** Minibus class héritante de la class Vehicule*/
public class MinibusModel extends VehiculeModel {
  private Integer nbrChaises;

  public MinibusModel() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  public MinibusModel(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    Integer nbrChaises,
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
    this.nbrChaises = nbrChaises;
  }

  public Integer getNbrChaises() {
    return this.nbrChaises;
  }

  public void setNbrChaises(Integer nbrChaises) {
    this.nbrChaises = nbrChaises;
  }

  @Override
  public String toString() {
    return "{" + " nbrChaises='" + getNbrChaises() + "'" + "}";
  }
}
