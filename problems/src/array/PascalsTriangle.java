package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 25/03/2017.
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 杨辉三角
 */
public class PascalsTriangle {
    public static void main(String[] args) throws Exception {
        System.out.println(new PascalsTriangle().getRow(4));
        List<List<Integer>>  tests = new PascalsTriangle().generate(4);
        System.out.println(new PascalsTriangle().generate(4));
        for (int i = 0 ;i<tests.size();i++)
        {
            System.out.println(tests.get(i).toString());
        }

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
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }


}
