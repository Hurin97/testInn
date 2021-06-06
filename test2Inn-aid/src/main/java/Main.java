import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Role num1 = new Role("1", "num1", List.of(Permission.CREATE,Permission.READ) );
        Role num2 = new Role("2", "num2", List.of(Permission.CREATE,Permission.DELETE,Permission.UPDATE) );
        User usr1 = new User("usr","iow",List.of(num1,num2));
        WorkGroup wg1=new WorkGroup("wg1",List.of(usr1));

        System.out.println(wg1.checkPermission("usr",5));

        usr1.getUserPermissions().stream().forEach(s->System.out.println(s));
    }
}
