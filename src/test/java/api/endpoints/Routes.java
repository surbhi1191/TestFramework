package api.endpoints;
//base url : https://petstore.swagger.io/v2
// Create user url (post request): https://petstore.swagger.io/v2/user
// get user url (get request): https://petstore.swagger.io/v2/user/{username}
// get user url (put request): https://petstore.swagger.io/v2/user/{username}
// get user url (delete request): https://petstore.swagger.io/v2/user/{username}


public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";
    //user module urls

    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String put_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";

    //store module urls
    //pet module urls


}
