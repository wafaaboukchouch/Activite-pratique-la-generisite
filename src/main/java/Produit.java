public class Produit {
    // Les caractéristiques d'un produit (attributs)
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;
    
    // Constructeur : permet de créer un produit en donnant toutes ses infos
    public Produit(long id, String nom, String marque, double prix, 
                   String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }
    
    // Getters : permettent de récupérer les infos d'un produit
    public long getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getMarque() {
        return marque;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getNombreEnStock() {
        return nombreEnStock;
    }
    
    // Setters : permettent de modifier les infos d'un produit
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }
    
    // Cette méthode permet d'afficher joliment un produit
    @Override
    public String toString() {
        return "ID: " + id + " | Nom: " + nom + " | Marque: " + marque + 
               " | Prix: " + prix + " DH | Stock: " + nombreEnStock;
    }
}
