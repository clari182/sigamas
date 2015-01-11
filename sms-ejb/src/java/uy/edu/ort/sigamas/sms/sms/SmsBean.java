/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sms.sms;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Notificacion;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class SmsBean implements SmsBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;  
    
    @Override
    public void enviarSms(){
        List<Notificacion> notificacionesNoLeidas = em.createNamedQuery("Notificacion.findNotificacionesSms").getResultList();
        
    }
}
