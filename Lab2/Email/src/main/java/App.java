import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter your email adress: ");
        String email = reader.nextLine();

        System.out.println("Enter your password: ");
        String password = reader.nextLine();

        System.out.println("Choose adresses to send email to: ");
        LinkedList<String> adresses = new LinkedList<String>();
        while(true){
            int i =0;
            System.out.println(i+".address: ");
            adresses.add(reader.nextLine());
            System.out.println("If you want to add one more type 'yes' ");
            String choose = reader.nextLine();
            if(choose.equals("yes")) {
                i++;
                continue;
            }
            break;
        }

        System.out.println("Subject: ");
        String subject = reader.nextLine();

        System.out.println("Content: ");
        String content = reader.nextLine();


        EmailMessage testowa = EmailMessage.getBuilder()
                .addFrom(email)
                .addTo(adresses)
                .addSubject(subject)
                .addContent(content)
                .build()
                ;
        testowa.sendMail(password);

    }
}
