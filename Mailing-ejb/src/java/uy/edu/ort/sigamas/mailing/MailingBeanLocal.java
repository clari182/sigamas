/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.mailing;

import java.io.ByteArrayInputStream;
import javax.ejb.Local;
import uy.edu.ort.sigamas.mailing.exceptions.MailingException;

/**
 *
 * @author Mattahari
 */
@Local
public interface MailingBeanLocal {

    void enviarMail(String destino, String asunto, String texto) throws MailingException; 

    void enviarMailConAdjunto(String destino, String asunto, String texto, ByteArrayInputStream adjunto) throws MailingException;
    
}
