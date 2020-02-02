package no.wit.minesweeper;

public class Minesweeper {
    private String[] field;

    public Minesweeper(String[] field) {
        this.field = field;
    }


    public String[] calculateHints() {
        String[] outputRows = new String[field.length];
        for (int row = 0; row < field.length; row++) {
            String outputRow = "";
            String line = field[0];
            for (int col = 0; col < line.length(); col++) {
                outputRow += getSqr(row, col);
            }
            outputRows[row] = outputRow;
        }
        return outputRows;
    }

    private String getSqr(int row, int col) {
        if (isMine(row, col)) {
            return "*";
        }
        int sqrValue = 0;
        if (isMine(row - 1, col)) sqrValue += 1;
        if (isMine(row, col - 1)) sqrValue += 1;
        if (isMine(row, col + 1)) sqrValue += 1;
        if (isMine(row + 1 , col)) sqrValue += 1;

        if (isMine(row - 1 , col -1)) sqrValue += 1;
        if (isMine(row + 1 , col +1)) sqrValue += 1;
        if (isMine(row + 1 , col -1)) sqrValue += 1;
        if (isMine(row - 1 , col +1)) sqrValue += 1;
        return String.valueOf(sqrValue);
    }

    private boolean isMine(int row, int col) {
        if (row < 0 || field.length <= row) return false;
        if (col < 0 || field[row].length() <= col) return false;
        return field[row].charAt(col) == '*';
    }

}
