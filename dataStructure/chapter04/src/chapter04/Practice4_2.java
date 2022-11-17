package chapter04;

public class Practice4_2 {

	public static void main(String[] args) {
        print(4);
    }

    static void space(int space)
    {
        if (space == 0)
            return;
        System.out.print(" ");

        space(space - 1);
    }

    static void asterisk(int asterisk)
    {
        if (asterisk == 0) {
            return;
        }
        System.out.print("* ");
        asterisk(asterisk - 1);
    }

    static void print(int n)
    {
        if (n == 0) {
            return;
        }

        space(n - 1);
        asterisk(5 - n);
        System.out.println("");

        print(n - 1);
    }
}
