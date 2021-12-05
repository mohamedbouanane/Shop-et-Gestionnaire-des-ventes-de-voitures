package classes;

import java.util.Map;

public interface InterfaceMagasin {
  // ________________________ Accesseurs

  public String getNomMagasin();

  public void setNomMagasin(String nom);

  public Map<Long, AbstractVehicule> getCollectionVehicules();

  public Map<Long, AbstractUtilisateur> getCollectionUtilisateurs();

  public Map<Long, FormulaireAchatVehicule> getCollectionFormulaireAchatVehicules();

  /** Retourne l'utilisateur connecté */
  public AbstractUtilisateur getUtilisateurEnCours();

  public void setUtilisateurEnCours(AbstractUtilisateur abstractUtilisateur);

  // ________________________ Méthodes

  /*
   * Retourne le montant totale des depences
   * */
  public Double getDepences();

  /**
   * Retourne le montant totale des entrees d’argent
   */
  public Double getRevenus();

  /**
   * Retourne le montant totale des benefices
   */
  public Double getBenefices();

  /**
   * Ajouter un nouveau utilisateur
   */
  public void ajouterUtilisateur(AbstractUtilisateur utilisateur);

  /**
   * Ajouter un nouveau vehicule
   */
  public void ajouterVehicule(AbstractVehicule vehicule);

  /**
   * Modifier un vehicule
   */
  public void modifierVehicule(Long key, AbstractVehicule vehicule);

  /**
   * Supprimer un vehicule
   */
  public void supprimerVehicule(Long key);

  /**
   * Ajouter une nouvelle demande d achat d'un vehicule
   */
  public void ajouterDemandeAchat(FormulaireAchatVehicule formulaire);

  /**
   * Supprimer une demande d achat d'un vehicule
   */
  public void annulerDemandeAchat(Long key);

  /**
   * Retourne les vehicules disponible (pas encor vendue)
   */
  public Map<Long, AbstractVehicule> getVoituresEnVente();

  /**
   * Retourne les formulaires
   */
  public Map<Long, FormulaireAchatVehicule> getFormulairesCommandesAcheteur(
    Acheteur acheteur
  );
}
