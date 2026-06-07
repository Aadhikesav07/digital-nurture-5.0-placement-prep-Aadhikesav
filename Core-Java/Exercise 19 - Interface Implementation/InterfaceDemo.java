interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Guitar playing");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Piano playing");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Playable[] instruments = {new Guitar(), new Piano()};
        for (Playable instrument : instruments) {
            instrument.play();
        }
    }
}
