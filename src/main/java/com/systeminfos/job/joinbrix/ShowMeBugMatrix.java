package com.systeminfos.job.joinbrix;

import java.util.Arrays;
import java.util.List;

public class ShowMeBugMatrix {

    /**
     * 二维数据输出格式更新
     *
     * @param matrix
     * @return
     */
    public int[][] solution(int[][] matrix) {
        // Write your code here

        int xLenght = matrix.length; //2
        int yLenght = matrix[0].length; // 3

        int swapMatrix[][] = new int[yLenght][xLenght];

        for (int y = 0; y < yLenght; y++) {
            for (int x = 0; x < xLenght; x++) {
                swapMatrix[y][x] = matrix[x][y];
            }
        }
        return swapMatrix;
    }


    public static void main(String[] args) {
        ShowMeBugMatrix bug = new ShowMeBugMatrix();

        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        int[][] solution = bug.solution(matrix);
        List<int[]> list = Arrays.asList(solution);
        list.stream().forEach(e -> {
            Arrays.stream(e).forEach(f -> System.out.print(f + " "));
            System.out.println();
        });
//1 4
//2 5
//3 6
    }

}