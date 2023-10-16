public class ShowDetails {
    public static void show(Developer dev) {
        if (dev instanceof Frontender) {
            ((Frontender) dev).createFront();
        } else if (dev instanceof Backender) {
            ((Backender) dev).createServer();
        } else {
            ((Fullstack) dev).createFront();
            ((Fullstack) dev).createServer();
        }
    }
}