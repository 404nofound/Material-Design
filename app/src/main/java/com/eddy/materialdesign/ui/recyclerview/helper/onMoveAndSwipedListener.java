package com.eddy.materialdesign.ui.recyclerview.helper;

public interface onMoveAndSwipedListener {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);

}
