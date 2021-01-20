package ke.ac.tuk.scit.ctit.lydia.datafirebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class  Vetslist extends ArrayAdapter<Vet> {

    private Activity context;
    List<Vet> vets;

    public Vetslist(Activity context, List<Vet> vets) {
        super(context, R.layout.customlistitem, vets);
        this.context = context;
        this.vets = vets;
    }

    public Vetslist(@NonNull Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.customlistitem, null, true);

        TextView name = (TextView) listViewItem.findViewById(R.id.name);
        TextView number = (TextView) listViewItem.findViewById(R.id.number);
        TextView specialty = (TextView) listViewItem.findViewById(R.id.specialtyr);
        TextView status = (TextView) listViewItem.findViewById(R.id.status);

        Vet vet = vets.get(position);
        name.setText(vet.getname());
        number.setText(vet.getphoneNumber());
        specialty.setText(vet.getspecialty());
        status.setText(vet.getstatus());

        return listViewItem;
    }


}
