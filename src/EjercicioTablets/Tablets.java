package EjercicioTablets;

public class Tablets {
	
	protected String color, marca, tamaño, id_tablet;
	
	protected boolean ranuraSIM, camara;
	protected double precioTienda, precioVenta;
	
	protected final String COLOR = "blanco";
	protected final String MARCA = "samsung";
	protected final String TAMAÑO = "mediano";
	
	protected Tablets(double precioTienda, String id_tablet) {
		
		this.precioTienda = precioTienda;
		this.id_tablet = id_tablet;
		color = COLOR;
		marca = MARCA;
		tamaño = TAMAÑO;
		comprobarMarca();
		comprobarColor();
		precioExtras();
	}

	protected Tablets(String color, String marca, String tamaño, String id_tablet, boolean ranuraSIM, boolean camara,
			double precioTienda) {
		
		this.color = color;
		this.marca = marca;
		this.tamaño = tamaño;
		this.id_tablet = id_tablet;
		this.ranuraSIM = ranuraSIM;
		this.camara = camara;
		this.precioTienda = precioTienda;
		comprobarMarca();
		comprobarColor();
		precioExtras();
	}

	protected String getId_tablet() {
		return id_tablet;
	}
	
	protected void setId_tablet(String id_tablet) {
		this.id_tablet = id_tablet;
	}
	
	protected String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
		comprobarColor();
		precioExtras();
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
		comprobarMarca();
		precioExtras();
	}

	protected String getTamaño() {
		return tamaño;
	}

	protected void setTamaño(String tamaño) {
		this.tamaño = tamaño;
		precioExtras();
	}

	protected boolean isRanuraSIM() {
		return ranuraSIM;
	}

	protected void setRanuraSIM(boolean ranuraSIM) {
		this.ranuraSIM = ranuraSIM;
		precioExtras();
	}

	protected boolean isCamara() {
		return camara;
	}

	protected void setCamara(boolean camara) {
		this.camara = camara;
		precioExtras();
	}

	protected double getPrecioTienda() {
		return precioTienda;
	}

	protected void setPrecioTienda(double precioTienda) {
		this.precioTienda = precioTienda;
	}
	

	protected double getPrecioVenta() {
		return precioVenta;
	}

	@Override
	public String toString() {
		return "Tablet nº"+id_tablet+" \n Color=" + color + "\n Marca=" + marca + "\n Tamaño=" + tamaño + "\n SIM=" + ranuraSIM + "\n Camara=" + camara + "\n Precio=" + precioTienda + "\n Precio De Venta=" + precioVenta;
	}
	
	protected void comprobarMarca () {
		if (!marca.equalsIgnoreCase("Samsung") && !marca.equalsIgnoreCase("Apple") && !marca.equalsIgnoreCase("Huawei")) {
			marca = MARCA;
		}
	}
	protected void comprobarColor () {
		if (!color.equalsIgnoreCase("blanco") && !color.equalsIgnoreCase("negro") && !color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("verde")) {
			color=COLOR;
		}
	}
	
	//Precio por atributo - control de excepciones
	protected void precioExtras () {
		precioVenta=precioTienda;
		if (tamaño.equalsIgnoreCase("grande")) {
			precioVenta += 50;
		} else if (tamaño.equalsIgnoreCase("mediano")) {
			precioVenta += 30;
		} else {
			tamaño = TAMAÑO;
			precioVenta += 10;
		}
		switch (color.toLowerCase()) {
		case "blanco":
			precioVenta += 10;
			break;
		case "negro":
			precioVenta += 5;
			break;
		case "rojo":
			precioVenta += 20;
			break;
		case "verde":
			precioVenta += 30;
			break;
			default:
		}
		if (camara) {
			precioVenta += 70;
		} 
		if (ranuraSIM) {
			precioVenta += 40;
		}
		if (marca.equalsIgnoreCase("Samsung")) {
			precioVenta += 10;
		} else if (marca.equalsIgnoreCase("apple")) {
			precioVenta += 80;
		} else if (marca.equalsIgnoreCase("Huawei")) {
			precioVenta += 20;
		}
		//sumar precio por extras - otro metodo para marcas, color y tamaño
		//revisar los datos q se piden para el alta
		//Si tienen acc, condicion para poner el si como true
	}
	

}
