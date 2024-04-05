public class FuzzySearch {
  private List<Set<String>> words;
  public FuzzySearch(List<String> jobs) {
    words = new ArrayList();
    for (int i = 0; i < jobs.size(); i++) {
      words.add(new HashSet<String>(Arrays.asList(jobs.get(i).split())));
    }
  }

  public List<Integer> searchJobIds(String query, int limit) {
    Map<Integer, Integer>> matches = new HashMap();
    Set<String> keywords = new HashSet<String>(Arrays.asList(query.split()));
    for (int i = 0; i < words.size(); i++) {
      int count = 0;
      for (String keyword : keywords) {
        if (words.get(i).contains(keyword)) {
          count++;
        }
      }
      if (count > 0) {
        matches.put(i, count);
      }
    }
    if (matches.isEmpty()) {
      // do what?
    }
    return matches.entrySet().stream()
              .sort((a, b) -> Integer.compare(b.getValue() - a.getValue()))
              .limit(limit)
              .collect(Collectors.toList());
  }
  
}
