
// Initialize variables:
// maxDia=-∞(to track the maximum diagonal²found so far)
// maxArea=0(to track the maximum area corresponding to the longest diagonal)
// Iterate through each rectangle in dimensions:
// Let l=dimensions[i][0](length of the rectangle).
// Let w=dimensions[i][1](width of the rectangle).
// Compute diagonal squared:
// dia=(l*l)+(w*w)
// (We use squared value instead of actual diagonal length to avoid square roots and floating-point errors.)
// Compare with current maximum diagonal:
// If dia>maxDia:
// Update maxDia=dia
// Update maxArea=l*w(area of this rectangle becomes the new best)
// Else if dia==maxDia:
// Update maxArea=max(maxArea,l*w)(keep the rectangle with the larger area in case of a diagonal tie)
// After checking all rectangles,return maxArea.

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDia = Integer.MIN_VALUE;
        int maxArea = 0;

        for (int i = 0; i < dimensions.length; i++) {

            int l = dimensions[i][0];
            int w = dimensions[i][1];

            int dia = (l * l) + (w * w);
            if (dia > maxDia) {
                maxDia = dia;
                maxArea = l * w;
            } else if (dia == maxDia) {
                maxArea = Math.max(maxArea, (l * w));
            }
        }

        return maxArea;
    }
}