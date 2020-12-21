package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Input {

    String info;

    Input(String info) {
        this.info = info;
    }

    protected abstract String read() throws FileNotFoundException;
}

class InputFile extends Input {

    private String data;

    InputFile (String info) {
        super(info);
    }

    @Override
    protected String read() throws FileNotFoundException {
        File file = new File(info);
        Scanner scanner = new Scanner(file);
        data = scanner.nextLine();
        scanner.close();
        return data;
    }

}
