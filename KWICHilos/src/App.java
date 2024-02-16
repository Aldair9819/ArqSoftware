public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicia el programa");
        long startTime = System.nanoTime();

        Tube InP_CS = new Tube();
        Tube CS_Sort = new Tube();

        Input input = new Input(InP_CS);
        CircularShift cs = new CircularShift(InP_CS, CS_Sort);
        Sort sortObj = new Sort(CS_Sort);
        
        cs.start();
        input.start();
        sortObj.start();

        try {
            sortObj.join(); // Espera a que el hilo termine
            Output out = new Output(sortObj.getSalidaA());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("El tiempo de ejecución es: " + duration + " nanosegundos");
    }
    }

