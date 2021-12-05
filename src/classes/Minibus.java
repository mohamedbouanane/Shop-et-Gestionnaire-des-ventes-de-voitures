package classes;

/** Minibus class heritante de la class Vehicule*/
public class Minibus extends AbstractVehicule {
  // ________________________ Attributs

  private Integer nbrChaises;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public Minibus() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  /** Constructeur complet */
  public Minibus(
    String nom,
    String immatriculation,
    String marque,
    Integer puissance,
    String couleur,
    Integer nbrChaises,
    EnumCarburant carburant,
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
      prixAchat,
      prixVente,
      fournisseur
    ); // Fait appel au constructeur complet de la classe mère
    this.nbrChaises = nbrChaises;
  }

  // ________________________ Accesseurs

  public Integer getNbrChaises() {
    return this.nbrChaises;
  }

  public void setNbrChaises(Integer nbrChaises) {
    this.nbrChaises = nbrChaises;
  }

  // ________________________ Methodes

  @Override
  public String toString() {
    return "{" + " nbrChaises='" + getNbrChaises() + "'" + "}";
  }
}
