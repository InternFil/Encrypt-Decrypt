# Encrypt-Decrypt

The program allows you to encrypt and decrypt text in several ways.
The first one is shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle).
The second one is based on Unicode table.

If there is no -mode, the program works in enc mode.
If there is no -key, the program considers that key = 0.
If there is no -data, and there is no -in the program assume that the data is an empty string.
If there is no -out argument, the program prints data to the standard output.
If there are both -data and -in arguments, program prefers -data over -in.

All flags:
-mode
-data
-alg
-in
-out
-key

Example: -mode enc -in input.txt -out output.txt -key 5 -alg unicode
