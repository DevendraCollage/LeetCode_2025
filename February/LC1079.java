/*
 * LC1079 - Letter Tile Possibilities
 */

import java.util.HashSet;
import java.util.Scanner;

public class LC1079 {
    static int len;

    public static int numTilePossibilities(String tiles) {
        len = tiles.length();
        boolean[] used = new boolean[len];
        HashSet<String> set = new HashSet<>();
        backTrack(tiles, used, set, "");
        return set.size() - 1;
    }

    public static void backTrack(String tiles, boolean[] used, HashSet<String> set, String cur) {
        if (set.contains(cur)) {
            return;
        }
        set.add(cur);
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            backTrack(tiles, used, set, cur + tiles.charAt(i));
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String tiles = sc.nextLine();
        System.out.println();

        int ans = numTilePossibilities(tiles);

        System.out.println(ans);

        sc.close();
    }
}