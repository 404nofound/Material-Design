package com.eddy.materialdesign.ui.dialogs;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eddy.materialdesign.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;

public class DialogsFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private MaterialButton button1, button2, button3, button4,
            button5, button6, button7, button8, button9, button10, button11;

    private Calendar calendar = Calendar.getInstance();

    public static DialogsFragment newInstance(int index) {
        DialogsFragment fragment = new DialogsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.viewpager_fragment_dislogs, container, false);

        button1 = root.findViewById(R.id.btn_dialog_1);
        button2 = root.findViewById(R.id.btn_dialog_2);
        button3 = root.findViewById(R.id.btn_dialog_3);
        button4 = root.findViewById(R.id.btn_dialog_4);
        button5 = root.findViewById(R.id.btn_dialog_5);
        button6 = root.findViewById(R.id.btn_dialog_6);
        button7 = root.findViewById(R.id.btn_dialog_7);
        button8 = root.findViewById(R.id.btn_dialog_8);
        button9 = root.findViewById(R.id.btn_dialog_9);
        button10 = root.findViewById(R.id.btn_dialog_10);
        button11 = root.findViewById(R.id.btn_dialog_11);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_dialog_1:
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        //.setTitle("Title")
                        .setMessage("Discard draft?")
                        .setPositiveButton("Discard", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;
            case R.id.btn_dialog_2:
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Dialog Header")
                        .setMessage("It's a very long content that including nothing important and all words you see now is totally useless.")
                        .setPositiveButton("Confirm", /* listener = */ new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", /* listener = */ new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNeutralButton("Stop", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;
            case R.id.btn_dialog_3:
                String[] singleChoiceItems = getResources().getStringArray(R.array.dialog_choices_array);
                int itemSelected = 0;
                new MaterialAlertDialogBuilder(getContext(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Dialog Header")
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;

            case R.id.btn_dialog_4:
                String[] multiChoiceItems = getResources().getStringArray(R.array.dialog_choices_array);
                boolean[] checkedItems = {true, false, false, false, false, false, false, false, false};
                new MaterialAlertDialogBuilder(getContext(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Dialog Header")
                        .setMultiChoiceItems(multiChoiceItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;


            case R.id.btn_dialog_5:
                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Waiting");
                progressDialog.show();
                break;

            case R.id.btn_dialog_6:
                /*final ProgressDialog horizontalProgressDialog = new ProgressDialog(getContext());
                horizontalProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                horizontalProgressDialog.setMessage(getString(R.string.main_dialog_progress_title));
                horizontalProgressDialog.setCancelable(false);
                horizontalProgressDialog.setMax(100);
                horizontalProgressDialog.show();

                new Thread(new Runnable() {
                    int progress = 0;

                    @Override
                    public void run() {
                        while (progress <= 100) {
                            horizontalProgressDialog.setProgress(progress);
                            if (progress == 100) {
                                horizontalProgressDialog.dismiss();
                            }
                            try {
                                Thread.sleep(35);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progress++;
                        }
                    }
                }).start();*/
                break;

            case R.id.btn_dialog_7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        //String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;

            case R.id.btn_dialog_8:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.set(Calendar.HOUR_OF_DAY, i);
                        calendar.set(Calendar.MINUTE, i1);
                        //String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar1.getTime());
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
                break;

            case R.id.btn_dialog_9:
                /*final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(getContext());
                View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
                Button btn_dialog_bottom_sheet_ok = dialogView.findViewById(R.id.btn_dialog_bottom_sheet_ok);
                Button btn_dialog_bottom_sheet_cancel = dialogView.findViewById(R.id.btn_dialog_bottom_sheet_cancel);
                ImageView img_bottom_dialog = dialogView.findViewById(R.id.img_bottom_dialog);
                Glide.with(getContext()).load(R.drawable.bottom_dialog).into(img_bottom_dialog);
                mBottomSheetDialog.setContentView(dialogView);

                btn_dialog_bottom_sheet_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                    }
                });
                btn_dialog_bottom_sheet_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                    }
                });
                mBottomSheetDialog.show();*/
                break;

            case R.id.btn_dialog_10:
                /*final Dialog fullscreenDialog = new Dialog(getContext(), R.style.DialogFullscreen);

                fullscreenDialog.setContentView(R.layout.dialog_fullscreen);
                ImageView img_full_screen_dialog = fullscreenDialog.findViewById(R.id.img_full_screen_dialog);
                Glide.with(getContext()).load(R.drawable.google_assistant).into(img_full_screen_dialog);
                ImageView img_dialog_fullscreen_close = fullscreenDialog.findViewById(R.id.img_dialog_fullscreen_close);
                img_dialog_fullscreen_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fullscreenDialog.dismiss();
                    }
                });
                fullscreenDialog.show();*/
                break;

            case R.id.btn_dialog_11:
                /*PopupMenu popupMenu = new PopupMenu(getContext(), btn_dialog_11);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_main, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();*/
                break;

        }
    }
}


