/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.mailing.exceptions;

/**
 *
 * @author Mattahari
 */
public class MailingException extends Exception {

    /**
     * Creates a new instance of <code>MailingException</code> without detail
     * message.
     */
    public MailingException() {
    }

    /**
     * Constructs an instance of <code>MailingException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MailingException(String msg) {
        super(msg);
    }
}
