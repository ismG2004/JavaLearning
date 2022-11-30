interface Keyboard { };
interface Monitor { }

class StandardKeyboard implements Keyboard {
    int numberOfKeys;
    String make;
    void startUpMessage() {
        System.out.println("Hello!");
    }
}

class GamingKeyboard implements Keyboard {
    int numberOfKeys = 111;
    String make = "Lenovo";
    void startUpMessage() { System.out.println("Hello!"); }
}

class StandardMonitor implements Monitor {
    int diagonalSize;
    String make;
    void startUpMessage() { System.out.println("Hello!"); }
}

class Windows95Machine implements Keyboard {
    private final Keyboard keyboard;
    private final Monitor monitor;

    public Windows95Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}

class Tr {
    public static void main(String[] args) {

        StandardKeyboard standardKeyboard = new StandardKeyboard();
        GamingKeyboard gamingKeyboard = new GamingKeyboard();
        StandardMonitor standardMonitor = new StandardMonitor();

        Windows95Machine windows95Machine = new Windows95Machine(gamingKeyboard, standardMonitor);
    }
}