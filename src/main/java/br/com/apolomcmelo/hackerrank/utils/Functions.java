package br.com.apolomcmelo.hackerrank.utils;

public class Functions {
  // Permute
  public <T> void permute(int n, int[] arr) {
    if(n == 1) {
      printArray(arr);
    } else {
      for(int i = 0; i < n-1; i++) {
        permute(n - 1, arr);
        if(n % 2 == 0) {
          swap(arr, i, n-1);
        } else {
          swap(arr, 0, n-1);
        }
      }
      permute(n - 1, arr);
    }
  }

  private <T> void printArray(int[] input) {
    System.out.print('\n');
    for(int i = 0; i < input.length; i++) {
      System.out.print(input[i]);
    }
  }

  //        List<String> lists = Arrays.asList("teste", "teia", "tédio");
//
//         Set<String> result = lists.stream().filter(word -> word.startsWith("te")).collect(Collectors.toSet());
//        System.out.println(result.toArray().toString());
//
//        String teste = "teste anything";
//        String splited = teste.substring(0, 3);
//
//        System.out.println(teste);
//        System.out.println(teste.substring("code"));
//      int N = 5;

  // Test Case 1
//      int mat[][] = {
//          { 1, 2, 3, 4 },
//          { 5, 6, 7, 8 },
//          { 9, 10, 11, 12 },
//          { 13, 14, 15, 16 }
//      };

  // Tese Case 2
//        int mat[][] = {
//                            {1, 2, 3},
//                            {4, 5, 6},
//                            {7, 8, 9}
//                        };


  // Tese Case 3
//        int mat[][] = {
//                        {1, 2},
//                        {4, 5}
//                    };

//      int mat[][] = {
//          { 1, 2, 3, 4, 5 },
//          { 6, 7, 8, 9, 10 },
//          { 11, 12, 13, 14, 15 },
//          { 16, 17, 18, 19, 20 },
//           { 21, 22, 23, 24, 25 },
//      };
//
//      Printer.printMatrixOutput(N, mat);
//      Functions functions = new Functions();
//      functions.rotateMatrix(N, mat);
//      Printer.printMatrixOutput(N, mat);

  // Rotate Matrix
  // An Inplace function to
  // rotate a n x n matrix
  // by 90 degrees in
  // anti-clockwise direction

  /**
   * To solve the question without any extra space, rotate the array in form of squares,
   * dividing the matrix into squares or cycles. For example, a 4 X 4 matrix will have 2 cycles.
   * The first cycle is formed by its 1st row, last column, last row and 1st column.
   * The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column.
   * The idea is for each square cycle, swap the elements involved with the corresponding cell in the matrix
   * in anti-clockwise direction i.e. from top to left, left to bottom, bottom to right and from right to top one
   * at a time using nothing but a temporary variable to achieve this.
   *
   *
   *
   * 1. There is N/2 squares or cycles in a matrix of side N. Process a square one at a time.
   *    Run a loop to traverse the matrix a cycle at a time, i.e loop from 0 to N/2 – 1, loop counter is i
   * 2. Consider elements in group of 4 in current square, rotate the 4 elements at a time.
   *    So the number of such groups in a cycle is N – 2*i.
   * 3. So run a loop in each cycle from x to N – x – 1, loop counter is y
   * 4. The elements in the current group is (x, y), (y, N-1-x), (N-1-x, N-1-y), (N-1-y, x),
   *    now rotate the these 4 elements, i.e:
   *    (x, y) <- (y, N-1-x), (y, N-1-x)<- (N-1-x, N-1-y), (N-1-x, N-1-y)<- (N-1-y, x), (N-1-y, x)<- (x, y)
   * @param n
   * @param mat
   */
  public void rotateMatrix(int n, int mat[][]) {
    // Consider all squares one by one
    for (int x = 0; x < n / 2; x++) {
      // Consider elements in group of 4 in current square
      for (int y = x; y < n - x - 1; y++) {
        // Store current cell in
        // temp variable
        int temp = mat[x][y];

        // Move values from right to top
        mat[x][y] = mat[y][n - 1 - x];

        // Move values from bottom to right
        mat[y][n - 1 - x] = mat[n - 1 - x][n - 1 - y];

        // Move values from left to bottom
        mat[n - 1 - x][n - 1 - y] = mat[n - 1 - y][x];

        // Assign temp to left
        mat[n - 1 - y][x] = temp;
      }
    }
  }

  // Sort

  // Swap
  private <T> void swap(int[] input, int a, int b) {
    int tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
  }
}
