package id.rata.testrata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRataApplication.class, args);
		
		int n = 3;
        
        int arr[][] =
        {
            {11, 2, 4},
            {4 , 5, 6},
            {10, 8, -12}
        };
      
        System.out.print("=== SELISIH DARI DUA ANGKA TOTAL DIAGONAL: " + logicTest(arr, n) + " ===");
	}
	
	public static int logicTest(int arr[][], int n)
    {
        int d1 = 0, d2 = 0;
      
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                // total diagonal kiri ke kanan
                if (i == j)
                    d1 += arr[i][j];
      
                // total diagonal kanan ke kiri
                if (i == n - j - 1)
                    d2 += arr[i][j];
            }
        }
      
        return Math.abs(d1 - d2);
    }

}
