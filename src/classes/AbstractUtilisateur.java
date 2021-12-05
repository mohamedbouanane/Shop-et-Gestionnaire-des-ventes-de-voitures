package classes;

/**
 * Classe d'authentification à l'application
 */
public abstract class AbstractUtilisateur {
  // ________________________ Attributs

  private String identifiant;
  private String motDePasse;

  // ________________________ Constructeurs

  /** Constructeur vide */
  public AbstractUtilisateur() {}

  /** Constructeur complet */
  public AbstractUtilisateur(String identifiant, String motDePasse) {
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
  }

  // ________________________ Accesseurs

  /**
   * @return String return the identifiant
   */
  public String getIdentifiant() {
    return this.identifiant;
  }

  /**
   * @param identifiant the identifiant to set
   */
  public void setIdentifiant(String identifiant) {
    this.identifiant = identifiant;
  }

  /**
   * @return String return the motDePasse
   */
  public String getMotDePasse() {
    return this.motDePasse;
  }

  /**
   * @param motDePasse the motDePasse to set
   */
  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  // ________________________ Methodes

  @Override
  public String toString() {
    return (identifiant + "\t\t" + motDePasse);
  }
}
