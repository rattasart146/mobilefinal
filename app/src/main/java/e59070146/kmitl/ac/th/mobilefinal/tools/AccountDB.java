package e59070146.kmitl.ac.th.mobilefinal.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AccountDB extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;

    public AccountDB(Context context){
        super(context, Account.DATABASE_NAME, null, Account.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ACCOUNT_TABLE = String.format("CREATE TABLE %s " +
                        "(%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER)",
                Account.TABLE,
                Account.Column.USER_ID,
                Account.Column.USER_NAME,
                Account.Column.PASSWORD,
                Account.Column.AGE);

        sqLiteDatabase.execSQL(CREATE_ACCOUNT_TABLE);
        Log.d("SQLiteDB", "DATABASE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String CREATE_ACCOUNT_TABLE = "DROP TABLE IF EXISTS " + Account.TABLE;
        sqLiteDatabase.execSQL(CREATE_ACCOUNT_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void updateAccount(Account account){
        sqLiteDatabase =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Account.Column.USER_ID, account.getUserId());
        values.put(Account.Column.USER_NAME, account.getUserName());
        values.put(Account.Column.PASSWORD, account.getPassword());
        values.put(Account.Column.AGE, account.getAge());

        sqLiteDatabase.close();
    }

    public void addAccount(Account account){

        sqLiteDatabase =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Account.Column.USER_ID, account.getUserId());
        values.put(Account.Column.USER_NAME, account.getUserName());
        values.put(Account.Column.PASSWORD, account.getPassword());
        values.put(Account.Column.AGE, account.getAge());

        sqLiteDatabase.insert(Account.TABLE, null, values);
        sqLiteDatabase.close();
    }

    public boolean checkUserAvailable(String userId){
        boolean result = false;
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from accountTable where userId = ?",  new String[] {userId});

        while (cursor.moveToNext()){
            if (userId == cursor.getString(4)){
                result = true;
            }
        }

        cursor.close();
        sqLiteDatabase.close();

        return result;
    }
}
