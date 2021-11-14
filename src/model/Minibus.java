package model;

/** Minibus class héritante de la class Vehicule*/
public class Minibus extends Vehicule {
  private Integer nbrChaises;

  public Minibus() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  public Minibus(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    Integer nbrChaises,
    Carburant carburant,
    Double prixVente,
    Double prixAchat,
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
