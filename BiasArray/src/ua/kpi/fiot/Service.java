package ua.kpi.fiot;

public class Service {

    public void biasOfMatrix(int sizeOfMatrix, int sizeOfBias){

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] biasMatrix = new int[sizeOfMatrix][sizeOfMatrix];
        int bias = 0;

        System.out.println("Generated matrix : ");

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random()*10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Bias matrix : ");

        if(sizeOfBias > sizeOfMatrix){
            bias = sizeOfBias%sizeOfMatrix;
        } else if(sizeOfBias == sizeOfMatrix){
            for (int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        } else {
            bias = sizeOfBias;
        }

        for (int i = 0; i < biasMatrix.length; i++){
            for (int j = 0; j < biasMatrix[i].length; j++){
                if (j + bias >= biasMatrix[i].length){
                    biasMatrix[i][Math.abs(bias - j - 1)] = matrix[i][j];
                } else {
                    biasMatrix[i][j + bias] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(biasMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
