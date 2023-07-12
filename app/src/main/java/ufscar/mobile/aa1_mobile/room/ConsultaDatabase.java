@Database(entities = {Consulta.class}, version = 1)
public abstract class ConsultaDatabase extends RoomDatabase {
    private static volatile ConsultaDatabase INSTANCE;

    public abstract ConsultaDao consultaDao();

    public static ConsultaDatabase getInstance(Context contect){
        if(INSTANCE == NULL){
            synchronized(ConsultaDatabase.class){
                if(INSTANCE == NULL){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                ConsultaDatabase.class, "consulta.db").build();
                }
            }
        }

        return INSTANCE;
    }
}