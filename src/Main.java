//import User.Coach;
//import User.Customer;
//import User.Person;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//<<<<<<< HEAD
//
//=======
//       Scanner scanner = new Scanner(System.in);
////        System.out.print("sign as \n1-admin\n2-customer \n");
////        int type=scanner.nextInt();
////        scanner.nextLine();
//        String filePathPerson = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\User.Person.txt";
//        String filePathCoach = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\User.Coach.txt";
//
////        List<User.Coach> readCoaches =new ArrayList<>();
////       List<User.Customer> readCustomers =new ArrayList<>();
//>>>>>>> origin/main
//
//
//
//
//<<<<<<< HEAD
//
//        }
//    }
//
//=======
////
//
//
//
////User.Customer addded in files
////       readCustomers.add(new User.Customer(0,"Mohammed",'m',"ain shams","01014487283","mo@gmail.com","mamadou"));
//
////       readCustomers.add(new User.Customer(1,"othman",'m',"8 meter","01215312105","mo@gmail.com","3ossjr"));
//
////        readCustomers.add(new User.Customer(2,"hady",'m',"obor","01215643211","mo@gmail.com","12345"));
//
////        readCustomers.add(new User.Customer(3,"ali",'m',"maadi","01562156463","mo@gmail.com","12345"));
//
////        //equipment added in files
////
////        //coaches added in files
////        readCoaches.add(new User.Coach("big rammi",'M',"ainshams","152316","rami@gmail.com",7,"123456789",0,0));
//
////
////        readCoaches.add(new User.Coach("fargymawi",'M',"abbasia","152316","far@gmail.com",7,"123456789",0,1));
//
////        readCoaches.add(new User.Coach("Cbunk",'M',"obor","152316","bunk@gmail.com",7,"123456789",0,2));
//
//
//
//
//        if(type==1){
//            boolean Firsttime = true;
//            outerLoop:
//
//            while(true){
//                if(Firsttime){
//                while(true) {
//                    System.out.print("Enter your email: ");
//                    String username =scanner.nextLine();
//
//                    System.out.print("Enter your password: ");
//                    String password =scanner.nextLine();
//                    if ("admin".equals(username) && password.equals("12345")) {
//                        System.out.println("Login successful!");
//                        Firsttime=false;
//                        break;
//                    } else if (username.equals("-1")) {
//                        break outerLoop;
//                    } else {
//                        System.out.println("Login failed. Invalid username or password.");
//                    }
//                }
//
//                }
//
//                System.out.print("Choose process\n1-add coach to customer\n2-change equipment status\nStatement 3\nStatement 4\nExit\n");
//                int x=scanner.nextInt();
//                if(x==1){
//
//                    System.out.print("User.Customer ID: ");
//                    int customerid =scanner.nextInt();
//                    scanner.nextLine();
//
//                    if(readCustomers.get(customerid).hasCoach()){
//
//
//                    for (Coach coach : readCoaches) {
//                        if (coach.numberofTrainee <= 10) {
//
//                            for (Customer obj : readCustomers) {
//                                if (obj.getCusId() == customerid) {
//
//                                    readCustomers.get(obj.getCusId()).setCoach(coach);
//                                    readCustomers.get(obj.getCusId()).getCoachInfo(readCustomers.get(obj.getCusId()));
//                                    break; // Break out of the loop if the number is found
//                                }
//                            }
//
//
//                            break; // Break out of the loop if the number is found
//                        }
//                    }
//                    }
//                    else System.out.println("already has a coach");
//
//
//                }
//
//                else if(x==-1){
//                   break;
//                }
//
//            }
//        }
//        else if (type==2){
//            outerLoop:
//
//            while(true){
//                while(true) {
//                    System.out.print("Enter your email: ");
//                    String username =scanner.nextLine();
//
//                    System.out.print("Enter your password: ");
//                    String password =scanner.nextLine();
//
//                    if (LoginSystem.login(readCustomers, username, password)) {
//                        System.out.println("Login successful!");
//                        displaySubcription();
//                        break outerLoop;
//                    } else if(username.equals("-1")) {
//                    break;
//                    }
//                    else{
//                        System.out.println("Login failed. Invalid username or password.");
//                    }
//
//
//                }
//                System.out.print("Choose process\n1-Show days left\n2-get coach info\n3-show equipments\nStatement 4\nStatement 5\n");
//                int x=scanner.nextInt();
//                if(x==-1){
//                    break;
//                }
//
//
//            }
//
//        }
//
//
//
//
//
//
//
//
//
//
//        Files.writeCustomersToFile(filePathCustomer, readCustomers);
//        Files.writeCoachToFile(filePathCoach, readCoaches);
//
//        }
//
//}
//>>>>>>> origin/main
//
//
//
//
