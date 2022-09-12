import java.io.IOException;
import java.io.*;
import java.util.Scanner;

class Test {

    public static void main(String[] args) throws IOException {
        double a = 0.0;
        double b = 0.0;
        Boolean flag = true;
        char znak = ' ';
        String slovo = "";
        String Finish = "";

        String fileSeparator = System.getProperty("file.separator");
        String relativePath = "src" + fileSeparator + "input.txt";
        File file = new File(relativePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            slovo = sc.nextLine();


            try {
                a = Double.parseDouble(slovo.split(" ")[0]);
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number");
                Finish = Finish + "Error! Not number\n";
                flag = false;
            }

            try {
                if (flag) {
                    b = Double.parseDouble(slovo.split(" ")[2]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number");
                Finish = Finish + "Error! Not number\n";
                flag = false;
            }

            if (flag) {
                if (slovo.split(" ")[1].equals("/") || slovo.split(" ")[1].equals("*") || slovo.split(" ")[1].equals("+") || slovo.split(" ")[1].equals("-")) {
                    znak = slovo.split(" ")[1].charAt(0);
                } else try {
                    throw new Exception("Operation Error!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    Finish = Finish + e.getMessage() + "\n";
                    flag = false;
                }
            }

            if (flag) {
                switch (znak) {
                    case ('+'):
                        System.out.println(a + " " + znak + " " + b + " = "  + (a + b));
                        Finish = Finish + a + " " + znak + " " + b + " = "  + (a + b) + "\n";
                        break;
                    case ('-'):
                        System.out.println(a + " " + znak + " " + b + " = "  + (a - b));
                        Finish = Finish + a + " " + znak + " " + b + " = "  + (a - b) + "\n";
                        break;
                    case ('*'):
                        System.out.println(a + " " + znak + " " + b + " = "  + (a * b));
                        Finish = Finish + a + " " + znak + " " + b + " = "  + (a * b) + "\n";
                        break;
                    case ('/'):
                        if (b != 0.0) {
                            System.out.println(a + " " + znak + " " + b + " = "  + (a / b));
                            Finish = Finish + a + " " + znak + " " + b + " = "  + (a / b) + "\n";
                        } else try {
                            throw new Exception("Error! Division by zero");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            Finish = Finish + e.getMessage() + "\n";
                        }
                        break;
                }
            }
        }
        zapis(Finish);
    }

    public static void zapis(String TextOut) throws FileNotFoundException {
        String fileSeparator = System.getProperty("file.separator");
        String relativePathOut = "src" + fileSeparator + "output.txt";

        try(FileOutputStream fos=new FileOutputStream(relativePathOut);
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.append(TextOut);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}