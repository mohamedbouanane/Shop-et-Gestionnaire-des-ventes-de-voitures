package model;

/**
 * Classe d'authentification à l'application
 */
public class Utilisateur {
  // ________________________ Attributes ________________________

  private String username;
  private String motDePasse;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  public Utilisateur() {}

  /** Constructeur complet */
  public Utilisateur(String username, String motDePasse) {
    this.username = username;
    this.motDePasse = motDePasse;
  }

  // ________________________ Accesseurs ________________________

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMotDePasse() {
    return this.motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public Utilisateur username(String username) {
    setUsername(username);
    return this;
  }

  public Utilisateur motDePasse(String motDePasse) {
    setMotDePasse(motDePasse);
    return this;
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      " username='" +
      getUsername() +
      "'" +
      ", motDePasse='" +
      getMotDePasse() +
      "'" +
      "}"
    );
  }
}
