/*
 * Estudio de interfaz de la clase
 * Clase: PersonajeImpl
 * Propiedades: 
 * 	Basicas: 
 * 	String nombre;	consultable 
	double vida;	consultable y modificable
	boolean estado = true; consultable y modificable
 	int nivel = 1; consultable y modificable
	double ataque; consultable y modificable
    double atkespecial; consultable y modificable
	double defensa; consultable y modificable
    double defespecial; consultable y modificable
    double inteligencia; consultable y modificable
 * 				
 * 	Compartidas: 	
 * 	Derivadas:	
 * 	Restricciones de los datos: 
 * 		
 * 		
 * 
 * Metodos (para interface):

	public String getNombre () {return nombre;}
	public double getVida() {return vida;}

	public void setVida(double vida) {this.vida = vida;	}
	public boolean getEstado() {return estado;}

	public void setEstado(boolean estado) {this.estado = estado;}
	
	public int getNivel () {return nivel;}
	public void setNivel(int nivel)  {this.nivel = nivel;}
	 	
	public double getAtaque () {return ataque;}
	public void setAtaque(double ataque) {this.ataque = ataque;}
	 
	public double getDefensa () {return defensa;}
	public void setDefensa(double defensa) {this.defensa = defensa;}
	
	
	public double getAtkespecial() {return atkespecial;}

	public void setAtkespecial(double atkespecial) {this.atkespecial = atkespecial;}

	public double getDefespecial() {return defespecial;}
	public void setDefespecial(double defespecial) {this.defespecial = defespecial;}

	public double getInteligencia() {return inteligencia;}
	public void setInteligencia(double inteligencia) {this.inteligencia = inteligencia;}

 * 	
 * 
 * Metodos añadidos:
 *	public void golpeFisico (PersonajeImpl pj2);
 *	public void golpeMagico (PersonajeImpl pj2)
 *	private void recibir (PersonajeImpl pj2, double dmg);
 *	public void actualizarEstado();
 *	public void subirNivel();
 *	public void recuperarVida(); 
 *	public int tomarDecision ();
 * 	public void resetear ();
 * 	public boolean proteccion ();
 * 
 * Metodos Object:
 * 		equals
 * 		compareTo
 * 		toString
 * 		hashCode
 * 		clone
 * 
 * */
public class PersonajeImpl implements Cloneable, Personaje{
	private String nombre;
	private final double MAX_VIDA = 500;
	private double vida = MAX_VIDA;
	private boolean estado = true;
	private int nivel = 1;
	private double ataque;
    private double atkespecial;
	private double defensa;
    private double defespecial;
    private double inteligencia;
    
	
	//constructor

    public PersonajeImpl() {
        this.nombre = "Personaje";
        this.vida = MAX_VIDA;
        this.estado = true;
        this.nivel = 1;
        this.ataque = 20;
        this.atkespecial = 20;
        this.defensa = 20;
        this.defespecial = 20;
        this.inteligencia = 20;
    }

    public PersonajeImpl(String nombre, double ataque, double atkespecial, double defensa, double defespecial, double inteligencia) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.atkespecial = atkespecial;
        this.defensa = defensa;
        this.defespecial = defespecial;
        this.inteligencia = inteligencia;
    }



	//getters and setters
	public String getNombre () {return nombre;}

	
	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public int getNivel () {return nivel;}
	public void setNivel(int nivel)  {this.nivel = nivel;}
	 	
	public double getAtaque () {return ataque;}
	public void setAtaque(double ataque) {this.ataque = ataque;}
	 
	public double getDefensa () {return defensa;}
	public void setDefensa(double defensa) {this.defensa = defensa;}
	
	
	public double getAtkespecial() {
		return atkespecial;
	}

	public void setAtkespecial(double atkespecial) {
		this.atkespecial = atkespecial;
	}

	public double getDefespecial() {
		return defespecial;
	}

	public void setDefespecial(double defespecial) {
		this.defespecial = defespecial;
	}

	public double getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(double inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	
	
	//metodos añadidos
	public void actualizarEstado() {
		
		if  ( this.getVida() <= 0 ) {
			this.setEstado(false);
			this.setVida(0);
		} 
	}
	
	
	public void golpeFisico (PersonajeImpl pj2) {
		
		double coeficiente = (Math.random() * 10);
		double dmg=0;
		
		if (pj2.getVida() > 0 ) {
			dmg = Math.abs((this.getAtaque() + coeficiente) - (pj2.getDefensa()/ ((int) (Math.random()*2+1)  )))+ (int)(Math.random()*2) ;
			pj2.recibir(this, dmg);
			}
		
		}
	
	public void golpeMagico (PersonajeImpl pj2) {
		
		double coeficiente = (Math.random() * 10);
		double dmg=0;
		
		if (pj2.getVida() > 0 ) {
			dmg = Math.abs((this.getAtkespecial() + coeficiente) - (pj2.getDefespecial()/ ((int) (Math.random()*2+1)  )))+ (int)(Math.random()*2) ;
			pj2.recibir(this, dmg);
			}
		
		}
	
	private void recibir (PersonajeImpl pj2, double dmg) {
		if (dmg > 0) {
			this.setVida( this.getVida() -  dmg  );
			this.actualizarEstado();
			pj2.actualizarEstado();
		}
	}
		
	public void subirNivel() {
		
		int c1 = (int) (Math.random() * 3);
		int c2 = (int) (Math.random() * 3);
		
		this.setNivel(this.getNivel()+1);
		this.setAtaque(this.getAtaque()+c1);
		this.setDefensa(this.getDefensa()+c2);
		this.setAtkespecial(this.getAtkespecial()+c2);
		this.setDefespecial(this.getDefespecial()+c1);
		this.setInteligencia(this.getInteligencia()+c1);
	
	}
	
	public void recuperarVida() {
		double hp = (int) (Math.random() * 3) + (this.getInteligencia()/2 );
		
		
		if (this.getVida() + hp >= MAX_VIDA ) {
			this.setVida(MAX_VIDA) ;
		}else {
			this.setVida( this.getVida() + hp );
			}
		}
			
	public int tomarDecision () {
		int decision ;
		
		do {
			decision = (int) ((Math.random() * 4 ) +2);
		} while ( decision == 4 && this.getVida() >= (this.MAX_VIDA/2) ) ;
		
		
		
		return decision;
		
	}
		  
    public void resetear () {
        this.setVida(MAX_VIDA);
        this.setEstado(true);
        }
		
        
    public boolean proteccion () {
    	boolean protect = false;
    	int coef = (int) (Math.random() * 10000 );
    	
    		if (  Calculo.isPrimo(coef + (int)this.getInteligencia()) ) {
    			
    			protect = true;
    			
    		}
    	
    	
    	return protect; 
    }
        
        
        //metodos object

    @Override
    public String toString() {
        return "Personaje:" + "nombre: " + nombre + ", vida: " + vida + ", estado: " + estado + ", nivel: " + nivel + ", ataque: " + ataque + ", atkespecial: " + atkespecial + ", defensa: " + defensa + ", defespecial: " + defespecial + ", inteligencia: " + inteligencia ;
    }

	@Override
	public PersonajeImpl clone() {
		PersonajeImpl copia = null;
		
		try {
			copia = (PersonajeImpl) super.clone();
		} catch (CloneNotSupportedException error) {
			System.out.println("Error en la copia");
			}
		return copia;
		}
    
        
	} //cierra clase PersonajeImpl
	

		
		
	
	
	

