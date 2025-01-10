import java.time.chrono.IsoEra;

/** Represents a user in a social network. A user is characterized by a name,
 *  a list of user names that s/he follows, and the list's size. */
 public class User {

    // Maximum number of users that a user can follow
    static int maxfCount = 10;
    private String name;       // name of this user
    private String[] follows;  // array of user names that this user follows
    private int fCount;        // actual number of followees (must be <= maxfCount)

    /** Creates a user with an empty list of followees. */
    public User(String name) {
        this.name = name;
        follows = new String[maxfCount]; // fixed-size array for storing followees
        fCount = 0;                      // initial number of followees
    }

    /** Creates a user with some followees. The only purpose of this constructor is 
     *  to allow testing the toString and follows methods, before implementing other methods. */
    public User(String name, boolean gettingStarted) {
        this(name);
        follows[0] = "Foo";
        follows[1] = "Bar";
        follows[2] = "Baz";
        fCount = 3;
    }

    /** Returns the name of this user. */
    public String getName() {
        return name;
    }

    /** Returns the follows array. */
    public String[] getfFollows() {
        return follows;
    }

    /** Returns the number of users that this user follows. */
    public int getfCount() {
        return fCount;
    }

    public boolean follows(String name) {
        name = ChangeName(name);
        for (int i = 0; i < fCount; i++) { // עובר רק עד מספר העוקבים
            if (follows[i] != null && follows[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
    public boolean addFollowee(String name) {
        if (fCount==maxfCount) return false;
        if (follows(name)) return false;
        if (name.charAt(0)>='a' && name.charAt(0)<='z' ) {
            String newName = name.substring(0, 1).toUpperCase() + name.substring(1);
            follows[fCount] = newName;
        }
        else follows[fCount] = name;
        fCount++;
        return true;
    }
//public boolean addFollowee(String name) {
  //  name = ChangeName(name);
   // if (name == null || name.trim().isEmpty()) {
     //   System.out.println("Invalid followee name.");
       // return false;
   // }
   // if (fCount >= maxfCount) {
     //   System.out.println(this.name + " reached the maximum followee count.");
       // return false;
   // }
   // if (follows(name)) {
     //   System.out.println(this.name + " is already following " + name);
       // return false;
   // }
//
  //  follows[fCount] = name;
    //fCount++;
    //System.out.println("Successfully added " + name + " to " + this.name);
    //return true;
//}
    /** Removes the given name from the follows list of this user. If successful, returns true.
     *  If the name is not in the list, does nothing and returns false. */
    public boolean removeFollowee(String name) {
        if (name == null) {
            return false; 
        }
    
        name = ChangeName(name);
        for (int i = 0; i < fCount; i++) {
            if (follows[i] != null && follows[i].equals(name)) {
                for (int j = i; j < fCount - 1; j++) {
                    follows[j] = follows[j + 1];
                }
                follows[--fCount] = null;
                return true;
            }
        }
        return false;
    }
    
   
    public int countMutual(User other) {
        int count = 0;
        for (int i = 0; i < fCount; i++) {
            for (int j = 0; j < other.fCount; j++) {
                if (follows[i] != null && follows[i].equals(other.follows[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isFriendOf(User other) {
   
    if (!other.follows(this.name)) {
        return false; 
    }

    for (int i = 0; i < fCount; i++) {
        if (this.follows[i] != null && this.follows[i].equals(other.getName())) {
            return true; 
        }
    }
    return false; 
}


    /** Returns this user's name, and the names that s/he follows. */
    public String toString() {
        String ans = name + " -> ";
        for (int i = 0; i < fCount; i++) {
            ans = ans + follows[i] + " ";
        }
        return ans;
    }
    public String ChangeName(String name) {
        if (name == null || name.isEmpty()) {
            return name; 
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
    
    //public String ChangeName(String name) {
      //  char First = name.charAt(0);
        //First = Character.toUpperCase(First); 
        //name = First + name.substring(1); 
        //return name;
   // }
}

