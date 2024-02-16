public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Tube InP_CS = new Tube();
        Tube CS_Sort = new Tube();

        Input input = new Input(InP_CS);
        CircularShift cs = 
        new CircularShift(InP_CS, CS_Sort);

        cs.start();
        input.start();
    }
}
