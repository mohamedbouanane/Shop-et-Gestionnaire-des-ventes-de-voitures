package classes;

/**
 * Classe d'authentification à l'application
 */
public abstract class AbstractUtilisateur {
  // ________________________ Attributs ________________________

  private String identifiant;
  private String motDePasse;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public AbstractUtilisateur() {}

  /** Constructeur complet */
  public AbstractUtilisateur(String identifiant, String motDePasse) {
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
  }

  // ________________________ Accesseurs ________________________

  public String getIdentifiant() {
    return this.identifiant;
  }

  public void setIdentifiant(String identifiant) {
    this.identifiant = identifiant;
  }

  public String getMotDePasse() {
    return this.motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " username='" +
      getIdentifiant() +
      "'" +
      ", motDePasse='" +
      getMotDePasse() +
      "'" +
      "}"
    );
  }
}
