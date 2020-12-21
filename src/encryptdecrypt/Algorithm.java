package encryptdecrypt;

public interface Algorithm {

    String perform(String data, int key);
}

class ContextAlg {

    Algorithm algorithm;

    void setAlgorithm(Algorithm alg) {
        this.algorithm = alg;
    }

    String perform(String data, int key) {
        return this.algorithm.perform(data, key);
    }
}

class AlgorithmUnicodeEncryption implements Algorithm {

    @Override
    public String perform(String data, int key) {
        int codePoint;
        char[] charArray = data.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            codePoint = charArray[i];
            charArray[i] = (char) (codePoint + key);
        }
        return String.valueOf(charArray);
    }
}

class AlgorithmUnicodeDecryption implements Algorithm {

    @Override
    public String perform(String data, int key) {
        int codePoint;
        char[] charArray = data.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            codePoint = charArray[i];
            charArray[i] = (char) (codePoint - key);
        }
        return String.valueOf(charArray);
    }
}

class AlgorithmShiftEncryption implements Algorithm {

    @Override
    public String perform(String data, int key) {
        int codePoint;
        char[] charArray = data.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            codePoint = charArray[i];
            if (codePoint > 64 && codePoint < 91) {
                if ((codePoint + key) > 90) {
                    int x = codePoint + key - 91;
                    charArray[i] = (char) (65 + x);
                } else {
                    charArray[i] = (char) (codePoint + key);
                }
            } else if (codePoint > 96 && codePoint < 123) {
                if ((codePoint + key) > 122) {
                    int x = codePoint + key - 123;
                    charArray[i] = (char) (97 + x);
                } else {
                    charArray[i] = (char) (codePoint + key);
                }
            }
            else {
                continue;
            }
        }
        return String.valueOf(charArray);
    }
}

class AlgorithmShiftDecryption implements Algorithm {

    @Override
    public String perform(String data, int key) {
        int codePoint;
        char[] charArray = data.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            codePoint = charArray[i];
            if (codePoint > 64 && codePoint < 91) {
                if ((codePoint - key) < 65) {
                    int x = codePoint - key - 65;
                    charArray[i] = (char) (91 + x);
                } else {
                    charArray[i] = (char) (codePoint - key);
                }
            } else if (codePoint > 96 && codePoint < 123) {
                if ((codePoint - key) < 97) {
                    int x = codePoint - key - 97;
                    charArray[i] = (char) (123 + x);
                } else {
                    charArray[i] = (char) (codePoint - key);
                }
            }
            else {
                continue;
            }
        }
        return String.valueOf(charArray);
    }
}