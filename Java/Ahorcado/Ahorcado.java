/**
 * Juego del Ahorcado versión consola
 * @author jesus
 */
package ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    Random numAleatorio = new Random();
    Scanner entrada = new Scanner(System.in);
    final String ImagenesAhorcado[] = {"\n"
            + " +---+\n"
            + " |   |\n"
            + "     |\n"
            + "     |\n"
            + "     |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + "     |\n"
            + "     |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + " |   |\n"
            + "     |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + "/|   |\n"
            + "     |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + "/|\\  |\n"
            + "     |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + "/|\\  |\n"
            + "/ \\  |\n"
            + "     |\n"
            + "=======", "\n"
            + " +---+\n"
            + " |   |\n"
            + " 0   |\n"
            + "/|\\  |\n"
            + "/ \\  |\n"
            + "     |\n"
            + "======="};
    String Palabras = "hormiga babuino tejon murcielago oso castor camello"
            + " gato almeja cobra pantera coyote cuervo ciervo perro burro pato"
            + " aguila huron zorro rana cabra ganso halcon leon lagarto llama "
            + "topo mono alce raton mula salamandra nutria buho panda loro "
            + "paloma piton conejo carnero rata cuervo rinoceronte salmon foca"
            + " tiburon oveja mofeta perezoso serpiente araña cigüeña cisne"
            + " tigre sapo trucha pavo tortuga comadreja ballena lobo wombat"
            + " cebra";
    String PalabrasArreglo[] = Palabras.split(" ");
    
    /**
     * Obtener palabra al azar
     * @param ListaPalabras
     * @return 
     */
    public String palabraAlAzar(String[] ListaPalabras){
        int indice =  numAleatorio.nextInt(ListaPalabras.length);
        return ListaPalabras[indice];
    }
    
    /**
     * Buscar letra en arreglo de letras
     * @param aguja
     * @param pajar
     * @return 
     */
    public boolean charEnArray(char aguja, char [] pajar){
        if( aguja != 0 && pajar.length > 0){
            boolean encontro = false;
            for(char c : pajar){
                if(c == aguja){
                    encontro = true;
                    break;
                }
            }
            return encontro;
        }else{
            return false;
        }
    }
    
    /**
     * Se muestra el tablero junto con el prgreso del juego
     * @param Imagenes
     * @param LetrasCorrectas
     * @param LetrasIncorrectas
     * @param PalabraSecreta 
     */
    public void mostrarTablero(String []Imagenes, String LetrasCorrectas, String LetrasIncorrectas, String PalabraSecreta){
        System.out.println(Imagenes[LetrasIncorrectas.length()]);
        System.out.print("Letras incorrectas: ");
        for(char letra : LetrasIncorrectas.toCharArray()){
            System.out.print(letra);
        }
        System.out.println();
        String espaciosVacios = "";
        for(int i = 0; i < PalabraSecreta.length(); i++){
            espaciosVacios += "_";
        }
        for(int i = 0; i < PalabraSecreta.length(); i++){
            if(charEnArray(PalabraSecreta.charAt(i), LetrasCorrectas.toCharArray())){
                espaciosVacios = espaciosVacios.substring(0, i) + PalabraSecreta.charAt(i) + espaciosVacios.substring(i+ 1, espaciosVacios.length());
            }
        }
        for(char letra : espaciosVacios.toCharArray()){
            System.out.print(letra);
        }
        System.out.println("");
    }
    
    /**
     * obtener letra ingresada por usuario
     * @param letrasProbadas
     * @return 
     */
    public String obtenerIntento(String letrasProbadas){
        while (true){
            System.out.println("Adivina una letra.");
            String intento = entrada.next().toLowerCase();
            if(intento.length() != 1){
                System.out.println("Por favor, introduce una letra.");
            }
            else if(this.charEnArray(intento.charAt(0), letrasProbadas.toCharArray())){
                System.out.println("Ya has probado esa letra. Elije otra");
            }
            else if(!this.charEnArray(intento.charAt(0), "abcdefghijklmnñopqrstuvwxyz".toCharArray())){
                System.out.println("Por favor ingresa una LETRA.");
            }
            else{
                return intento;
            }
        }
    }
    
    /**
     * preguntar si continuar con el juego o salir
     * @return bool Respuesta
     */
    public boolean jugarDeNuevo(){
        System.out.println("Quieres jugar de nuevo? (si o no)");
        return (entrada.next().toLowerCase().startsWith("s"));             
    }

    /**
     * MAIN
     * @param args 
     */
    public static void main(String[] args) {
        Ahorcado ahorcado = new Ahorcado();
        String letrasIncorrectas = "";
        String letrasCorrectas = "";
        String palabraSecreta = ahorcado.palabraAlAzar(ahorcado.PalabrasArreglo);
        boolean juegoTerminado = false;
        do{ 
            System.out.println("A H O R C A D O");
            ahorcado.mostrarTablero(ahorcado.ImagenesAhorcado, letrasCorrectas, letrasIncorrectas, palabraSecreta);
            String intento = ahorcado.obtenerIntento(letrasCorrectas);
            if(ahorcado.charEnArray(intento.charAt(0), palabraSecreta.toCharArray())){
                letrasCorrectas += intento;
                boolean encontroTodas = true;
                for(int i = 0; i < palabraSecreta.length(); i++){
                    if(!ahorcado.charEnArray(palabraSecreta.charAt(i), letrasCorrectas.toCharArray())){
                        encontroTodas = false;
                        break;
                    }
                }
                if(encontroTodas){
                    System.out.println("¡Sí! ¡La palabra secreta es \"" + palabraSecreta + "\"!\n" +"¡Has ganado!'");
                    juegoTerminado = true;
                }
            }else{
                letrasIncorrectas += intento;
                if(letrasIncorrectas.length() == ahorcado.ImagenesAhorcado.length - 1){
                    ahorcado.mostrarTablero(ahorcado.ImagenesAhorcado, letrasCorrectas, letrasIncorrectas, palabraSecreta);
                    System.out.println("¡Te has quedado sin intentos! \nDespués de " + letrasIncorrectas.length() + " intentos fallidos y "+ letrasCorrectas.length() + " aciertos, la palabra era \"" + palabraSecreta +"\"");
                    juegoTerminado = true;
                }
            }
            if(juegoTerminado){
                if(ahorcado.jugarDeNuevo()){
                    letrasIncorrectas = "";
                    letrasCorrectas = "";
                    juegoTerminado = false;
                    palabraSecreta = ahorcado.palabraAlAzar(ahorcado.PalabrasArreglo);
                }else{
                    break;
                }
            }
        }while(true);
    }  
}
