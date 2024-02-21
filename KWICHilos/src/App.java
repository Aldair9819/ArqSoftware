

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Inicia el programa");
        String rutaEntrada = RutaTXT.rutaEntrada();
        String rutaSalida = "";
        //Usa esta linea para la ruta de salida de 1 solo archivo
        //rutaSalida = RutaTXT.rutaSalidaUno(rutaEntrada);

        //Usa esta linea para la ruta de salida de varios archivos
        //rutaSalida = RutaTXT.rutaSalidaNumero(rutaEntrada);

        //Recuerda escoger una de ellas y borrar la otra
        //Tanto en la clase como en el main

        System.out.println("Tu ruta es:"+rutaEntrada);
        System.out.println("Ruta de salida: "+rutaSalida);
        //Aqui acaba la parte de las rutas.




        //Esto de acá es el código que se ejecuta. Puedes
        //solo añadir lo de arriba al codigo en tu compu 
        //y correrlo sin necesidad de esto de abajo

        /* 
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
        */
    }
    }

