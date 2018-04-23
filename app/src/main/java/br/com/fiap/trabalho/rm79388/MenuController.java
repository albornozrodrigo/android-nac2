package br.com.fiap.trabalho.rm79388;

import android.content.Context;

public class MenuController extends Database {

    public MenuController(Context context) {
        super(context);
    }

    public List<Contato> list() {
        List<Contato> contatos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TB, new String[]{"id","nome"}, null, null, null, null, "nome");

        while(cursor.moveToNext()) {
            Contato contato = new Contato();
            contato.setId(cursor.getInt(0));
            contato.setNome(cursor.getString(1));

            contatos.add(contato);
        }
        return contatos;
    }
}
