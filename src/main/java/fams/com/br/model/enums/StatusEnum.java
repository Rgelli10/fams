package fams.com.br.model.enums;

public enum StatusEnum {
    STATUS_200("200");

    private String codigo;

    StatusEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
