
import java.util.Random;
import java.util.Scanner;

public class LuckyNumber {

    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        String sYes1 = "y";
        String sYes2 = "yes";
        int totalGames = 0;
        int totalGuesses = 0;
        int minNumGuesses = MAX;
        int guessCount = 0;

        do {
            guessCount = play(sc);
            // Kiểm tra số lần dự đoán ít nhất
            if(guessCount < minNumGuesses) {
                minNumGuesses = guessCount;
            }
            totalGuesses += guessCount; // Tính tổng số lần dự đoán của toàn bộ các lần đoán
            System.out.print("Do you want to play again? ");
            String str = sc.next();
            // Kiểm tra xem người chơi muốn chơi tiếp hay dừng lại
            if(str.equalsIgnoreCase(sYes1) || str.equalsIgnoreCase(sYes2)) {
                check = true;
            } else {
                check = false;
            }
            totalGames++; // Tính tổng số lần chơi
            System.out.println();
        } while (check);

        // In ra kết quả tổng quát của trò chơi
        report(totalGames, totalGuesses, minNumGuesses);
    }

    // Hàm tạo ra số ngẫu nhiên, kiểm tra số người dùng nhập vào với số được tạo ra
    public static int play(Scanner sc) {
        int guessNum;
        int guessCount = 1;
        boolean check = true;

        Random num = new Random(); // Tạo một biến random
        int ranNum = num.nextInt(MAX + 1); // Sinh ra một số ngẫu nhiên trong khoảng từ 0 đến MAX
        System.out.println("I'm thinking of a number between 0 and 100...");

        while(check) {
            System.out.print("Your guess? ");
            guessNum = sc.nextInt();

            // So sánh số người dùng nhập vào và số được tạo ra
            if(guessNum == ranNum) {
                System.out.println("You got it right in " + guessCount + " guesses!");
                check = false;
            } else if (guessNum > ranNum && guessNum <= MAX) {
                System.out.println("It's lower.");
                guessCount++;
            } else if (guessNum < ranNum && guessNum >= 0) {
                System.out.println("It's higher.");
                guessCount++;
            } else {
                System.out.println("Your number is out of range.");
            }
        }
        return guessCount;
    }

    // Hàm in ra kết quả tổng quát
    public static void report(int totalGames, int totalGuesses, int minNumGuesses) {
        float guessAvg = (float) totalGuesses / (float) totalGames; // Tính số dự đoán trung bình
        guessAvg = (float) Math.round(guessAvg * 10) / 10; // Làm tròn số gồm 1 số thập phân
        System.out.println("Overall results: ");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/games = " + guessAvg);
        System.out.println("Best game     = " + minNumGuesses);
    }
}
