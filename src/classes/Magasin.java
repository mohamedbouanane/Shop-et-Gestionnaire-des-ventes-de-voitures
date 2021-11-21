package classes;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Classe bilan sur les dépences et les revenus du magasin
 * Ces derniers sont calculés à partir des ajouts et des confirmations de ventes des véhicules
 */
public class Magasin {
  // ________________________ Attributs ________________________

  private static Magasin magasin;

  /** Variable d'incrémentation pour les identifiants des collections */
  private static Long cptIdVehicules = 0L;
  private static Long cptIdUtilisateur = 0L;
  private static Long cptIdFormulaireAchatVehicule = 0L;

  private String nom;

  /** Collection des véhicules du magasin
   * src doc : https://www.geeksforgeeks.org/treemap-in-java/
   */
  private Map<Long, AbstractVehicule> collectionVehicules;
  private Map<Long, AbstractUtilisateur> collectionUtilisateurs;
  private Map<Long, FormulaireAchatVehicule> collectionFormulaireAchatVehicules;

  // ________________________ Constructeurs ________________________

  /** Constructeur vide */
  private Magasin() {}

  /** Design pattern : singleton (Classe Magasin) */
  public static Magasin getInstance() {
    if (magasin == null) return new Magasin(); else return magasin;
  }

  // ________________________ Accesseurs ________________________

  /* Getter */
  public Map<Long, AbstractVehicule> getCollectionVehicules() {
    return this.collectionVehicules;
  }

  public Map<Long, AbstractUtilisateur> getCollectionUtilisateurs() {
    return this.collectionUtilisateurs;
  }

  public String getNom() {
    return this.nom;
  }

  /** Retourne le montant totale des dépences */
  public Double getDepences() {
    Double depences = 0d;
    for (Entry<Long, AbstractVehicule> vehicule : collectionVehicules.entrySet()) {
      depences += vehicule.getValue().getPrixAchat();
    }
    return depences;
  }

  /** Retourne le montant totale des entrées d’argent */
  public Double getRevenus() {
    Double revenus = 0d;
    for (Entry<Long, FormulaireAchatVehicule> formulaire : collectionFormulaireAchatVehicules.entrySet()) {
      if (formulaire.getValue().isAchatFinalise() == true) {
        revenus += formulaire.getValue().getVehicule().getPrixVente();
      }
    }
    return revenus;
  }

  /** Retourne le montant totale des benefices */
  public Double getBenefice() {
    return getRevenus() - getDepences();
  }

  /* Setter */
  public void setNom(String nom) {
    this.nom = nom;
  }

  // ________________________ Méthodes ________________________

  public void ajouterUtilisateur(AbstractUtilisateur utilisateur) {
    collectionUtilisateurs.put(cptIdUtilisateur, utilisateur);
    cptIdUtilisateur = cptIdUtilisateur + 1;
  }

  public void ajouterVehicule(AbstractVehicule vehicule) {
    collectionVehicules.put(cptIdVehicules, vehicule);
    cptIdVehicules = cptIdVehicules + 1;
  }

  public void ajouterDemandeAchat(FormulaireAchatVehicule formulaire) {
    collectionFormulaireAchatVehicules.put(
      cptIdFormulaireAchatVehicule,
      formulaire
    );
  }

  // ________________________ ToString ________________________

  @Override
  public String toString() {
    return (
      "{" +
      ", benefice='" +
      getBenefice() +
      "'" +
      ", collectionVehicules='" +
      getCollectionVehicules() +
      "'" +
      ", collectionUtilisateur='" +
      getCollectionUtilisateurs() +
      "'" +
      "}"
    );
  }
}
