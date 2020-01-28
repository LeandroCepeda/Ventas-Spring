package api.main.repositorios;

import org.springframework.data.repository.CrudRepository;

import api.main.entidades.ProductoVendido;

public interface ProductoVendidoRepository extends CrudRepository<ProductoVendido, Integer> {

}
