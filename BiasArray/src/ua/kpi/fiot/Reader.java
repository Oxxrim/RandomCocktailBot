package ua.kpi.fiot;

import java.util.Scanner;

public class Reader {

    public void readInfo(){
        int sizeOfmatrix;
        int biasSize;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of matrix : ");
        sizeOfmatrix = in.nextInt();
        System.out.print("Enter size of bias : ");
        biasSize = in.nextInt();

        Service service = new Service();
        service.biasOfMatrix(sizeOfmatrix, biasSize);
    }
}
