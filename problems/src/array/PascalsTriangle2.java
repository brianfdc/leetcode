package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 另一种方法
 */
public class PascalsTriangle2 {
    public static void main(String[] args) throws Exception {
//        System.out.println(new PascalsTriangle().getRow(4));
        int k = 3;
        List<List<Integer>>  tests = new PascalsTriangle().generate(k);
        System.out.println(new PascalsTriangle().generate(k));
//        for (int i = 0 ;i<tests.size();i++)
//        {
//            System.out.println(tests.get(i).toString());
//        }



        System.out.println(tests.get(k-1).toString());

    }

    public List<Integer> getRow(int rowIndex) {
        int k = rowIndex;
        if (k == 0)
            return Arrays.asList(1);
        else if (k == 1)
            return Arrays.asList(1, 1);
        else if (k == 2)
            return Arrays.asList(1, 2, 1);
        List<Integer> result = new ArrayList<>();
        result.add(2);
        k = k - 2;
        int p, c;
        while (k-- > 0) {
            p = 1;
            int i = 0;
            for (int l = result.size(); i < l; i++) {
                c = result.get(i);
                result.set(i, p + c);
                p = c;
            }
            result.add(p + 1);
        }
        result.add(0, 1);
        result.add(1);
        return result;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                System.out.println(prevRow.get(j-1) +"+"+ prevRow.get(j));
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }


}
