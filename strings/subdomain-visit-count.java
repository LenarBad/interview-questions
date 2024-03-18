/*
Example 1:

Input: cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
Explanation: We only have one website domain: "discuss.leetcode.com".
As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
Example 2:

Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
*/


public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> counts = new HashMap();
    for (String record : cpdomains) {
        String[] entries = record.split(" ");
        int visits = Integer.parseInt(entries[0]);
        String[] domains = entries[1].split("\\.");
        String domain = domains[domains.length - 1];
        counts.put(domain, counts.getOrDefault(domain, 0) + visits);
        for (int i = domains.length - 2;  i >= 0; i-- ) {
            domain = domains[i] + "." + domain;
            counts.put(domain, counts.getOrDefault(domain, 0) + visits);
        }
    }
    return counts.entrySet().stream()
            .map(entry -> entry.getValue() + " " + entry.getKey())
            .collect(Collectors.toList());
}
