package ufscar.mobile.aa1_mobile.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Consulta.class}, version = 1)
public abstract class ConsultaDatabase extends RoomDatabase {
    private static volatile ConsultaDatabase INSTANCE;

    public abstract ConsultaDao consultaDao();

    public static ConsultaDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized(ConsultaDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                ConsultaDatabase.class, "consulta.db").build();
                }
            }
        }

        return INSTANCE;
    }
}