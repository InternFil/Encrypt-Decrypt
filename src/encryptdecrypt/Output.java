package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Output {
    protected String message;

    Output(String message) {
        this.message = message;
    }

    protected abstract void print() throws FileNotFoundException;
}

class OutputFile extends Output {

    private String path;

    OutputFile (String path, String message) {
        super(message);
        this.path = path;
    }

    @Override
    protected void print() throws FileNotFoundException {
        File file = new File(path);
        PrintWriter writer = new PrintWriter(file);
        writer.print(message);
        writer.close();
    }

}
