import User.*;
import System.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("sign as \n1-admin\n2-customer \n");
        int type = scanner.nextInt();
        scanner.nextLine();
        String filePathPerson = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Person.txt";
     //   String filePathCoach = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\User.Coach.txt";

//
//        List<Coach> c=new ArrayList<>();
//        List<Customer> c1=new ArrayList<>();

//User.Customer addded in files
//        c1.add(new User.Customer(0, "Mohammed", 'm', "ain shams", "01014487283", "mo@gmail.com", "mamadou"));
//
//        c1.add(new User.Customer(1, "othman", 'm', "8 meter", "01215312105", "mo@gmail.com", "3ossjr"));
//
//        c1.add(new User.Customer(2,"hady",'m',"obor","01215643211","mo@gmail.com","12345"));
//
//        c1.add(new User.Customer(3,"ali",'m',"maadi","01562156463","mo@gmail.com","12345"));

//        //equipment added in files
//
//        //coaches added in files
//        c.add(new User.Coach("big rammi", 'M', "ainshams", "152316", "rami@gmail.com", 7, "123456789", 0, 0));
//
//
//       c.add(new User.Coach("fargymawi", 'M', "abbasia", "152316", "far@gmail.com", 7, "123456789", 0, 1));
//
//        c.add(new User.Coach("Cbunk",'M',"obor","152316","bunk@gmail.com",7,"123456789",0,2));



        List<Person> personList = Files.readPeopleFromFile(filePathPerson);


        for (Person person : personList) {
            if (person instanceof Coach) {
                Coach loadedCoach = (Coach) person;
                Gym.gcoach.add(loadedCoach);
            } else if (person instanceof Customer) {
                Customer loadedCustomer = (Customer) person;
                Gym.gcus.add(loadedCustomer);
            }
        }


//        if (type == 1) {
//            boolean Firsttime = true;
//            outerLoop:
//
//            while (true) {
//                if (Firsttime) {
//                    while (true) {
//                        System.out.print("Enter your email: ");
//                        String username = scanner.nextLine();
//
//                        System.out.print("Enter your password: ");
//                        String password = scanner.nextLine();
//                        if ("admin".equals(username) && password.equals("12345")) {
//                            System.out.println("Login successful!");
//                            Firsttime = false;
//                            break;
//                        } else if (username.equals("-1")) {
//                            break outerLoop;
//                        } else {
//                            System.out.println("Login failed. Invalid username or password.");
//                        }
//                    }
//                    System.out.print("Choose process\n1-Show days left\n2-get coach info\n3-show equipments\nStatement 4\nStatement 5\n");
//                    int x = scanner.nextInt();
//                    if (x == -1) {
//                        break;
//                    }
//
//
//                }
//
//
//            }
//
//
//        }

Admin admin=new Admin();

        admin.displayCoachesSortedByAssignedCustomers();
        personList.clear();
        personList.addAll(Gym.gcus);
        personList.addAll(Gym.gcoach);

        Files.writePeopleToFile(personList, filePathPerson);
    }
}




