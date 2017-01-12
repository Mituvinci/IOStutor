package com.gsl.gsl.iostutor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gsl on 12-Jan-17.
 */



public class AdapterItems extends RecyclerView.Adapter<AdapterItems.CustomViewHolder>  {
    private List<String> mDataSet;
    private Context mContext;
    private static customInterface customInterface;

    public AdapterItems(Context context, List<String>mDataSet) {
        this.mDataSet = mDataSet;
        mContext  = context;
        Log.d("recycler :",mDataSet.size()+"");


    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_list_layout,parent,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder,final int position) {

        holder.mNameTextView.setText(mDataSet.get(position));


        Log.d("recycler :", position + " " + mDataSet.get(position) + "");

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class  CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameTextView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            customInterface.onItemClick(getAdapterPosition(),v);

        }
    }

    public void setOnItemClickListener(customInterface clickListener){
        this.customInterface = clickListener;
    }

    public interface customInterface{
        void onItemClick(int position, View v);    }
}
