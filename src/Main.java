import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"John"));
        users.add(new User(2,"Jane"));
        users.add(new User(3,"Bob"));
        users.add(new User(4,"Alice"));
        users.add(new User(5,"Mary"));

        users.forEach(user -> System.out.println(user.toString()));

         List<User> filteredList = users.stream().filter(user -> user.id>2).toList();
        System.out.println("Filtered list");
         filteredList.forEach(System.out::println);
        System.out.println("MappedList");
         List<User> mappedList = users.stream().map(user -> new User(user.id+100, user.name+"mapped")).toList();
        mappedList.forEach(System.out::println);
        System.out.println("UsersMappedList");
        Map<Integer,String>  userMap = users.stream().collect(Collectors.toMap(user -> user.id,user -> user.name));
        userMap.forEach((key, value) -> System.out.println(key+":"+value));
        }
    }
// UserClass
    class User{
    int id;
    String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return "id: " + id + ", name: " + name;
    }
    public String getName(){
        return "Hello my name is: " + name;
    }
}