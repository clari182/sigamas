/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author anieves
 */
@Named(value = "beanSesionUsuario")
@SessionScoped
public class BeanSesionUsuario implements Serializable {

    /**
     * Creates a new instance of BeanSesionUsuario
     */
    public BeanSesionUsuario() {
    }

    private Usuario usuarioLoggeado;
    private Cuenta cuentaActual;
    private int tabSelected;
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private int tareasPendientes = 3;
    private ScheduleModel eventModel;

    @PostConstruct
    public void init() {
        createLineModels();
        setEventModel(new DefaultScheduleModel());
        getEventModel().addEvent(new DefaultScheduleEvent( "siembra cultivo1", previousDay8Pm(), previousDay11Pm()));
        getEventModel().addEvent(new DefaultScheduleEvent("tarea1", today1Pm(), today6Pm()));
        getEventModel().addEvent(new DefaultScheduleEvent("siembra cultivo2", nextDay9Am(), nextDay11Am()));
        getEventModel().addEvent(new DefaultScheduleEvent("Cambio de etapa", theDayAfter3Pm(), fourDaysLater3pm()));
        
    }
    
    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    /**
     * Establece el usuario loggeado en la sesion. Si tiene cuentas, utiliza la
     * primera de la lista como la cuenta por defecto
     *
     * @param usuarioLoggeado
     */
    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
        if (usuarioLoggeado.getCuentaList() != null && !usuarioLoggeado.getCuentaList().isEmpty()) {
            this.cuentaActual = usuarioLoggeado.getCuentaList().get(0);
        }
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    /**
     * @return the tabSelected
     */
    public int getTabSelected() {
        return tabSelected;
    }

    /**
     * @param tabSelected the tabSelected to set
     */
    public void setTabSelected(int tabSelected) {
        this.tabSelected = tabSelected;
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
    private void createLineModels() {
        setLineModel1(initLinearModel());
        getLineModel1().setTitle("Linear Chart");
        getLineModel1().setLegendPosition("e");
        Axis yAxis = getLineModel1().getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        setLineModel2(initCategoryModel());
        getLineModel2().setTitle("Category Chart");
        getLineModel2().setLegendPosition("e");
        getLineModel2().setShowPointLabels(true);
        getLineModel2().getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = getLineModel2().getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
    
     private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }

    /**
     * @return the lineModel1
     */
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    /**
     * @param lineModel1 the lineModel1 to set
     */
    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    /**
     * @return the lineModel2
     */
    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    /**
     * @param lineModel2 the lineModel2 to set
     */
    public void setLineModel2(LineChartModel lineModel2) {
        this.lineModel2 = lineModel2;
    }
    
    public void addMessage() {        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se valido la tarea1"));
        
    }

    /**
     * @return the tareasPendientes
     */
    public int getTareasPendientes() {
        return tareasPendientes;
    }

    /**
     * @param tareasPendientes the tareasPendientes to set
     */
    public void setTareasPendientes(int tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public void validarTarea()
    {
        this.tareasPendientes = 2;
    }
    
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
         
        return t.getTime();
    }
     
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
         
        return t.getTime();
    }
     
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
 
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
         
        return t.getTime();
    }
     
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
         
        return t.getTime();
    }
     
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }

    /**
     * @return the eventModel
     */
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    /**
     * @param eventModel the eventModel to set
     */
    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }
    
    public String onEventSelect(SelectEvent selectEvent) {
        //event = (ScheduleEvent) selectEvent.getObject();
        return "detalleTarea";
    }
    
}
