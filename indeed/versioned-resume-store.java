public class ResumeStore {

  Map<String, Profile> profiles = new HashMap();
  
  public void update(String profileId, String field, String value) {
    if (profiles.containsKey(profileId) {
      profiles.get(profileId).update(field, value);
    } else {
      Profile profile = new Profile();
      profile.update(field, value);
      profiles.put(profileId, profile);
    }
  }

  public Map<String, String> get(String profileId, int version) {
    if (profiles.containsKey(profileId) {
      return profiles.get(profileId).get(version);
    } else {
      throw new RuntimeException("Not found profile '" + profileId + "'");
    }
  }

  public String getField(String profileId, int version, String field) {
    if (profiles.containsKey(profileId) {
      return profiles.get(profileId).getField(version, field);
    } else {
      throw new RuntimeException("Not found profile '" + profileId + "'");
    }
  }
}

public class Profile {
  Map<String, List<Pair<Integer, String>>> fields = new HashMap();
  int version = 0;
  
  public void update(String field, String value) {
    version++;
    if (fields.containsKey(field)) {
      fields.get(field).add(new Pair(version, value));
    } else {
      fields.put(field, Arrays.asList(new Pair(version, value)))
    }
  }
  
  public String getField(int version, String field) {
    if (this.version < version) {
      throw new RuntimeException("Invalid version");
    }
    if (!fields.containsKey(field) || fields.get(field).get(0).getKey() > version) {
      throw new RuntimeException("Not found field '" + field + "' for version" + version);
    }
    
    List<Pair<Integer, String>> updates = fields.get(field);
    for (int i = 1; i < updates.sized(); i++) {
      if (version < updates.get(i)) {
        return updates.get(i - 1).getValue();
      }
    }
    return updates.get(updates.size() - 1).getValue();
  }
  
  public Map<String, String> get(int version) {
    if (this.version < version) {
      throw new RuntimeException("Invalid version");
    }      
    Map<String, String> result = HashMap();
    for (Entry<String, List<Pair<Integer, String>>> field : fields.entrySet()) {
      result.put(field.getKey(), field.getValue().get(field.getValue().size() - 1));
    }
    return result;
  }
}
