package org.iitb.exam.main.daoimpl;


/**
 *
 * @author dinesh
 */

import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.*;
import java.util.ArrayList;

public class MailServiceImpl{

    /**
     * @param args the command line arguments
     */

    //private static final String SMTP_HOST_NAME = "cygnus.it.iitb.ac.in";
	private static final String SMTP_HOST_NAME = "mail.cse.iitb.ac.in";
    private static final String emailSubjectTxt = "Registration Invitation for the Two Day National Conference on Use of Technology in Higher Education";
    private static final String emailFromAddress = "mhrd-recruit@cse.iitb.ac.in";
    private static String[] sendTo = null;
    private static String fileAttachment = "";
    private static final String fileAttachment1 = "";
    private static String message = null;
    private static String cc = "mhrd-recruit@cse.iitb.ac.in";

    public static void main(String[] args) throws MessagingException {
        // TODO code application logic here

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        MailServiceImpl sendMailThroughJava = new MailServiceImpl();

        ArrayList<String> emaillist = new ArrayList<String>();
        emaillist.add("rdinesh@cse.iitb.ac.in");
        
     //   SimpleStringCipher s=new SimpleStringCipher();
        
        
        sendTo = new String[1];
        for(int i=0;i<emaillist.size();i++) {
            sendTo[0] = (String)emaillist.get(i);
            /*String encryptedEmail = null;
            try
            {
                //encryptedEmail = s.encrypt(sendTo[0]);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }*/
            
            /*Reading the content from the file*  REMAINING */
            StringBuffer sb=new StringBuffer();
           try{
           FileReader file = new FileReader("--path to be added--");
           BufferedReader br=new BufferedReader(file);
           while((message=br.readLine())!=null) {
              sb.append(message);
              sb.append("\n");
           }
           message = sb.toString();
           br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        sendMailThroughJava.sendSSLMessage(sendTo, cc, emailSubjectTxt, message, emailFromAddress);
        }
    }

    /**
     * @param recipients
     * @param subject
     * @param message
     * @param from
     * @throws MessagingException
     */

    public void sendSSLMessage(String recipients[], String cc, String subject, String message, String from) throws MessagingException {
        boolean debug = true;

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);

        Session session = Session.getInstance(props);
        try {
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);

            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));

            // Setting the Subject and Content Type
            msg.setSubject(subject);
            MimeBodyPart msgbdypart = new MimeBodyPart();
            String sHTMLBody = message;
            msg.setContent(sHTMLBody, "text/html");
            msgbdypart.setText(sHTMLBody);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(msgbdypart);
            if (fileAttachment != null && !fileAttachment.equals("")) {
                MimeBodyPart mbp2 = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(fileAttachment);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());
                multipart.addBodyPart(mbp2);
            }

            if (fileAttachment1 != null && !fileAttachment1.equals("")) {
                MimeBodyPart mbp3 = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(fileAttachment1);
                mbp3.setDataHandler(new DataHandler(fds));
                mbp3.setFileName(fds.getName());
                multipart.addBodyPart(mbp3);
            }
            msg.setContent(multipart);
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
