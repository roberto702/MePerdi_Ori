package cl.micasa.meperdi;


/**
 * Created by Angela on 28/08/2016. Se crea proyecto base de datos
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import java.util.ArrayList;
import java.util.concurrent.Callable;


public class MascotasDB {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public MascotasDB(Context context){
        dbHelper = new DBHelper(context);
    }

    private void openReadableDB(){
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteable(){
        db = dbHelper.getWritableDatabase();

    }

    private void closeDB(){
        if(db!=null){
            db.close();
        }
    }

    // CRUD....

    private ContentValues mascotasMapperContentValues(Mascotas mascotas){
        ContentValues cv = new ContentValues();
        cv.put(ConstantsDB.MAS_TIPO_ANIMAL,mascotas.getTipo_animal());
        cv.put(ConstantsDB.MAS_NOMBRE_ANIMAL,mascotas.getNombre_mascotas());
        cv.put(ConstantsDB.MAS_FOTO_1, mascotas.getFoto_1());
        cv.put(ConstantsDB.MAS_FOTO_2, mascotas.getFoto_2());
        cv.put(ConstantsDB.MAS_FOTO_3, mascotas.getFoto_3());
        cv.put(ConstantsDB.MAS_CARACTERISTICAS, mascotas.getCaracteristicas());
        cv.put(ConstantsDB.MAS_FECHA, mascotas.getFecha());
        cv.put(ConstantsDB.MAS_HORA, mascotas.getHora());
        cv.put(ConstantsDB.MAS_NOMBRE_DUENO, mascotas.getNombre_dueno());
        cv.put(ConstantsDB.MAS_TELF, mascotas.getTelefono());
        cv.put(ConstantsDB.MAS_MAIL, mascotas.getEmail());
        cv.put(ConstantsDB.MAS_RECOMPENSA, mascotas.getRecompensa());
        return cv;
    }

    //inserta registros a la base de datos
    public long insertMascotas(Mascotas mascotas) {
        this.openWriteableDB();
        long rowID = db.insert(ConstantsDB.TABLA_MASCOTAS, null, mascotasMapperContentValues(mascotas);
        this.closeDB();

        return rowID;
    }

    //Actualiza o modifica los registros de la base de datos
    public void updateMascotas(Mascotas mascotas) {
        this.openWriteableDB();
        String where = ConstantsDB.CLI_ID + "= ?";
        db.update(ConstantsDB.TABLA_MASCOTAS, clienteMapperContentValues(mascotas), where, new String[]{String.valueOf(mascotas.getId())});
        db.close();
    }

    //Borra registros de la base de datos
    public void deleteMascotas(int id) {
        this.openWriteableDB();
        String where = ConstantsDB.CLI_ID + "= ?";
        db.delete(ConstantsDB.TABLA_MASCOTAS, where, new String[]{String.valueOf(id)});
        this.closeDB();
    }

    //LEE LOS REGISTROS DE LA BASE DE DATOS
    public ArrayList loadMascotas() {

        ArrayList list = new ArrayList<>();

        this.openReadableDB();
        String[] campos = new String[]{ConstantsDB.MAS_ID, ConstantsDB.MAS_TIPO_ANIMAL, ConstantsDB.MAS_NOMBRE_MASCOTA,
                ConstantsDB.MAS_FOTO_1, ConstantsDB.MAS_FOTO_2, ConstantsDB.MAS_FOTO_3,ConstantsDB.MAS_CARACTERISTICAS,
                ConstantsDB.MAS_FECHA, ConstantsDB.MAS_HORA, ConstantsDB.MAS_NOMBRE_DUENO, ConstantsDB.MAS_TELF,
                ConstantsDB.MAS_MAIL, ConstantsDB.MAS_RECOMPENSA};
        Cursor c = db.query(ConstantsDB.TABLA_MASCOTAS, campos, null, null, null, null, null, null, null, null, null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                Mascotas mascotas = new Mascotas();
                mascotas.setId(c.getInt(0));
                mascotas.setTipo_animal(c.getString(1));
                mascotas.setNombre_mascota(c.getString(2));
                mascotas.setFoto_1(c.getString(3));
                mascotas.setFoto_2(c.getString(4));
                mascotas.setFoto_3(c.getString(5));
                mascotas.setCaracteristicas(c.getString(6));
                mascotas.setNombre_dueno(c.getString(7));
                mascotas.setTelefono(8);
                mascotas.setEmail(9);
                mascotas.setRecompensa(10);
                list.add(mascotas);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }


    //Obtener un registro
    public Mascotas mascotasCliente(String nombre_dueno) {
        Mascotas mascotas = new mascotas();
        this.openReadableDB();
        String where = ConstantsDB.MAS_NOMBRE_DUENO + "= ?";
        String[] whereArgs = {nombre_dueno};
        Cursor c = db.query(ConstantsDB.TABLA_MASCOTAS, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            mascotas.setId(c.getInt(0));
            mascotas.setTipo_animal(c.getString(1));
            mascotas.setNombre_mascota(c.getString(2));
            mascotas.setFoto_1(c.getString(3));
            mascotas.setFoto_2(c.getString(4));
            mascotas.setFoto_3(c.getString(5));
            mascotas.setCaracteristicas(c.getString(6));
            mascotas.setNombre_dueno(c.getString(7));
            mascotas.setTelefono(8);
            mascotas.setEmail(9);
            mascotas.setRecompensa(10);
            c.close();
        }
        this.closeDB();
        return mascotas;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, ConstantsDB.DB_NAME, null, ConstantsDB.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ConstantsDB.TABLA_MASCOTAS_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}

