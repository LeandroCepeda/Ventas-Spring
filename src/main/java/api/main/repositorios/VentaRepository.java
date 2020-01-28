package api.main.repositorios;

import org.springframework.data.repository.CrudRepository;

import api.main.entidades.Venta;

public interface VentaRepository extends CrudRepository<Venta, Integer> {

}
