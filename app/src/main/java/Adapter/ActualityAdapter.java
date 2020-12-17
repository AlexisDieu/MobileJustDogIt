package Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.helha.mobilejustdogit.R;

import java.time.LocalDate;
import java.util.List;

import Modele.Actuality;


public class ActualityAdapter extends ArrayAdapter<Actuality> {


    public ActualityAdapter(@NonNull Context context, int resource, @NonNull List<Actuality> objects) {
        super(context, resource, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View actualityView = convertView;
        if(actualityView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            actualityView = layoutInflater.inflate(R.layout.list_actuality, parent, false);
        }

        final Actuality actuality = getItem(position);

        itemToTextView(actualityView,actuality);

        return  actualityView;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void itemToTextView(View actualityView, Actuality actuality) {
        TextView dateActuality = actualityView.findViewById(R.id.tv_date_actuality);
        TextView description = actualityView.findViewById(R.id.tv_info_actuality);


        dateActuality.setText(FormatDate(actuality.getDateActu()));
        description.setText(actuality.getDescriptif());


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String FormatDate(String date){
        String dateString = date.substring(0,10);
        LocalDate dateLocalDate = LocalDate.parse(dateString);

        String month = dateLocalDate.getMonth().toString();
        int day = dateLocalDate.getDayOfMonth();
        int year = dateLocalDate.getYear();

        String dateReturn = day + " "+ month.substring(0,3) + " "+year ;

        return dateReturn;
    }
}
