
import exception.UserNotFoundException;
import repository.Repository;
import service.Service;
import service.ServiceImp;
import view.Views;

import java.net.UnknownServiceException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UserNotFoundException, UnknownServiceException {
        final Service service= new ServiceImp();

        Integer option =0;
        do {

            Views.inputOption();

            System.out.print("[+] Insert Option :");
            option=new Scanner(System.in).nextInt();
            switch (option){
                case 1:{

                    Repository.input();

                    break;
                }

                case 2:{
                    service.getAllList();

                    break;

                }

                case 3:{


                    System.out.println(service.findUserById(0));


                    break;
                }
                case 4:{

                    System.out.println(service.findByName(null));
                    break;
                }
                case 5:{


                    System.out.println(service.removeByID(0));
                    break;
                }

                default:
                    break;
            }
        }while (option != 0);
    }
}
