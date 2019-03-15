/*
 * Alumna: Angela Vazquez Dominguez
 * Comentario: Juego de batallas
 * Formula: 
 * Datos de entrada: opciones del usuario introducidas por teclado
 * Datos de salida: mensajes de ayuda al usuario, resultados e informacion de las partidas y los personajes
 * Restricciones:
 * PSEUDOCODIGO GENERALIZADO
 * 	inicio
 *
 * 	fin
 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion, opPj, combate=0;
                
         PersonajeImpl arrayPersonajes[]=new PersonajeImpl[10];
               
         arrayPersonajes[0]=new PersonajeImpl("Luchador", 70, 5, 50, 5, 10);
         arrayPersonajes[1]=new PersonajeImpl("Mago", 5, 70, 5, 50, 70);
         arrayPersonajes[2]=new PersonajeImpl("Clerigo", 5, 55, 35, 65, 90);
         arrayPersonajes[3]=new PersonajeImpl("Defensor", 30, 5, 80, 30, 10);
         arrayPersonajes[4]=new PersonajeImpl("Espagueti volador", 95,75, 80, 60, 97);
         arrayPersonajes[5]=new PersonajeImpl("Super Angela", 30,88, 99, 22, 75);
         arrayPersonajes[arrayPersonajes.length-2]=new PersonajeImpl();
         arrayPersonajes[arrayPersonajes.length-1]=new PersonajeImpl();
     
		do {
                    
			do {
			System.out.println("---------------------MENU-----------------------");
			System.out.println("0. Salir");
			System.out.println("1. Luchar");
			System.out.println("2.Ver instrucciones");
			opcion = sc.nextInt();
			}while(opcion < 0 || opcion > 2);
		
		if (opcion >= 1 && opcion <= 2) {	
			switch (opcion) {
			case 1:
                            int pj;
                            int enemigo = ((int) (Math.random()* 6 ));
				//luchar	
                            do{
                                System.out.println("Elige personaje:");
                                System.out.println("0. Salir");
                                System.out.println("1. Luchador");
                                System.out.println("2. Mago");
                                System.out.println("3. Clerigo");
                                System.out.println("4. Defensor");
                                System.out.println("5. Espagueti Volador");
                                System.out.println("6. Super Angela");
                                pj = sc.nextInt();
                            }while(pj < 0 || pj > 6);
                            
                           arrayPersonajes[arrayPersonajes.length-1] = arrayPersonajes[enemigo].clone();
                           enemigo = arrayPersonajes.length-1;
                           
                           arrayPersonajes[arrayPersonajes.length-2] = arrayPersonajes[pj-1].clone();
                           pj = arrayPersonajes.length-2;
                            
                if (pj != 0)   {        
					int turno=0;
					combate++;
					System.out.println("Combate No: "+combate);
					arrayPersonajes[pj].resetear();
									arrayPersonajes[enemigo].resetear();
									System.out.println("Has elegido: "+arrayPersonajes[pj].getNombre());
									System.out.println("El enemigo es un: "+arrayPersonajes[enemigo].getNombre());
					do {
						
						do {
							System.out.println("---------------------ELIGE ACCION-----------------------");
							System.out.println("0. Salir");
							System.out.println("1. Ver stats");
							System.out.println("2. Ataque fisico");
							System.out.println("3. Ataque magico");
							System.out.println("4. Lanzar curacion");
							System.out.println("5.Protegerse");
							System.out.println("---------------------------------------------------------");
							opPj = sc.nextInt();
						}while(opPj < 0 || opPj > 5);
						
						if ((opPj >= 1 && opPj <= 5)) {
						switch (opPj) {
						case 1:
							//ver stats
							System.out.println("-----------------MARCADOR----------------------");
							System.out.println(arrayPersonajes[pj].toString());
							System.out.println(arrayPersonajes[enemigo].toString());
							System.out.println("-----------------------------------------------");
							break;
						case 2:
							turno++;
							System.out.println("-----------------------Turno "+turno+"-------------------");
		
							System.out.println("Realizas: ataque fisico");
							arrayPersonajes[pj].golpeFisico(arrayPersonajes[enemigo]);
							arrayPersonajes[enemigo].actualizarEstado();
							System.out.println("LV\tTU ENEMIGO\tHP\t");
							System.out.println(arrayPersonajes[enemigo].getNivel()+"\t"+arrayPersonajes[enemigo].getNombre()+"\t"+arrayPersonajes[enemigo].getVida());
							System.out.println("------------------------------------");
							break;
							
						case 3:
							//ataque magico
							turno++;
							System.out.println("-----------------------Turno "+turno+"-------------------");
		
							System.out.println("Realizas: ataque magico");
							arrayPersonajes[pj].golpeMagico(arrayPersonajes[enemigo]);
							arrayPersonajes[enemigo].actualizarEstado();
							System.out.println("LV\tTU ENEMIGO\tHP\t");
							System.out.println(arrayPersonajes[enemigo].getNivel()+"\t"+arrayPersonajes[enemigo].getNombre()+"\t"+arrayPersonajes[enemigo].getVida());
							
							System.out.println("------------------------------------");

							break;
						case 4:
							System.out.println("--------------");
							arrayPersonajes[pj].recuperarVida();
							System.out.println("Has elegido CURARTE");
							System.out.println("Vida de tu personaje: "+arrayPersonajes[pj].getVida() + "\nLv: "+arrayPersonajes[pj].getNivel());
							
							break;
						case 5:
							System.out.println("Has elegido protegerte");
							
							if (!arrayPersonajes[pj].proteccion()) {
								System.out.println("... pero has fallado");
							}
							
							break;
							
						}	//cierra el switch 
						
						if (!arrayPersonajes[enemigo].getEstado()) {
							
							System.out.println("El enemigo ha muerto! Has ganado y subes de nivel");
							arrayPersonajes[pj].subirNivel();
							System.out.println("Tu nivel: "+arrayPersonajes[pj].getNivel());
							System.out.println("Tu ataque: "+arrayPersonajes[pj].getAtaque());
							System.out.println("Tu defensa: "+arrayPersonajes[pj].getDefensa());
							System.out.println("Tu ataque especial: "+arrayPersonajes[pj].getAtkespecial());
							System.out.println("Tu defensa especial: "+arrayPersonajes[pj].getDefespecial());
							System.out.println("Tu inteligencia: "+arrayPersonajes[pj].getInteligencia());
							System.out.println("-------------------------------FIN COMBATE-------------------------------");
						}else {
							
							System.out.println("Vida de tu personaje: "+arrayPersonajes[pj].getVida() + "\nLv: "+arrayPersonajes[pj].getNivel());
							System.out.println("Vida del enemigo: "+arrayPersonajes[enemigo].getVida() + "\nLv: "+arrayPersonajes[enemigo].getNivel());
							System.out.println("--------------------------------------------------------------------");
					}
		
					if ( (opPj >= 2 && opPj <=4 || ( opPj == 5 && arrayPersonajes[pj].proteccion()  )   ) && arrayPersonajes[pj].getEstado() && arrayPersonajes[enemigo].getEstado() ) {

						
				switch (  arrayPersonajes[enemigo].tomarDecision()  ) {
					
						case 2:
							//ataque fisico
							turno++;
							System.out.println("-----------------------Turno "+turno+"-------------------");
		
							System.out.println("El enemigo realiza: ataque fisico");
							arrayPersonajes[enemigo].golpeFisico(arrayPersonajes[pj]);
							arrayPersonajes[pj].actualizarEstado();
							System.out.println("LV\tTU PERSONAJE\tHP\t");
							System.out.println(arrayPersonajes[pj].getNivel()+"\t"+arrayPersonajes[pj].getNombre()+"\t"+arrayPersonajes[pj].getVida());
							System.out.println("------------------------------------");

							break;
							
							
						case 3:
							//ataque magico
							turno++;
							System.out.println("-----------------------Turno "+turno+"-------------------");
		
							System.out.println("El enemigo realiza: ataque magico");
							arrayPersonajes[enemigo].golpeMagico(arrayPersonajes[pj]);
							arrayPersonajes[pj].actualizarEstado();
							System.out.println("LV\tTU PERSONAJE\tHP\t");
							System.out.println(arrayPersonajes[pj].getNivel()+"\t"+arrayPersonajes[pj].getNombre()+"\t"+arrayPersonajes[pj].getVida());
							System.out.println("------------------------------------");

							break;
						case 4:
							System.out.println("--------------");
							arrayPersonajes[enemigo].recuperarVida();
							System.out.println("El enemigo ha elegido CURARSE");
							System.out.println("Vida de tu enemigo: "+arrayPersonajes[enemigo].getVida() + "\nLv: "+arrayPersonajes[enemigo].getNivel());
							
							break;
						case 5:
							System.out.println("El enemigo ha elegido protegerse");
							
							if (!arrayPersonajes[enemigo].proteccion()) {
								System.out.println("... pero ha fallado");
							}else {
								System.out.println("y se protegio correctamente!");
								}
							
							break;
						
						} //cierra el switch de decision del pj2
						
						
						
							if (!arrayPersonajes[pj].getEstado()) {
							
							System.out.println("Has muerto! El enemigo ha ganado y sube de nivel");
							arrayPersonajes[enemigo].subirNivel();
							System.out.println("Tu nivel: "+arrayPersonajes[enemigo].getNivel());
							System.out.println("Tu ataque: "+arrayPersonajes[enemigo].getAtaque());
							System.out.println("Tu defensa: "+arrayPersonajes[enemigo].getDefensa());
							System.out.println("Tu ataque especial: "+arrayPersonajes[enemigo].getAtkespecial());
							System.out.println("Tu defensa especial: "+arrayPersonajes[enemigo].getDefespecial());
							System.out.println("Tu inteligencia: "+arrayPersonajes[enemigo].getInteligencia());
							System.out.println("-------------------------------FIN COMBATE-------------------------------");
						}else {
							
							System.out.println("Vida de tu personaje: "+arrayPersonajes[pj].getVida() + "\nLv: "+arrayPersonajes[pj].getNivel());
							System.out.println("Vida del enemigo: "+arrayPersonajes[enemigo].getVida() + "\nLv: "+arrayPersonajes[enemigo].getNivel());
							System.out.println("--------------------------------------------------------------------");
					}
						
						
						
					} //cierra el if
						}//cierra el if
						
					
					}while(opPj != 0 && (arrayPersonajes[pj].getEstado() && arrayPersonajes[enemigo].getEstado() ) );
				} //cierra el if
				break;
				
			case 2:
				//leer instrucciones
				System.out.println("Instrucciones del juego");
				break;
			
			}//cierra el switch
			
		} //cierra el if
	
	}while(opcion != 0 );
		
	}
	}


