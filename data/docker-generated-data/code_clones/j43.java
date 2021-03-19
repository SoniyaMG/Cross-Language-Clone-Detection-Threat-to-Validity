public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int ra = 0;
        int rb = 0;
        if(a0 > b0) {
            ra++;
        } else if(a0 < b0) {
            rb++;
        }
        if(a1 > b1) {
            ra++;
        } else if(a1 < b1) {
            rb++;
        }
        if(a2 > b2) {
            ra++;
        } else if(a2 < b2) {
            rb++;
        }
        System.out.println(ra + " " + rb);
    }
}