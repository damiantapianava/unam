package mx.unam.login;

public class ModelUser
{
    private String userName;
    private String password;

    public ModelUser(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }
}
