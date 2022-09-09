import java.util.Scanner;

class Test {

    public static void main(String[] args) {
        double a = 0.0;
        double b = 0.0;
        Boolean flag = true;
        char znak = ' ';
        String slovo = "";

        Scanner sc = new Scanner(System.in);
        slovo = sc.nextLine();
        try {
            a = Double.parseDouble(slovo.split(" ")[0]);
        }
        catch (NumberFormatException e) {
            System.out.print("Error! Not number");
            flag = false;
        }
        try {
            if (flag) {
                b = Double.parseDouble(slovo.split(" ")[2]);
            }
        }
        catch (NumberFormatException e) {
            System.out.print("Error! Not number");
            flag = false;
        }
        if (flag) {
            if (slovo.split(" ")[1].equals("/") || slovo.split(" ")[1].equals("*") || slovo.split(" ")[1].equals("+") || slovo.split(" ")[1].equals("-")) {
                znak = slovo.split(" ")[1].charAt(0);
            } else try {
                throw new Exception("OperationError");
            } catch (Exception e) {
                System.out.print(e.getMessage());
                flag = false;
            }
        }
        if (flag){
            switch(znak){
                case('+'): System.out.print(a + b);
                break;
                case('-'): System.out.print(a - b);
                break;
                case('*'): System.out.print(a * b);
                break;
                case('/'):
                    if (b != 0.0) {
                        System.out.print(a / b);
                    } else try {
                        throw new Exception("Error! Division by zero");
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
            }
        }
    }
}