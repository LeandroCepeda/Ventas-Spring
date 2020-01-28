package api.main.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * 
 *Los productos vendidos son una entidad distinta. No pueden tener una relación con los productos, ya que los mismos pueden cambiar de precio en el futuro y si esto cambia, 
 *se afectaría al historial de ventas.
 *
 */

@Entity
public class ProductoVendido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String nombre;
	
	private String codigo;
	
	
    private double cantidad;
    
    private double precio;
    
    @ManyToOne
    @JoinColumn
    private Venta venta;

    public ProductoVendido(double cantidad, double precio, String nombre, String codigo, Venta venta) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.venta = venta;
    }

    public ProductoVendido() {
    }

    public double getTotal() {
        return this.cantidad * this.precio;
    }
    

    public Venta getVenta() {
        return venta;
    }
    

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
    public double getPrecio() {
        return precio;
    }
    

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    
    public double getCantidad() {
        return cantidad;
    }
    

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
