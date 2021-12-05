package classes;

/**
 * Classe d'abstraction pour les Vehicules du magasin
 */
public abstract class AbstractVehicule {
  // ________________________ Attributes

  private String nom;
  private String immatriculation;
  private String marque;
  private Integer puissance; // Cheveaux
  private String couleur;
  private EnumCarburant carburant;
  private Double prixVente; // en £
  private Double prixAchat; // en £
  private Fournisseur fournisseur;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public AbstractVehicule() {}

  /** Constructeur complet */
  public AbstractVehicule(
    String nom,
    String immatriculation,
    String marque,
    Integer puissance,
    String couleur,
    EnumCarburant carburant,
    Double prixAchat,
    Double prixVente,
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

  // ________________________ Accesseurs

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

  public Integer getPuissance() {
    return this.puissance;
  }

  public void setPuissance(Integer puissance) {
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

  // ________________________ Methodes

  @Override
  public String toString() {
    return (
      marque +
      " " +
      nom +
      "\t" +
      immatriculation +
      "\t" +
      puissance +
      "\t" +
      couleur +
      "\t" +
      carburant +
      "\t" +
      prixAchat +
      "\t" +
      prixVente +
      "\t" +
      fournisseur.toString()
    );
  }
}
