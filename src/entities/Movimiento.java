package entities;

import java.time.LocalDateTime;


public class Movimiento {
    private Long codMovimiento;
    private LocalDateTime hora;
    private String codTrabajador;
    private String accion; // entrada o salida;
    
    public Movimiento() {
    }
    
    public Movimiento(Long codMovimiento) {
        this.codMovimiento = codMovimiento;
    }

    public Movimiento(LocalDateTime hora, String codTrabajador) {
        this.hora = hora;
        this.codTrabajador = codTrabajador;
    }

    public Long getCodMovimiento() {
        return codMovimiento;
    }

    public void setCodMovimiento(Long codMovimiento) {
        this.codMovimiento = codMovimiento;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(String codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
