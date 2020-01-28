package api.main.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Debes especificar el nombre")
	@Size(min = 1, max = 50, message= "El nombre de tener entre 1 y 50 caracteres")
	private String nombre;
	
	@NotNull(message = "Debes especificar el código")
	@Size(min = 1, max = 50, message= "El código de tener entre 1 y 50 caracteres")
	private String codigo;
	
	@NotNull(message = "Debes especificar el precio")
    @Min(value = 0, message = "El precio mínimo es 0")
	private double precio;
	
	@NotNull(message = "Debes especificar la existencia")
    @Min(value = 0, message = "La existencia mínima es 0")
    private double existencia;

	
	
	public Producto() {
	}

	
	public Producto(String nombre, String codigo, double precio, double existencia, Integer id) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.existencia = existencia;
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getExistencia() {
		return existencia;
	}


	public void setExistencia(double existencia) {
		this.existencia = existencia;
	}
	
	
	public boolean sinExistencia() {
        return this.getExistencia() <= 0;
    }
	
	
	public double restarExistencia(double existencia) {
        this.existencia -= existencia;
        return existencia;
    }
	
	
	
	
	
	
}
