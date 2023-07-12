package ufscar.mobile.aa1_mobile.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consulta")
public class Consulta {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "dia")
    private int dia;

    @ColumnInfo(name = "mes")
    private int mes;

    @ColumnInfo(name = "hora")
    private int hora;

    @ColumnInfo(name = "minuto")
    private int minuto;

    @ColumnInfo(name = "ano")
    private int ano;

    @ColumnInfo(name = "id_profissional")
    private int idProfissional;

    @ColumnInfo(name = "nome_profissional")
    private String nomeProfissional;

    @ColumnInfo(name = "especialidade_profissional")
    private String especialidadeProfissional;

    public Consulta(int dia, int mes, int hora, int minuto, int ano, int idProfissional, String nomeProfissional, String especialidadeProfissional) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.minuto = minuto;
        this.ano = ano;
        this.idProfissional = idProfissional;
        this.nomeProfissional = nomeProfissional;
        this.especialidadeProfissional = especialidadeProfissional;
    }

    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getAno() {
        return ano;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public String getEspecialidadeProfissional() {
        return especialidadeProfissional;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public void setEspecialidadeProfissional(String especialidadeProfissional) {
        this.especialidadeProfissional = especialidadeProfissional;
    }
}