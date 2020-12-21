package encryptdecrypt;

import java.io.FileNotFoundException;

public class Handler {

    private String in = null, out = null;
    private String cmd = "enc", data = "", alg = "shift";
    private int key = 0;

    Handler (String[] args) {
        initialize(args);
    }

    private void initialize (String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                cmd = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
            if (args[i].equals("-in")) {
                in = args[i + 1];
            }
            if (args[i].equals("-out")) {
                out = args[i + 1];
            }
        }
    }

    public void go() {
        String textInputFile, resultText;
        Input input;
        if (in != null && data.equals("")) {
            try {
                input = new InputFile(in);
                textInputFile = input.read();
                data = textInputFile;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");;
            }
        }
        resultText = callAlgorithm();
        Output output;
        if (out != null) {
            try {
                output = new OutputFile(out, resultText);
                output.print();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(resultText);
        }
    }

    private String callAlgorithm() {
        ContextAlg chooseAlg = new ContextAlg();
        if (alg.equals("shift") && cmd.equals("enc")) {
            chooseAlg.setAlgorithm(new AlgorithmShiftEncryption());
            return chooseAlg.perform(data, key);
        } else if (alg.equals("shift") && cmd.equals("dec")) {
            chooseAlg.setAlgorithm(new AlgorithmShiftDecryption());
            return chooseAlg.perform(data, key);
        } else if (alg.equals("unicode") && cmd.equals("enc")) {
            chooseAlg.setAlgorithm(new AlgorithmUnicodeEncryption());
            return chooseAlg.perform(data,key);
        } else if (alg.equals("unicode") && cmd.equals("dec")) {
            chooseAlg.setAlgorithm(new AlgorithmUnicodeDecryption());
            return chooseAlg.perform(data, key);
        } else throw new UnsupportedOperationException();
    }
}
