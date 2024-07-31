package DataAcces.DTO;

public class SexoDTO {
    private Integer idSexo;
    private String nombre;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    public SexoDTO() {
    }

    public SexoDTO(String nombre) {
        this.nombre = nombre;
    }

    public SexoDTO(Integer idSexo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.idSexo = idSexo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                +"\n IdSexo:        "+ getIdSexo()
                +"\n Nombre:        "+ getNombre()
                +"\n Estado:        "+ getEstado()
                +"\n FechaCrea:     "+ getFechaCrea()
                +"\n FechaModifica: "+ getFechaModifica();
    }

    public Integer getIdSexo() {
        return idSexo;
    }
    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFechaCrea() {
        return fechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return fechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

}
