/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Infraestructura.Comunicacion.Helpers;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author XGAnalista2
 */
public class EmailManager {

    public static void EnviarEmail(List<String> destinatarios,String asunto,String cuerpo){
        final String username = "didacticosMusicalesUdea@gmail.com";
        final String password = "analisis2";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });

        try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("from-email@gmail.com"));
                for(String correo:destinatarios){
                 message.addRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(correo));
                }
                message.setSubject(asunto);
                message.setText(cuerpo);
                Transport.send(message);
        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
}
