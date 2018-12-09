package com.steven.homepoker;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Poker porker = new Poker();
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //porker.shuffle();
        porker.print();
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new PokerAdapter());
    }

    class PokerAdapter extends RecyclerView.Adapter<PokerAdapter.PorkerViewHolder> {
        @NonNull
        @Override
        public PorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.porker_row,parent,false);
            return new PorkerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PorkerViewHolder holder, int position) {
            //String cards = String.valueOf(porker.cards[position]);
            holder.pokerText.setText((porker.cards[position].getCard()));
        }

        @Override
        public int getItemCount() {
            return porker.cards.length;
        }

        class PorkerViewHolder extends RecyclerView.ViewHolder{
            TextView pokerText;
            public PorkerViewHolder(View itemView) {
                super(itemView);
                pokerText = itemView.findViewById(R.id.tv_poker);
            }
        }
    }
}
