package ufscar.mobile.aa1_mobile.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface ConsultaDao {
    @Query("SELECT * FROM consulta")
    List<Consulta> getAll();

    @Query("SELECT * FROM consulta WHERE id IN (:consultaIds)")
    List<Consulta> loadAllByIds(int[] consultaIds);

    @Query("SELECT * FROM consulta WHERE id_profissional LIKE :consultaId LIMIT 1")
    Consulta findByConsultaId(int consultaId);

    @Insert
    Completable insertConsulta(Consulta consulta);

    @Delete
    void delete(Consulta consulta);
}