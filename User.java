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
    
    /** If this user follows the given name, returns true; otherwise returns false. */
    //public boolean follows(String name) {
      //  name = ChangeName(name);
      // for(int i=0; i<10; i++){
       // if (this.follows[i].equals(name)){
        //  return true;
       // }
      // }
        //return false;
   // }
    /** Makes this user follow the given name. If successful, returns true. 
     *  If this user already follows the given name, or if the follows list is full, does nothing and returns false; */
    //public boolean addFollowee(String name) {
      //  if (name == null) {
        //    return false; 
        //}
    
        //name = ChangeName(name);
    
   //     if (this.name.equals(name)) { 
     //       return false; 
      //  }
    
        //for (int i = 0; i < fCount; i++) {
          //  if (follows[i] != null && follows[i].equals(name)) { 
            //    return false; 
            //}
       // }
    
       // if (fCount < maxfCount) { 
         //   follows[fCount++] = name; 
           // return true; 
       // }
    
        //return false; 
   // }

    //public boolean addFollowee(String name) {

      //  name = ChangeName(name);
        //for (int i = 0; i < fCount; i++) {
          //  if (follows[i].equalsIgnoreCase(name)) { 
            //    return false; 
           // }
       // }

        //if (fCount == maxfCount) { 
          //  return false; 
       // }
       // follows[fCount++] = name; 
       // return true; 
      
   // }

   //public boolean addFollowee(String name) {
   // if (name == null ) {
     //   return false; 
    //}
  //  for (int i = 0; i < this.follows.length; i++) {
      //  if (follows[i] != null && follows[i].toLowerCase().equals(name.toLowerCase())) {
        //    return false; 
       // }
   // }
    //if (fCount >= follows.length) {
      //  return false; 
   // }

   // follows[fCount] = name;
   // fCount++;
   // return true;
//}
//public boolean addFollowee(String name) {

    //if (name == null || name.trim().isEmpty()) {
        //System.out.println("Cannot follow a null or empty name.");
      //  return false;
    //}
    //name = ChangeName(name);
    //if (follows(name)) {
       // System.out.println(this.name + " is already following " + name);
      //  return false;
    //}

    //if (fCount >= maxfCount) {
     //   System.out.println(this.name + " reached the maximal number of follows. Can't follow " + name);
      //  return false;
   // }

   // follows[fCount] = name;
   // fCount++;
   // System.out.println("Successfully added " + name + " to " + this.name);
  //  return true;
//}
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
    
    
   // public boolean removeFollowee(String name) {
     //   name = ChangeName(name);
       // for(int i=0; i<10; i++){
         //   if (this.follows[i].equals(name)){
           //     this.fCount--;
             //  if (i == 9) {
               // this.follows[i] = null; 
                //return true;
               //}
               //else{
               //while (this.follows[i] != null && i < 9) {
               // this.follows[i] = this.follows[i+1]; 
               // this.follows[i] = null;
               // i++;
               // if (i == 9) {
                 //   this.follows[i] = null; 
                   // return true;
                //}
              // }
              // }
           // }
       // }
        //return false;
   // }

    /** Counts the number of users that both this user and the other user follow.
    /*  Notice: This is the size of the intersection of the two follows lists. */
    //public int countMutual(User other) {
        //int count = 0;
        //for(int i=0; i<10; i++) {
            //for(int j=0; j<10; j++){
             //   if (this.follows[i].equals(other.follows[j]) && this.follows[i] != null) {
           //      count ++;   
         //       }
       //     }
     //   }
   //     return count;
 //   }

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
    
    /** Checks is this user is a friend of the other user.
     *  (if two users follow each other, they are said to be "friends.") */
   // public boolean isFriendOf(User other) {
    //boolean isFriend1 = false;
    //boolean isFriend2 = false;
    //String name1 = other.getName();
    //name1 = ChangeName(name1);
    //String thisname = this.name;
    //thisname = ChangeName(thisname);
    //if (other.follows(thisname))
      //  isFriend1 = true;
    //for(int i=0; i<10; i++){
      //    if (this.follows[i].equals(name1)){
        //    isFriend2 = true;
          //  }
       // }
    //if (isFriend1 && isFriend2) {
      //return true;
    //}
      //  return false;
   // }
    /** Checks if this user is a friend of the other user.
 *  (if two users follow each other, they are said to be "friends.") */
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

