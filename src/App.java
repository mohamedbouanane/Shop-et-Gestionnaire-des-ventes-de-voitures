import java.util.HashMap;
import java.util.Map;
import model.UtilisateurModel;

/** Class Main */
public class App {
  // TODO : confirmer le type de la liste
  public static final Map<Integer, UtilisateurModel> collectionUtilisateur = new HashMap<>();

  public static void main(String[] args) throws Exception {
    // Création d'un utilisateur de base
    UtilisateurModel utilisateur = new UtilisateurModel("user", "pass");
    collectionUtilisateur.putIfAbsent(1, utilisateur);

    System.out.println("Utilisateur par défaut créé!");
  }
}
