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
public class MailErrorException extends Exception {

    /**
     * Creates a new instance of <code>MailErrorException</code> without detail
     * message.
     */
    public MailErrorException() {
    }

    /**
     * Constructs an instance of <code>MailErrorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MailErrorException(String msg) {
        super(msg);
    }
}
