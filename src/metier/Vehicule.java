package metier;

import java.util.Map;
import model.VehiculeModel;

public interface Vehicule {
  public VehiculeModel rechercheVehiculeParId(Long id);

  public Map<Integer, VehiculeModel> retourVehiculesNonVendue();

  public void ajouterNouveauVehicule(VehiculeModel vehiculeModel);

  public void modifierUnVehicule(
    Long idVehicule,
    VehiculeModel nouveauxDonneevehiculeModel
  );

  public void supprimerUnVehicule(VehiculeModel vehiculeModel);
}
