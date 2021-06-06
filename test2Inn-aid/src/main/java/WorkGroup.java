import java.util.List;
import java.util.stream.Collectors;

public class WorkGroup {
    public String name;
    public List<User> users;


    public WorkGroup(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public boolean checkPermission(String codeUser, int codePermission) {
        if (codeUser.equals("")){
            throw new NullPointerException("Код не передан");
        }
        if(codePermission>Permission.values().length){
            throw new IllegalArgumentException("Значение вне диапазона разрешений");
        }
        return users.stream()
                .filter(u->u.getId().equals(codeUser))
                .findFirst()
                .get()
                .getRoles()
                .stream()
                .anyMatch(role -> role.getPermissions().contains(Permission.values()[codePermission]));

    }
}
