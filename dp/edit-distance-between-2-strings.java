// Find the edit distance between 2 strings, for example "abcdef" and "acdbfe"
// Edit distance - number of edits like removal/insertion/substitution

// Match = 0; Substitution = 1;
// abcde - f
// acdbf - e
// distance("abcdef", "acdbfe") = distance("abcde", "acdbf") + ('f' == 'e' ? 0 : 1);

// Insertion = 1
// abcdef
//  acdbf - e
// distance("abcdef", "acdbfe") = distance("abcdef", "acdbf") + 1;

// Removal = 1
//  abcde - f
// acdbfe
// distance("abcdef", "acdbfe") = distance("abcde", "acdbfe") + 1;

// a = "abcdef"; b = "acdbfe";
// i - length of a, j - length of b
// distance(i, j) = MIN(distance(i - 1, j - 1) + (a[i-1] == b[j-1] ? 0 : 1), distance(i, j - 1) + 1, distance(i - 1, j) + 1);

// base case
// (0, j) -> j
// (i, 0) -> i

public int editDistance(String a, String b) {
  int[][] distance = new int[a.length()][b.length()];
  for (int i = 0; i <= a.length(); i++) {
    distance[i][0] = i;
  }
  for (int j = 0; j <= a.length(); j++) {
    distance[0][j] = j;
  }
  for (int i = 1; i <= a.length(); i++) {
    for (int j = 1; j <= b.length(); j++) {
      int min = Math.min(distance[i, j - 1] + 1, distance(a, b, i - 1, j) + 1);
      distance[i][j] = Math.min(min, distance[i - 1][j - 1] + (a[i-1] == b[j-1] ? 0 : 1));
    }
  }
  return distance[a.length()][b.length()];
}
