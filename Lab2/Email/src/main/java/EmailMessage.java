import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    public void sendMail(final String password){
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator()
        { protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
    try {
        MimeMessage mail = new MimeMessage(session);

        if(to.size() !=0) {
            InternetAddress[] adresses = new InternetAddress[to.size()];
            for (int i = 0; i < to.size(); i++) {
                adresses[i] = new InternetAddress(to.get(i));
            }
            mail.setRecipients(Message.RecipientType.TO, adresses);
        }
        if(cc.size() !=0){
            InternetAddress[] cc_adresses = new InternetAddress[cc.size()];
            for (int i = 0; i < cc.size(); i++) {
                cc_adresses[i] = new InternetAddress(cc.get(i));
            }
            mail.setRecipients(Message.RecipientType.CC,cc_adresses);
        }
        if(bcc.size() !=0){
            InternetAddress[] bcc_adresses = new InternetAddress[bcc.size()];
            for (int i = 0; i < bcc.size(); i++) {
                bcc_adresses[i] = new InternetAddress(bcc.get(i));
            }
            mail.setRecipients(Message.RecipientType.BCC,bcc_adresses);
        }

        mail.setSubject(subject);
        mail.setText(content);
        Transport.send(mail);
        System.out.println("Succesfully send mail");

    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    public EmailMessage(String from_toSet, LinkedList<String> to_toSet,
                         String subject_toSet, String content_toSet, String mimeType_toSet,
                        LinkedList<String> cc_toSet, LinkedList<String> bcc_toSet){
        from = from_toSet;
        to = to_toSet;
        subject = subject_toSet;
        content = content_toSet;
        mimeType = mimeType_toSet;
        cc = cc_toSet;
        bcc = bcc_toSet;

    }



    public static class Builder{
        private String from; //required (must be e-mail)
        private LinkedList<String> to = new LinkedList<String>(); //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc = new LinkedList<String>(); //optional
        private LinkedList<String> bcc = new LinkedList<String>(); // optional

        public Builder addFrom(String from_to_set) {
            if(isValidEmailAddress(from_to_set)){
                from = from_to_set;
            }
            return this;
        }
        public Builder addTo(LinkedList<String> to_to_set){
            for(String address: to_to_set) {
                if (isValidEmailAddress(address)) {
                    to.addLast(address);
                }
            }
            return this;
        }

        public Builder addSubject(String subject_to_set){
            subject = subject_to_set;
            return this;
        }

        public Builder addContent(String content_to_set){
            content = content_to_set;
            return this;
        }

        public Builder addBcc(String Bcc_to_set){
            if(isValidEmailAddress(Bcc_to_set)){
                bcc.add(Bcc_to_set);
            }
            return this;
        }
        public Builder addCc(String Cc_to_set){
            if(isValidEmailAddress(Cc_to_set)){
                bcc.add(Cc_to_set);
            }
            return this;
        }

        public EmailMessage build() {

            return new EmailMessage(from,to,subject,content,mimeType,cc,bcc);
        }

    }

    public static Builder getBuilder() {
        return new EmailMessage.Builder();
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}

