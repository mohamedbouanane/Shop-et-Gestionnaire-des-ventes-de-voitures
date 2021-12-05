package classes;

public class Acheteur extends AbstractUtilisateur {
  private String nom;
  private String prenom;
  private String telephone;
  private String adresse;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public Acheteur() {
    super();
  }

  /** Constructeur complet */
  public Acheteur(
    String nom,
    String prenom,
    String telephone,
    String adresse,
    String email,
    String motDePasse
  ) {
    super(email, motDePasse);
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.adresse = adresse;
  }

  // ________________________ Accesseurs

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  // ________________________ Methodes

  @Override
  public String toString() {
    return super.toString();
  }
}
