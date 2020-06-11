import java.util.Scanner;

public class TicTactToe {
    static String current = "X";
    static String[] arr = new String[9];
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            arr[i] = " ";
        }

        while (true) {
            viewTable();

            if (current.equals("X")) {
                if (win("O")) {
                    System.out.println("O wins");
                    return;
                }
            } else {
                if (win("X")) {
                    System.out.println("X wins");
                    return;
                }
            }

            if (isComplete()) {
                System.out.println("Draw");
                return;
            }

            boolean exit = false;
            while (!exit) {
                System.out.print("Enter the coordinates: ");
                String[] coords = scanner.nextLine().split(" ");
                int x;
                int y;
                try {
                    if (coords.length == 1) {
                        x = Integer.parseInt(coords[0]);
                    } else if (coords.length == 2) {
                        x = Integer.parseInt(coords[0]);
                        y = Integer.parseInt(coords[1]);
                        if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3)) {
                            String str = x+""+y;
                            switch (str) {
                                case "13":
                                    exit = method(0);
                                    break;
                                case "23":
                                    exit = method(1);
                                    break;
                                case "33":
                                    exit = method(2);
                                    break;
                                case "12":
                                    exit = method(3);
                                    break;
                                case "22":
                                    exit = method(4);
                                    break;
                                case "32":
                                    exit = method(5);
                                    break;
                                case "11":
                                    exit = method(6);
                                    break;
                                case "21":
                                    exit = method(7);
                                    break;
                                case "31":
                                    exit = method(8);
                                    break;
                            }
                        } else {
                            System.out.println("Coordinates should be from 1 to 3!");
                        }
                    }
                } catch(NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                }
            }
            current = current.equals("X") ? "O" : "X";
        }
    }

    static void viewTable() {
        System.out.println("---------");
        System.out.println("| " + arr[0] + " " + arr[1] + " " + arr[2] + " |");
        System.out.println("| " + arr[3] + " " + arr[4] + " " + arr[5] + " |");
        System.out.println("| " + arr[6] + " " + arr[7] + " " + arr[8] + " |");
        System.out.println("---------");
    }

    static boolean method(int i) {
        if (arr[i].equals("X") || arr[i].equals("O")) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            arr[i] = current;
            return true;
        }
    }

    static boolean win(String i) {
        boolean row1 = (arr[0].equals(i) && arr[1].equals(i) && arr[2].equals(i));
        boolean row2 = (arr[3].equals(i) && arr[4].equals(i) && arr[5].equals(i));
        boolean row3 = (arr[6].equals(i) && arr[7].equals(i) && arr[8].equals(i));
        boolean column1 = (arr[0].equals(i) && arr[3].equals(i) && arr[6].equals(i));
        boolean column2 = (arr[1].equals(i) && arr[4].equals(i) && arr[7].equals(i));
        boolean column3 = (arr[2].equals(i) && arr[5].equals(i) && arr[8].equals(i));
        boolean diagonal1 = (arr[0].equals(i) && arr[4].equals(i) && arr[8].equals(i));
        boolean diagonal2 = (arr[2].equals(i) && arr[4].equals(i) && arr[6].equals(i));
        return (row1 || row2 || row3 || column1 || column2 || column3 || diagonal1 || diagonal2);
      }

      static boolean isComplete() {
          for (int i = 0; i < arr.length; i++) {
              if (arr[i].equals(" ")) {
                  return false;
              }
          }
          return true;
      }
}
