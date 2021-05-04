/* Course: CS2852-011
 * fall 2020
 * Lab 7: Morse Encoder with a BST Map
 * Name: Ian Gresser
 * Created: 10-22-20
 */
package msoe.cs2852.lab07;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Class that takes a MorseCode file, encrypts a user given string
 */
public class MorseEncoder {

    public MSOEBSTMap msoebstMap = new MSOEBSTMap();



    public static void main(String[] args) {
        MorseEncoder morseEncoder = new MorseEncoder();
        morseEncoder.run();
    }

    /**
     * will run the menu that lets users type in file and user string
     */
    public void run(){
        try {
            int exit = 1;

            while (exit == 1) {
                System.out.println("Type one of the number options to use a function:");
                System.out.println("1. Load morse file");
                System.out.println("2. Encode message");
                System.out.println("3. Exit");
                Scanner scanner = new Scanner(System.in);
                String chooseAction = scanner.nextLine().toLowerCase();
                if (chooseAction.equals("1")) {
                    System.out.println("give file");
                    String chooseFile = scanner.nextLine();
                    Path path = Paths.get(chooseFile);
                    
                    loadPath(path);

                } else if (chooseAction.equals("2")) {
                    System.out.println("give file to encrypt");
                    String userMessage = scanner.nextLine();
                    Path path = Paths.get(userMessage);
                    System.out.println(encodeMessage(path));

                } else if (chooseAction.equals("3")) {
                    exit = 0;
                } else {
                    System.out.println("Please type in a valid response");
                }
                System.out.println("\n");
            }
        } catch (FileNotFoundException e){
            System.out.println("Please select a valid file\n");
            run();
        } catch (IllegalArgumentException e){
            System.out.println("Please make sure the file has only '-' or '.' characters\n");
            run();
        }
    }

    /**
     * loads a MorseCode file to encrypt by
     * @param path path of the Morse file
     * @throws FileNotFoundException required by scanner
     */
    public void loadPath(Path path)throws FileNotFoundException {
        Scanner reader = new Scanner(path.toFile());
        while (reader.hasNextLine()) {
            while (reader.hasNext()) {
                String line = reader.nextLine();
                Character key = line.charAt(0);
                Character key2 = ' ';
                String value = line.substring(1);
                if (line.charAt(0) == '\\') {
                    if (line.charAt(1) == 'n') {
                        key = '\\';
                        key2 = 'n';
                        value = line.substring(2);
                    }
                }
                msoebstMap.put(key, value);

            }


        }
    }


    /**
     *
     * @param path path of file to encode
     * @return encoded message
     * @throws FileNotFoundException for scanner
     */
    public String encodeMessage(Path path) throws FileNotFoundException {
        Scanner reader = new Scanner(path.toFile());
        String encodedMessage = "";
        String errorMessage = "";
        while (reader.hasNextLine()) {
            String message = reader.nextLine();
            for (int i = 0; i < message.length(); i++) {
                Character currChar = message.toUpperCase().charAt(i);
                if (currChar == '\\') {
                    Character nextChar = message.charAt(i + 1);
                    if (nextChar == 'n') {
                        encodedMessage += "\n";
                    }
                }

                if (msoebstMap.containsKey(currChar)) {
                    encodedMessage += msoebstMap.get(currChar) + " ";
                } else {
                    errorMessage += "Warning: skipping: " + currChar + "\n";
                }
            }

        }
        return errorMessage + encodedMessage;
    }


}
