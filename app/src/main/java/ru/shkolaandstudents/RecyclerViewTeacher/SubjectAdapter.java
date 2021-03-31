package ru.shkolaandstudents.RecyclerViewTeacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.shkolaandstudents.R;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>
{

    private ArrayList<ExampleItem> mExampleList;
    private SubjectAdapter.OnItemClickListener mListener;
    private SubjectAdapter.RecyclerViewClickListener listener;

    public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextViewLine1;

        public SubjectViewHolder(View itemView, final SubjectAdapter.OnItemClickListener listener) {
            super(itemView);
            mTextViewLine1 = itemView.findViewById(R.id.tv_class_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(SubjectAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public SubjectAdapter(ArrayList<ExampleItem> exampleList, SubjectAdapter.RecyclerViewClickListener listener) {
        this.mExampleList = exampleList;
        this.listener = listener;
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        SubjectAdapter.SubjectViewHolder evh = new SubjectAdapter.SubjectViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.SubjectViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mTextViewLine1.setText(currentItem.getLine2());
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public interface  RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}

