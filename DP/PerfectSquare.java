public class PerfectSquare {

    public int numSquares(int n) {
        // Write your code here
        if (isSquare(n)) {
            return 1;
        }
        int [] perfect = new int[n + 1];
        perfect[1] = 1;
        
        for (int i = 1; i <= n; i++) {
            if (isSquare(i)) {
                perfect[i] = 1; 
                System.out.println("Here is a perfect square!");
                continue;
            }
            
            perfect[i] = i;
            for (int j = 1; j < i; j++) {
                //if (perfect[i] > perfect[j] + perfect[i - j]) {
                System.out.println("i is: " + i + ",   j is: " + j);
                perfect[i] = Math.min(perfect[i], perfect[j] + perfect[i - j]);
            }
        }
        return perfect[n];
    }
    
    private boolean isSquare(int number) {
        for (int i = 1; i < Math.sqrt(number) + 1; i++) {
            if (i * i == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arg) {
        PerfectSquare square = new PerfectSquare();
        square.numSquares(100000);
    }
}