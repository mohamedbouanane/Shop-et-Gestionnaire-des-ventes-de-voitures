package classes;

/**
 * Classe d'abstraction pour les Véhicules du magasin
 */
public abstract class AbstractVehicule {
  // ________________________ Attributes ________________________

  private String nom;
  private String immatriculation;
  private String marque;
  private String puissance;
  private String couleur;
  private EnumCarburant carburant;
  private Double prixVente;
  private Double prixAchat;
  private Fournisseur fournisseur;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public AbstractVehicule() {}

  /** Constructeur complet */
  public AbstractVehicule(
    String nom,
    String immatriculation,
    String marque,
    String puissance,
    String couleur,
    EnumCarburant carburant,
    Double prixVente,
    Double prixAchat,
    Fournisseur fournisseur
  ) {
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

  public EnumCarburant getCarburant() {
    return this.carburant;
  }

  public void setCarburant(EnumCarburant carburant) {
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

  public Fournisseur getFournisseur() {
    return this.fournisseur;
  }

  public void setFournisseur(Fournisseur fournisseur) {
    this.fournisseur = fournisseur;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
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
}
