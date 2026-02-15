class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = row.size() - 2; j >= 1; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }
}