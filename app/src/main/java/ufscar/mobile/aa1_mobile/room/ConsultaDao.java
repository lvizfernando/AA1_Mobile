@Dao
public interface ConsultaDao {
    @Query("SELECT * FROM consulta")
    public List<Consulta> getAll();

    @Query("SELECT * FROM consulta WHERE uid IN (:consultaIds)")
    public List<Consulta> loadAllByIds(int[] consultaIds);

    @Query("SELECT * FROM consulta WHERE id_profissional LIKE :userId" +
           "LIMIT 1")
    public Consulta findByConsultaId(int consultaId);

    @Insert
    public void insertAll(Consulta... consultas);

    @Delete
    public void delete(Consulta consulta);
}