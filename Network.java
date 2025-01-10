import java.util.List;

/** Represents a social network. The network has users, who follow other uesrs.
 *  Each user is an instance of the User class. */
public class Network {

    // Fields
    private User[] users;  // the users in this network (an array of User objects)
    private int userCount; // actual number of users in this network

    /** Creates a network with a given maximum number of users. */
    public Network(int maxUserCount) {
        this.users = new User[maxUserCount];
        this.userCount = 0;
    }
    /** Creates a network  with some users. The only purpose of this constructor is 
     *  to allow testing the toString and getUser methods, before implementing other methods. */
    public Network(int maxUserCount, boolean gettingStarted) {
        this(maxUserCount);
        users[0] = new User("Foo");
        users[1] = new User("Bar");
        users[2] = new User("Baz");
        userCount = 3;
    }
    public int getUserCount() {
        return this.userCount;
    }
    /** Finds in this network, and returns, the user that has the given name.
     *  If there is no such user, returns null.
     *  Notice that the method receives a String, and returns a User object. */
  
   public User getUser(String name) {
    name = ChangeName(name);
    for (int i = 0; i < this.users.length; i++) {
        if (users[i] != null && users[i].getName().equals(name)) {
            return users[i];
        }
    }
    return null;
}

    /** Adds a new user with the given name to this network.
    *  If ths network is full, does nothing and returns false;
    *  If the given name is already a user in this network, does nothing and returns false;
    *  Otherwise, creates a new user with the given name, adds the user to this network, and returns true. */
   // public boolean addUser(String name) {
     //   name = ChangeName(name);
       // for(int i=0; i<this.users.length; i++){
          //  if(users[i].getName().equals(name))
            //return false;
            //if(users[i].getName() == null){
        //        users[i] = new User(name);
          //      return true;
           // }
       // }
       // return false;
   // }
    //public boolean addUser(String name) {
        //name = ChangeName(name);
    
      //  if (getUser(name) != null) {
     //       return false; // כבר קיים
   //     }
    
        //if (userCount < users.length) {
          //  users[userCount++] = new User(name);
        //    return true;
      //  }
    //
     //   return false; 
   // }
   public boolean addUser(String name) {
    name = ChangeName(name);
    if (getUser(name) != null) {
        return false; 
    }
    if (userCount < users.length) {
        users[userCount++] = new User(name);
        return true; 
    }
    return false; 
}

    /** Makes the user with name1 follow the user with name2. If successful, returns true.
     *  If any of the two names is not a user in this network,
     *  or if the "follows" addition failed for some reason, returns false. */
    //public boolean addFollowee(String name1, String name2) {
        //name1 = ChangeName(name1);
        //name2 = ChangeName(name2);
      //if (IsExist(name1) == false || IsExist(name2)) {
        //return false;
      //}
      //User user1 = getUser(name1);
      //User user2 = getUser(name2);
    //if (user2.addFollowee(name1) && user1.addFollowee(name2)) {
      //  return true;
    //}
    //return false;
   // }
   public boolean addFollowee(String name1, String name2) {
    if (name1 == null || name2 == null || name1.equals(name2)) {
        return false; 
    }

    name1 = ChangeName(name1);
    name2 = ChangeName(name2);

    User user1 = getUser(name1);
    User user2 = getUser(name2);

    if (user1 == null || user2 == null) {
        return false; 
    }

    return user1.addFollowee(name2); 
}

   
    //public boolean addFollowee(String name1, String name2) {
      //  name1 = ChangeName(name1);
       // name2 = ChangeName(name2);
    //
      //  User user1 = getUser(name1);
        //User user2 = getUser(name2);
    
   //     if (user1 == null || user2 == null) {
     //       return false; 
      //  }
    //
      //  return user1.addFollowee(name2);
    //}
    
