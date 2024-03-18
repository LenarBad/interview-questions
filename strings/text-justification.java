/*
Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
*/


public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> lines = new ArrayList();
    int charCount = 0;
    List<String> lineWords = new ArrayList();
    for (String word : words) {
        if (lineWords.isEmpty()) {
            lineWords.add(word);
            charCount = word.length();
        } else if (charCount + word.length() + 1 <= maxWidth) {
                lineWords.add(word);
                charCount += word.length() + 1;
        } else {
            if (lineWords.size() == 1) {
                lines.add(alignLeft(lineWords, maxWidth));
            } else {
                lines.add(justify(lineWords, maxWidth, charCount - lineWords.size() + 1));
            }
            lineWords = new ArrayList(Arrays.asList(word));
            charCount = word.length();
        }
    } 
    if (!lineWords.isEmpty()) {
        lines.add(alignLeft(lineWords, maxWidth));
    }
    return lines;
}

private String justify(List<String> lineWords, int maxWidth, int charsInWords) {
    int countToFill = maxWidth - charsInWords;
    int intervals = lineWords.size() - 1;
    String delimiter = " ".repeat(countToFill / intervals);
    if (countToFill % intervals == 0) {
        return String.join(delimiter, lineWords);
    } else {
        String result = lineWords.get(0);
        for (int i = 1; i <= intervals; i++) {
            result += i <= countToFill % intervals 
                        ? delimiter + " " + lineWords.get(i) 
                        : delimiter + lineWords.get(i);
        }
        return result;
    }
}

private String alignLeft(List<String> lineWords, int maxWidth) {
    String result = lineWords.get(0);
    for (int i = 1; i < lineWords.size(); i++) {
        result += " " + lineWords.get(i);
    }    
    return result + " ".repeat(maxWidth - result.length());
}
