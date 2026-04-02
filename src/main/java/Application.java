import java.util.List;
import java.util.Scanner;

public class Application {
    
    public static void main(String[] args) {
        // On crée notre gestionnaire de produits
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;
        
        // Boucle principale : on répète jusqu'à ce que l'utilisateur choisisse 5
        do {
            // Afficher le menu
            System.out.println("\n==========================================");
            System.out.println("        GESTION DES PRODUITS");
            System.out.println("==========================================");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");
            System.out.println("==========================================");
            System.out.print("Votre choix : ");
            
            choix = scanner.nextInt();
            
            // Selon le choix, on fait une action différente
            switch (choix) {
                case 1:
                    afficherListe(metier);
                    break;
                case 2:
                    rechercherProduit(metier, scanner);
                    break;
                case 3:
                    ajouterProduit(metier, scanner);
                    break;
                case 4:
                    supprimerProduit(metier, scanner);
                    break;
                case 5:
                    System.out.println("👋 Au revoir !");
                    break;
                default:
                    System.out.println("❌ Choix invalide !");
            }
            
        } while (choix != 5);
        
        scanner.close();
    }
    
    // ========== LES ACTIONS ==========
    
    // Action 1 : Afficher tous les produits
    private static void afficherListe(MetierProduitImpl metier) {
        System.out.println("\n--- LISTE DES PRODUITS ---");
        List<Produit> produits = metier.getAll();
        
        if (produits.isEmpty()) {
            System.out.println("Aucun produit.");
        } else {
            for (Produit p : produits) {
                System.out.println(p);
                System.out.println("------------------------");
            }
        }
    }
    
    // Action 2 : Rechercher un produit
    private static void rechercherProduit(MetierProduitImpl metier, Scanner scanner) {
        System.out.print("\nEntrez l'ID du produit : ");
        long id = scanner.nextLong();
        
        Produit produit = metier.findById(id);
        if (produit != null) {
            System.out.println("Produit trouvé : " + produit);
        } else {
            System.out.println("❌ Aucun produit avec l'ID " + id);
        }
    }
    
    // Action 3 : Ajouter un produit
    private static void ajouterProduit(MetierProduitImpl metier, Scanner scanner) {
        System.out.println("\n--- AJOUT D'UN PRODUIT ---");
        
        System.out.print("ID : ");
        long id = scanner.nextLong();
        
        // Vérifier si l'ID n'existe pas déjà
        if (metier.findById(id) != null) {
            System.out.println("❌ Cet ID existe déjà !");
            return;
        }
        
        System.out.print("Nom : ");
        scanner.nextLine(); // Vider le buffer
        String nom = scanner.nextLine();
        
        System.out.print("Marque : ");
        String marque = scanner.nextLine();
        
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        
        System.out.print("Description : ");
        scanner.nextLine();
        String description = scanner.nextLine();
        
        System.out.print("Stock : ");
        int stock = scanner.nextInt();
        
        // Créer et ajouter le nouveau produit
        Produit nouveau = new Produit(id, nom, marque, prix, description, stock);
        metier.add(nouveau);
    }
    
    // Action 4 : Supprimer un produit
    private static void supprimerProduit(MetierProduitImpl metier, Scanner scanner) {
        System.out.print("\nEntrez l'ID du produit à supprimer : ");
        long id = scanner.nextLong();
        
        Produit produit = metier.findById(id);
        if (produit != null) {
            System.out.println("Produit à supprimer : " + produit);
            System.out.print("Confirmer ? (o/n) : ");
            scanner.nextLine();
            String confirmation = scanner.nextLine();
            
            if (confirmation.equalsIgnoreCase("o")) {
                metier.delete(id);
            } else {
                System.out.println("Suppression annulée.");
            }
        } else {
            System.out.println("❌ Produit non trouvé !");
        }
    }
}
