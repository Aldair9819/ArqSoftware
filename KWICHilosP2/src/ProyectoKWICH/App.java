package ProyectoKWICH;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicia el programa");
        String rutaEntrada = RutaTXT.rutaEntrada();
        String rutaSalida = RutaTXT.rutaSalida();
        long startTime = System.nanoTime();

        Tube InP_CS = new Tube();
        Tube CS_Sort = new Tube();
        Tube Sort_Out = new Tube();

        Input input = new Input(InP_CS, rutaEntrada);
        CircularShift cs = new CircularShift(InP_CS, CS_Sort);
        Sort sortObj = new Sort(CS_Sort, Sort_Out);
        
        cs.start();
        input.start();
        sortObj.start();

        try {
            sortObj.join(); // Espera a que el hilo termine
            Output.salidaEnArchivo(Sort_Out, rutaSalida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("El tiempo de ejecución es: " + duration + " nanosegundos");
    }
    }

