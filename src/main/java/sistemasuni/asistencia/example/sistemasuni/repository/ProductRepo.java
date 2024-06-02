package sistemasuni.asistencia.example.sistemasuni.repository;

import sistemasuni.asistencia.example.sistemasuni.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
