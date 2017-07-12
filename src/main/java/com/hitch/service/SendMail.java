package com.hitch.service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
	 
public class SendMail {
	 
	    public synchronized void sendMails(String toEmail, String subject,  String msg) {
	 
	    	final String fromEmail = "bdgroom123@gmail.com"; //requires valid gmail id
            final String password = "Goblues20017"; // correct password for gmail id
            //final String toEmail = ""; // can be any email id 

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); 

	           /*final String fromEmail = "@gmail.com";
	           final String password = "pass";

	               Properties props = new Properties();
	               props.put("mail.smtp.host", "smtp.gmail.com");
	               props.put("mail.smtp.socketFactory.port", "465");
	               props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	               props.put("mail.smtp.auth", "true");
	               props.put("mail.smtp.port", "465");*/
	 
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

	 
	               try {
	            	   MimeMessage message = new MimeMessage(session);
	                   message.setFrom(new InternetAddress(fromEmail));
	                   message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

	                   message.setSubject(subject);
	                   message.setText(msg);
	                   System.out.println("Mail message = " + message);

	                   Transport.send(message);
	 
	                   System.out.println("Mail sent succesfully!");
	 
	               } catch (MessagingException e) {
	                   throw new RuntimeException(e);
	               }
	               notifyAll();  
	           }
	       }
	 