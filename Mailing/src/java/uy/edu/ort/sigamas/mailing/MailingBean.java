/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.mailing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import uy.edu.ort.sigamas.mailing.exceptions.MailingException;

/**
 *
 * @author Mattahari
 */
@Stateless
public class MailingBean implements MailingBeanLocal {

    private final String username = "elofertonwebort@gmail.com";
    private final String password = "elofertonweb1234";
    
    @Override
    public void enviarMail(String destino, String asunto, String texto) throws MailingException {       

        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.starttls.enable", "true");
        props.put(
                "mail.smtp.host", "smtp.gmail.com");
        props.put(
                "mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(texto);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new MailingException(e.toString());
        }
    }

    @Override
    public void enviarMailConAdjunto(String destino, String asunto, String texto, ByteArrayInputStream adjunto) throws MailingException {
        
        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.starttls.enable", "true");
        props.put(
                "mail.smtp.host", "smtp.gmail.com");
        props.put(
                "mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(texto);
            if (adjunto != null && adjunto instanceof ByteArrayInputStream) {
                // create the second message part with the attachment from a OutputStrean
                MimeBodyPart adjuntoMime = new MimeBodyPart();
                ByteArrayDataSource ds = new ByteArrayDataSource(adjunto, "application/pdf");
                adjuntoMime.setDataHandler(new DataHandler(ds));
                adjuntoMime.setFileName("confirmacion.pdf");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(adjuntoMime);
                message.setContent(multipart);
            }

            Transport.send(message);

        } catch (MessagingException e) {
            throw new MailingException(e.toString());
        } catch (IOException ex) {
            throw new MailingException(ex.toString());
        }
    }

}
