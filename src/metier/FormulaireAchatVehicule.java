package metier;

import java.util.Map;
import model.FormulaireAchatVehiculeModel;

public interface FormulaireAchatVehicule {
  /** Ajouter un nouveau Formulaire d'achat */
  public void ajouterNouveauFormulaireAchat(
    FormulaireAchatVehiculeModel FormulaireAchatVehiculeModel
  );

  public Map rechercheCollectionFormulaireAchatNonFinalise();

  /** Confirmer et finaliser l'achat */
  public void finaliserAchat(
    FormulaireAchatVehiculeModel formulaireAchatVehiculeModel
  );
}
