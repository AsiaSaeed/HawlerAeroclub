package com.example.hawleraeroclub.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hawleraeroclub.Adapter.YarizananFolldingCellAdapter;
import com.example.hawleraeroclub.Model.Player;
import com.example.hawleraeroclub.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.Date;

public class YarizananFragment extends Fragment  {
    ArrayList<Player> players;
    View view;
    YarizananFolldingCellAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_yarizanan, container, false);
        players = new ArrayList<>();

        Date date = new Date(1997, 6, 13);
        // get our list view
        ListView theListView = view.findViewById(R.id.players_lv);
        players.add(new Player("هۆزان", date, "A+", R.drawable.player, "0"));
        players.add(new Player("یوسف", date, "A+", R.drawable.player, "0"));
        players.add(new Player("یونس", date, "A+", R.drawable.player, "0"));
        players.add(new Player("حەمە", date, "A+", R.drawable.player, "0"));

        // add custom btn handler to first list item
        players.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        adapter = new YarizananFolldingCellAdapter(view.getContext(), 0, players);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
        return view;
    }


}
