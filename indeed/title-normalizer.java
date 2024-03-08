//  cleanTitles = {"Software Engineer", "Mechanical Engineer", "Cashier", ...}
//  scoring function = Number of overlapping
//  rawTitle = "I need Software Engineer"
//  rawTitle = "Software Engineer"
//  rawTitle = "Mechanical Engineer, USD100K"
//  rawTitle = "Mechanical Engineer"

public class Normalizer {
  private Map<String, Set<String>> keywordMap;  // "Engineer" -> {"Software Engineer", "Mechanical Engineer"}
  
  public Normalizer(final List<String> cleanTitles) {
    keywordMap = new HashMap();
    for (String title : cleanTitles) {
      for (String keyword : title.toLowerCase().split()) {
        if (!keyword.trim().isEmpty()) {
          if (keywordMap.containsKey(keyword)) {
            keywordMap.get(keyword).add(title);
          } else {
            Set<String> titles = new HashSet();
            titles.add(title);
            keywordMap.put(keyword, titles);
          }
        }
      }
    }
  }

  public String normalize(final String rawTitle) {
    Map<String, Integer> counts = new HashMap();
    int maxCount = 0;
    String bestMatch = "";
    for (String keyword : rawTitleToKeywords(rawTitle) {
      if (keywordMap.containsKey(keyword)) {
        for (String title : keywordMap.get(keyword)) {
          int number = counts.getOrDefault(title, 0);
          counts.put(title, number + 1);
          if (maxCount < number + 1) {
            maxCount = number + 1;
            bestMatch = title;
          }
        }
      }
    }
    return bestMatch;
  }

  // Need to improve if 
  private List<String> rawTitleToKeywords(String title) {
    return Arrays.asList(title.toLowerCase().trim().split());
  }
}
