@Entity(tableName = "consulta")
public class Consulta {
    @PrimaryKey(autoGenerate = true)
    private int uid;

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
}