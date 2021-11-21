package classes;

/** Minibus class héritante de la class Vehicule*/
public class Minibus extends AbstractVehicule {
  // ________________________ Attributs ________________________

  private Integer nbrChaises;

  /** Constructeur vide */
  public Minibus() {
    super(); // Fait appel au constructeur vide de la classe mère
  }

  /** Constructeur complet */
  public Minibus(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
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
      prixVente,
      prixAchat,
      fournisseur
    ); // Fait appel au constructeur complet de la classe mère
    this.nbrChaises = nbrChaises;
  }

  // ________________________ Accesseurs ________________________

  public Integer getNbrChaises() {
    return this.nbrChaises;
  }

  public void setNbrChaises(Integer nbrChaises) {
    this.nbrChaises = nbrChaises;
  }

  // ________________________ ToString _______________________

  @Override
  public String toString() {
    return "{" + " nbrChaises='" + getNbrChaises() + "'" + "}";
  }
}
