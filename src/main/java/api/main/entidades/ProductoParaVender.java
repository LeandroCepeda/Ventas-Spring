package api.main.entidades;

/**
 * Clase utilizada unicamente para la lista de compras
 */
public class ProductoParaVender extends Producto {
	
	private double cantidad;

	public ProductoParaVender(double cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoParaVender() {
	}

	public ProductoParaVender(String nombre, String codigo, double precio, double existencia,Integer id, double cantidad) {
		super(nombre, codigo, precio, existencia,id);
		this.cantidad = cantidad;
	}
	
	
	public void aumentarCantidad() {
        this.cantidad++;
    }
	
    public double getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return this.getPrecio() * this.cantidad;
    }
	
	

}
