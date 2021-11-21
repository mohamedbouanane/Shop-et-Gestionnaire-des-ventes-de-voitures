package classes;

public class Acheteur extends AbstractUtilisateur {
  private String nom;
  private String prenom;
  private String email;
  private String telephone;
  private String adresse;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public Acheteur() {
    super();
  }

  /** Constructeur d'héritage */
  public Acheteur(String identifiant, String motDePasse) {
    super(identifiant, motDePasse);
  }

  /** Constructeur complet */
  public Acheteur(
    String nom,
    String prenom,
    String email,
    String telephone,
    String adresse
  ) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.telephone = telephone;
    this.adresse = adresse;
  }

  // ________________________ Accesseurs ________________________

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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " nom='" +
      getNom() +
      "'" +
      ", prenom='" +
      getPrenom() +
      "'" +
      ", email='" +
      getEmail() +
      "'" +
      ", telephone='" +
      getTelephone() +
      "'" +
      ", adresse='" +
      getAdresse() +
      "'" +
      "}"
    );
  }
}
