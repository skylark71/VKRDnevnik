package ru.shkolaandstudents.ui.Students;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import ru.shkolaandstudents.Utilities;

import ru.shkolaandstudents.R;

/**
 * Фрагмент "О программе".
 * Предназначен для отображения информации о приложении (название, версия, краткое описание, разработчики и т.д).
 */
public class AboutFragment extends Fragment {

    /**
     * Объект класса Utilities.
     */
    private Utilities utils = new Utilities(getContext());

    /**
     * Метод диначеского создания нового экземпляра данного фрагмента.
     */
    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    /**
     * Основной метод фрагмента.
     * В нем реализуется инициализация интерфейса и т.д.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        ConstraintLayout about_layout = rootView.findViewById(R.id.about_layout);

        if (utils.getTheme(getActivity().getApplicationContext()) == 1) {
            about_layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        if (utils.getTheme(getActivity().getApplicationContext()) == 2) {
            about_layout.setBackgroundColor(Color.parseColor("#2d2d2d"));
        }

        return rootView;
    }

}
