package wl.sop.testtech.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import wl.sop.testtech.api.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
