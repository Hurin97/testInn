import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public String id;
    public String name;
    public List<Role> roles;

    User(String name) {
        this.name=name;
        roles=null;
    }

    public User(String id, String name, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public List<Permission> getUserPermissions(){
       return roles.stream()
               .filter(r->r!=null)
               .map(role -> role.getPermissions())
               .flatMap(Collection::stream)
               .distinct()
               .collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
