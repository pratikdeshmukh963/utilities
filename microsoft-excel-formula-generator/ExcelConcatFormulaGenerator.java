import java.util.ArrayList;
import java.util.List;

public class ExcelConcatFormulaGenerator {

	public static void main(String[] args) {

		if (args == null || args.length != 1) {
			System.err.println("Illegal arguments.");
		}
		int noOfColumns = Integer.parseInt(args[0]);

		System.out.println(generateConcatString(noOfColumns));
	}

	private static String generateConcatString(int noOfColumns) {
		List<String> columns = generateColumnLetters(noOfColumns);
		StringBuilder concatBuilder = new StringBuilder(2000);
		for (String col : columns) {
			concatBuilder.append("$").append(col).append("$").append(1).append(",\"=\",").append("\"'\",").append(col)
					.append("2,").append("\"'\",\",\",");
		}
		int len = concatBuilder.length();
		return concatBuilder.delete(len - 5, len).toString();
	}

	private static List<String> generateColumnLetters(int noOfColumns) {
		List<String> columns = new ArrayList<>();
		for (int i = 1; i <= noOfColumns; i++) {
			columns.add(getColumnName(i));
		}
		return columns;
	}

	private static String getColumnName(int columnNumber) {
		// To store result (Excel column name)
		StringBuilder columnName = new StringBuilder(3);

		while (columnNumber > 0) {
			// Find remainder
			int rem = columnNumber % 26;

			// If remainder is 0, then a
			// 'Z' must be there in output
			if (rem == 0) {
				columnName.append("Z");
				columnNumber = (columnNumber / 26) - 1;
			} else // If remainder is non-zero
			{
				columnName.append((char) ((rem - 1) + 'A'));
				columnNumber = columnNumber / 26;
			}
		}
		return columnName.reverse().toString();
	}

}