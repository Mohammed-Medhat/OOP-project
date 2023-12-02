public class Customer extends Person
{
    public String subscription;

    public Customer(int id, String name, char gender, String address, int phoneNumber, String email,String subscription)
    {
        super( id,  name,  gender,  address,  phoneNumber,  email);
        this.subscription=subscription;
    }
    public void displayDetails()
    {
        System.out.println("Subscription: " + subscription);
    }
}
