package ufscar.mobile.aa1_mobile;

public class Consulta {
    private int dia, mes, hora, minuto, ano;
    private String nomeProfissional;
    private String especialidadeProfissional;

    public Consulta(int dia, int mes, int ano, int hora, int minuto,  String nomeProfissional, String especialidadeProfissional) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.minuto = minuto;
        this.ano = ano;
        this.nomeProfissional = nomeProfissional;
        this.especialidadeProfissional = especialidadeProfissional;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDataFormatada() {
        return String.format("%02d/%02d/%04d %02d:%02d", dia, mes, ano, hora, minuto);
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getEspecialidadeProfissional() {
        return especialidadeProfissional;
    }

    public void setEspecialidadeProfissional(String especialidadeProfissional) {
        this.especialidadeProfissional = especialidadeProfissional;
    }
}