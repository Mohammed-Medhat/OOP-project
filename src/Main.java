import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("sign as \n1-admin\n2-customer \n");
        int type=scanner.nextInt();

        String filePath = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Customer.txt";
        List<Customer> readCustomers = Files.readCustomersFromFile(filePath);
//Customer addded in files
//        readCustomers.add(new Customer("Mohammed",'m',"ain shams","01014487283","mo@gmail.com","mamadou"));
//        readCustomers.add(new Customer("othman",'m',"8 meter","01215312105","mo@gmail.com","3ossjr"));
//        readCustomers.add(new Customer("hady",'m',"obor","01215643211","mo@gmail.com","12345"));
//        readCustomers.add(new Customer("ali",'m',"maadi","01562156463","mo@gmail.com","12345"));

        //equipment added in files

        //coaches added in files


        if(type==1){
            while(true){
                while(true) {
                    System.out.print("Enter your email: ");
                    String username =scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String password =scanner.nextLine();
                    if ("admin".equals(username) && password.equals("12345")) {
                        System.out.println("Login successful!");
                        break;
                    } else if (username.equals("-1")) {
                        break;
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                }
                System.out.print("Choose process\n1-add coach to customer\n2-change equipment status\nStatement 3\nStatement 4\nStatement 5\n");
                int x=scanner.nextInt();
                if(x==1){

                }

                else if(x==2){

                }
                else if(x==3){

                }
                else if(x==4){

                }
                else if(x==-1){
                   break;
                }

            }
        }
        else if (type==2){


            while(true){
                while(true) {
                    System.out.print("Enter your email: ");
                    String username =scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String password =scanner.nextLine();

                    if (LoginSystem.login(readCustomers, username, password)) {
                        System.out.println("Login successful!");
                        break;
                    } else if(username.equals("-1")) {
                    break;
                    }
                    else{
                        System.out.println("Login failed. Invalid username or password.");
                    }


                } System.out.print("Choose process\n1-Show days left\n2-get coach info\n3-show equipments\nStatement 4\nStatement 5\n");
                int x=scanner.nextInt();
                if(x==-1){
                    break;
                }


            }

        }










        Files.writeCustomersToFile(filePath, readCustomers);
        }

}




