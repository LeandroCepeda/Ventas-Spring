package api.main.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api.main.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	Producto findFirstByCodigo(String codigo); //buscará el primer producto por código de barras

}
