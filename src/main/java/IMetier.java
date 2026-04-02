import java.util.List;

// T = Type générique (on décidera plus tard quel type utiliser)
public interface IMetier<T> {
    
    // Ajouter un objet à la liste
    public void add(T o);
    
    // Récupérer TOUS les objets sous forme de liste
    public List<T> getAll();
    
    // Trouver un objet par son ID
    public T findById(long id);
    
    // Supprimer un objet par son ID
    public void delete(long id);
}
