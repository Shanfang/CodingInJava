import java.util.*;

public class Palindrome {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		ArrayList<String> partition = new ArrayList<>();
		palindromeUtil(s, 0, partition, result);
		return result;
	}

	private void palindromeUtil(String s, int start, ArrayList<String> partition,
								List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(partition));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			String substr = s.substring(start, i + 1);
			if (!isPalindrome(substr)) {
				continue;
			}

			partition.add(substr);
			palindromeUtil(s, i + 1, partition, result);
			partition.remove(partition.size() - 1);
		}
	}

	private boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		List<List<String>> result = palindrome.partition("gogators");
		for (List<String> list : result) {
			for (String word : list) {
				System.out.println(word);	
			}
		}
	}

}