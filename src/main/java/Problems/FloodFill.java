package Problems;

import java.util.Arrays;

public class FloodFill {
    public static void main(String [] args){
        int[][] res= floodFill(new int[][]{{0,1},{1,2},{3,4}},1,1,2);
        System.out.println(Arrays.deepToString(res));
    }

        public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) return image;

            dfs(image, sr, sc, oldColor, newColor);
            return image;
        }

        private static void dfs(int[][] img, int r, int c, int oldColor, int newColor) {
            if (r < 0 || c < 0 || r >= img.length || c >= img[0].length) return;
            if (img[r][c] != oldColor) return;

            img[r][c] = newColor;

            dfs(img, r+1, c, oldColor, newColor);
            dfs(img, r-1, c, oldColor, newColor);
            dfs(img, r, c+1, oldColor, newColor);
            dfs(img, r, c-1, oldColor, newColor);
        }
    }