    /** For the user with the given name, recommends another user to follow. The recommended user is
     *  the user that has the maximal mutual number of followees as the user with the given name. */
    //public String recommendWhoToFollow(String name) {
      //  int max = 0;
        //name = ChangeName(name);
        //int index =0;
        //User user1 = getUser(name);
        //for(int i=0; i<users.length; i++){
         //if (!users[i].getName().equals(name)){
        //    if(user1.countMutual(users[i]) > max && user1.countMutual(users[i]) != user1.getfCount());
          //  {
            // max =  user1.countMutual(users[i]); 
             //index = i;
           // }
        // }
        //String[] ListOfFollowoOther= users[index].getfFollows();
        //String[] ListOfFollowoUser1= users[index].getfFollows();
        //for(int j=0; j<Math.min(ListOfFollowoOther.length, ListOfFollowoUser1.length); j++){
        //if (ListOfFollowoOther[j] != ListOfFollowoUser1[j] && user1.follows(ListOfFollowoOther[j])){
            //return ListOfFollowoOther[j];
           //}
        //}
       // }
     //   return null; 
   // }
    public String recommendWhoToFollow(String name) {
        name = ChangeName(name);
        User user1 = getUser(name);
        if (user1 == null) {
            return null; 
        }
        int max = 0;
        User recommendedUser = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && !users[i].getName().equals(name)) {
                int mutual = user1.countMutual(users[i]);
                if (mutual > max) {
                    max = mutual;
                    recommendedUser = users[i];
                }
            }
        }
        return (recommendedUser != null) ? recommendedUser.getName() : null;
    }
    /** Computes and returns the name of the most popular user in this network: 
     *  The user who appears the most in the follow lists of all the users. */
    //public String mostPopularUser() {
    //int [] arr= new int[users.length];
    //int count = 0; 
    //int max = 0;
    //int index =0;
      //for(int i=0; i<users.length; i++){
        //String name = users[i].getName();
        //count = followeeCount(name);
        //if (count > max) {
           // max = count;
         //   index = i;
       // }
      //}
      //String mostPopularUser = users[index].getName();
      //mostPopularUser = ChangeName(mostPopularUser);
    //return mostPopularUser;
    //}
    public String mostPopularUser() {
        int max = 0;
        User mostPopular = null;
    
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                int count = followeeCount(users[i].getName());
                if (count > max) {
                    max = count;
                    mostPopular = users[i];
                }
            }
        }
        return (mostPopular != null) ? mostPopular.getName() : null;
    }
    

    /** Returns the number of times that the given name appears in the follows lists of all
     *  the users in this network. Note: A name can appear 0 or 1 times in each list. */
    //private int followeeCount(String name) {
      //  int count = 0; 
        //name = ChangeName(name);
        //for(int i=0; i<users.length; i++){
          //  String[] ListOfFollowo= users[i].getfFollows();
            //for(int j=0; j<ListOfFollowo.length; j++){
              //  if (ListOfFollowo[j].equals(name)) {
                //    count++;
                  //  break;
                //}
            //}
        //}
        //return count;
    //}
    private int followeeCount(String name) {
        int count = 0; 
        name = ChangeName(name);
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                String[] follows = users[i].getfFollows();
                for (int j = 0; j < follows.length; j++) {
                    if (follows[j] != null && follows[j].equals(name)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    
    // Returns a textual description of all the users in this network, and who they follow.
    //public String toString() {
        //String description = "";
        //for(int i=0; i<users.length; i++){
      //      description += users[i].toString() +  "\n";; 
    //}
  //  return description;
//}
public String toString() {
    String description = "Network:";
    for (int i = 0; i < users.length; i++) {
        if (users[i] != null) {
            description += "\n" + users[i].toString();
        }
    }
    return description;
}


public String ChangeName(String name) {
    if (name == null || name.isEmpty()) {
        return name; 
    }
    char First = name.charAt(0);
    First = Character.toUpperCase(First); 
    return First + name.substring(1); 
}

    //public String ChangeName(String name) {
      //  char First = name.charAt(0);
        //First = Character.toUpperCase(First); 
        //name = First + name.substring(1); 
        //return name;
   // }
    public boolean IsExist(String name) {
        name = ChangeName(name); 
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getName().equals(name)) {
                return true; 
            }
        }
        return false; 
    }
     
}