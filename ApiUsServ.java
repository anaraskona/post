package API;

import API.Objects.Order;
import API.Objects.User;

public interface ApiUsServ {
    User flag(String id, String pas);
    Order order(String id, String type, String status);
    String pas(String id, String pasnew);
}
