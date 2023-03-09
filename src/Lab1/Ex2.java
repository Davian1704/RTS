package Lab1;

import java.util.Scanner;

public class Ex2 {
    private int[][] matrix1,matrix2;

    public Ex2() {
        Scanner scanner = new Scanner(System.in);
        matrix1 = new int[][]{{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        matrix2 = new int[][]{{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};
    }
    public void sum(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print((matrix1[i][j]+matrix2[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.print("\n");
    }

    public void prod(){
        int resultarray[][]=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                resultarray[i][j]=0;
                for(int k=0;k<3;k++)
                {
                    resultarray[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                System.out.print(resultarray[i][j] + " ");
            System.out.println();
        }
    }
    static public void main(String[] args){
        Ex2 ex2 = new Ex2();
        ex2.sum();
        ex2.prod();
    }
}
