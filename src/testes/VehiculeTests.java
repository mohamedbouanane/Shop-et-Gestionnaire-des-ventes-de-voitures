package testes;

import classes.AbstractUtilisateur;
import classes.Concessionaire;

/**
 * Classe Test pour Vehicule
 */
public class VehiculeTests {

  // Teste de saisie de saisie de données
  public void insertionDeDonnéesDeTeste() {
    // Création d'un utilisateur par défaut
    AbstractUtilisateur utilisateur = new Concessionaire(
      "user",
      "pass",
      "DESFSEF"
    );
    //Main.collectionUtilisateur.putIfAbsent(1, utilisateur);
  }
}
