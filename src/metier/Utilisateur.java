package metier;

public interface Utilisateur {
  public void creerNouveauUtilisateur(Utilisateur utilisateur);

  /** retourne true si le username et le mot de passe existent dans la base de données */
  public boolean validerAuthentification(Utilisateur utilisateur);
}
