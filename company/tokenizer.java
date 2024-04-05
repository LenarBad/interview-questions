public class Tokenizer {
  private Set<String> dictionary;

  public Tokenizer(List<String> dictionary) {
    this.dictionary = new HashSet<String>(dictionary);
  }

  public Tokenizer(String[] dictionary) {
    this.dictionary = new HashSet<String>(Arrays.asList(dictionary));
  }

  public List<String> tokenize(String text) {
    List<String> result = new ArrayList();
    char[] chars = text.toCharArray();
    String word = "";
    for (char char : chars) {
      word = word + char;
      if (dictionary.contains(word)) {
        result.add(word);
        word = "";
      }
    }
    return result;
  }

}
