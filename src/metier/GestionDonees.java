package metier;

public interface GestionDonees {
  /** Sauvegarder les Données dans un fichier cible */
  public void sauvegarder(String chemainFichier);

  /** Restaurer les Données à partir d'un fichier source */
  public void restaurer(String chemainFichier);
}
