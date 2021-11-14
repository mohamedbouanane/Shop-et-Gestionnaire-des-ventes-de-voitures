package model;

/**
 * Classe d'abstraction pour les Véhicules du magasin
 */
public abstract class VehiculeModel {
  // ________________________ Attributes ________________________

  /** Variable d'incrémentation pour les identifiants de cette classe */
  private static Long cptIdVehicule = 0L;

  private Long idVehicule;
  private String nom;
  private String immatriculation;
  private String marque;
  private String puissance;
  private String couleur;
  private Carburant carburant;
  private Double prixVente;
  private Double prixAchat;
  private FournisseurModel fournisseur;

  // ________________________ Constructeurs ________________________

  /** Constructeur avec just l'identifiant incrémenté */
  public VehiculeModel() {
    this.idVehicule = cptIdVehicule++;
  }

  /** Constructeur sans identifiant (ce dernier se génére automatiquement) */
  public VehiculeModel(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    Carburant carburant,
    Double prixVente,
    Double prixAchat,
    FournisseurModel fournisseur
  ) {
    this(); // fait appel au constructeur 'Vehicule()' de cette classe à fin d'incrémenter l'identifiant et définir 'idVehicule' de l'objet en cours
    this.nom = nom;
    this.immatriculation = immatriculation;
    this.marque = marque;
    this.puissance = puissance;
    this.couleur = couleur;
    this.carburant = carburant;
    this.prixVente = prixVente;
    this.prixAchat = prixAchat;
    this.fournisseur = fournisseur;
  }

  // ________________________ Accesseurs ________________________

  public Long getIdVehicule() {
    return this.idVehicule;
  }

  public void setIdVehicule(Long idVehicule) {
    this.idVehicule = idVehicule;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getImmatriculation() {
    return this.immatriculation;
  }

  public void setImmatriculation(String immatriculation) {
    this.immatriculation = immatriculation;
  }

  public String getMarque() {
    return this.marque;
  }

  public void setMarque(String marque) {
    this.marque = marque;
  }

  public String getPuissance() {
    return this.puissance;
  }

  public void setPuissance(String puissance) {
    this.puissance = puissance;
  }

  public String getCouleur() {
    return this.couleur;
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

  public Carburant getCarburant() {
    return this.carburant;
  }

  public void setCarburant(Carburant carburant) {
    this.carburant = carburant;
  }

  public Double getPrixVente() {
    return this.prixVente;
  }

  public void setPrixVente(Double prixVente) {
    this.prixVente = prixVente;
  }

  public Double getPrixAchat() {
    return this.prixAchat;
  }

  public void setPrixAchat(Double prixAchat) {
    this.prixAchat = prixAchat;
  }

  public FournisseurModel getFournisseur() {
    return this.fournisseur;
  }

  public void setFournisseur(FournisseurModel fournisseur) {
    this.fournisseur = fournisseur;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " idVehicule='" +
      getIdVehicule() +
      "'" +
      ", nom='" +
      getNom() +
      "'" +
      ", immatriculation='" +
      getImmatriculation() +
      "'" +
      ", marque='" +
      getMarque() +
      "'" +
      ", puissance='" +
      getPuissance() +
      "'" +
      ", couleur='" +
      getCouleur() +
      "'" +
      ", carburant='" +
      getCarburant() +
      "'" +
      ", prixVente='" +
      getPrixVente() +
      "'" +
      ", prixAchat='" +
      getPrixAchat() +
      "'" +
      ", fournisseur='" +
      getFournisseur() +
      "'" +
      "}"
    );
  }
  // ________________________ Constructeurs ________________________

}
