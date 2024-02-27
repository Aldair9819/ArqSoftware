
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicia el programa");
        
        //Inicia el programa, entrada de rutas
        System.out.println("Ingresa ruta de entrada");
        String rutaE = System.console().readLine();
        String rutaEntrada = RutaTXT.rutaEntrada(rutaE);
        System.out.println("Ingresa ruta de salida");
        String rutaSalida;
        String rutaS = System.console().readLine();
        rutaSalida = RutaTXT.rutaSalidaUno(rutaS);

        //Crear los objetos
        long startTime = System.nanoTime();
        Tube InP_CS = new Tube();
        Tube CS_Sort = new Tube();
        Tube sort_Outpput = new Tube();
        Input input = new Input(InP_CS, rutaEntrada);
        CircularShift cs = new CircularShift(InP_CS, CS_Sort);
        Sort sortObj = new Sort(CS_Sort, sort_Outpput);
        Output out = new Output(sort_Outpput, rutaSalida);

        cs.start();
        input.start();
        sortObj.start();
        out.start();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("El tiempo de ejecución es: " + duration + " nanosegundos");
        
    }
    }

