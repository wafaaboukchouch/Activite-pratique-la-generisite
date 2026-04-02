import java.util.ArrayList;
import java.util.List;

// implements IMetier<Produit> = on dit : "Je vais réaliser le contrat IMetier pour des Produits"
public class MetierProduitImpl implements IMetier<Produit> {
    
    // Une liste pour stocker tous les produits
    private List<Produit> produits;
    
    // Constructeur : crée une liste vide et ajoute quelques produits pour tester
    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
        ajouterProduitsTest(); // On ajoute des exemples
    }
    
    // Méthode privée pour ajouter des produits de test
    private void ajouterProduitsTest() {
        produits.add(new Produit(1, "iPhone 14", "Apple", 9999.99, "Smartphone", 10));
        produits.add(new Produit(2, "Galaxy S23", "Samsung", 8999.99, "Smartphone Android", 15));
        produits.add(new Produit(3, "MacBook Pro", "Apple", 24999.99, "Ordinateur", 5));
    }
    
    // Ajouter un produit
    @Override
    public void add(Produit p) {
        // Vérifier si le produit n'existe pas déjà
        if (findById(p.getId()) == null) {
            produits.add(p);
            System.out.println("✅ Produit ajouté !");
        } else {
            System.out.println("❌ Un produit avec cet ID existe déjà !");
        }
    }
    
    // Récupérer tous les produits
    @Override
    public List<Produit> getAll() {
        return produits;
    }
    
    // Chercher un produit par son ID
    @Override
    public Produit findById(long id) {
        // Parcourir la liste
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p; // On a trouvé !
            }
        }
        return null; // Pas trouvé
    }
    
    // Supprimer un produit par son ID
    @Override
    public void delete(long id) {
        Produit produitASupprimer = findById(id);
        if (produitASupprimer != null) {
            produits.remove(produitASupprimer);
            System.out.println("✅ Produit supprimé !");
        } else {
            System.out.println("❌ Produit non trouvé !");
        }
    }
}
