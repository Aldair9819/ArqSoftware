public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Input cs = new Input();
        Input cs2 = new Input();
        cs.setNombre("Prueba01");
        cs2.setNombre("Prueba02");
        cs.start();
        cs2.start();
    }
}
