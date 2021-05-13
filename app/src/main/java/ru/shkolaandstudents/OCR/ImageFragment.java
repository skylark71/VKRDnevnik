package ru.shkolaandstudents.OCR;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.onebit.spinner2.Spinner2;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yalantis.ucrop.UCrop;

import ru.shkolaandstudents.OnBackPressedListener;
import ru.shkolaandstudents.R;
import ru.shkolaandstudents.Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import at.markushi.ui.CircleButton;

import static android.app.Activity.RESULT_OK;

/**
 * Фрагмент "Работа с импортированным изображением".
 * Предназначен для реализации возможностей просмотра и редактирования изображения (кадрирования, поворота),
 * с которого будет осуществляться распознавание текста.
 */
public class ImageFragment extends Fragment implements OnBackPressedListener {

    private final static int THEME_LIGHT = 1;
    private final static int THEME_DARK = 2;

    /**
     * Объект класса Utilities.
     */
    private Utilities utils = new Utilities(getContext());

    /**
     * ImageView для просмотра импортированного фото.
     */
    private ImageView imageView;

    /**
     * Путь к импортированному фото.
     */
    private String photoPath;

    /**
     * URI (специальный идентификатор, по которому можно определить ресурс) импортированного фото.
     */
    private Uri photoURI;

    Bitmap bitmap;
    /**
     * Метод диначеского создания нового экземпляра данного фрагмента.
     */
    public static ImageFragment newInstance() {
        return new ImageFragment();
    }


    /**
     * Кастомный метод ч/б текста
     *
     */
    private Bitmap GetBinaryBitmap(Bitmap bitmap_src) {
        Bitmap bitmap_new = bitmap_src.copy(bitmap_src.getConfig(), true);

        for (int x = 0; x < bitmap_new.getWidth(); x++) {
            for (int y = 0; y < bitmap_new.getHeight(); y++) {
                int color = bitmap_new.getPixel(x, y);
                color = GetNewColor(color);
                bitmap_new.setPixel(x, y, color);
            }
        }

        return bitmap_new;
    }


    private double GetColorDistance(int c1, int c2) {
        int db = Color.blue(c1) - Color.blue(c2);
        int dg = Color.green(c1) - Color.green(c2);
        int dr = Color.red(c1) - Color.red(c2);

        double d = Math.sqrt(Math.pow(db, 2) + Math.pow(dg, 2) + Math.pow(dr, 2));
        return d;
    }

    private int GetNewColor(int c) {
        double dwhite = GetColorDistance(c, Color.WHITE);
        double dblack = GetColorDistance(c, Color.BLACK);

        if (dwhite <= dblack) {
            return Color.WHITE;

        } else {
            return Color.BLACK;
        }
    }

    /**
     * Основной метод фрагмента.
     * В нем реализуется инициализация интерфейса, находятся обработчики кнопок и т.д.
     */
    int w;
    int h;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.image_fragment, container, false);

        ConstraintLayout image_layout = rootView.findViewById(R.id.image_layout);
        if (utils.getTheme(getContext()) <= THEME_LIGHT) {
            image_layout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else if (utils.getTheme(getContext()) == THEME_DARK) {
            image_layout.setBackgroundColor(Color.parseColor("#2d2d2d"));
        }

        photoPath = getArguments().getString("path_to_photo");
        photoURI = Uri.parse(getArguments().getString("uri_path"));

        final File imageFile = new File(photoPath);

        if (imageFile.exists()) {
            imageView = rootView.findViewById(R.id.photoView);

            final View progressDialogView = inflater.inflate(R.layout.progress_dialog, null);
            AlertDialog.Builder progressDialogBuilder = new AlertDialog.Builder(getActivity());
            progressDialogBuilder.setView(progressDialogView);
            progressDialogBuilder.setCancelable(false);
            final AlertDialog progressDialog = progressDialogBuilder.create();
            progressDialog.show();

            Bitmap b = null;
            try {
                b = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), photoURI);
            } catch (IOException e) {
                e.printStackTrace();
            }
            w = b.getWidth();
            h = b.getHeight();

            int w_o =w/8;
            int h_o =h/8;
            //imageView.setLayoutParams(w,h);
            /*imageView.getLayoutParams().height = h;
            imageView.getLayoutParams().width = w;*/

            Picasso.get()
                    .load(Uri.fromFile(imageFile))
                    .resize(utils.dpToPx(w_o, getContext()), utils.dpToPx(h_o, getContext()))
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    final boolean[] flag = {false};
                                    progressDialog.dismiss();

                                    // УЛУЧШЕНИЕ КАРТИНКИ
                                    bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                                    //Серая картинка
                                    for (int x = 0; x < bitmap.getWidth(); x++) {
                                        for (int y = 0; y < bitmap.getHeight(); y++) {
                                            // get one pixel color
                                            int pixel = bitmap.getPixel(x, y);

                                            // retrieve color of RGB
                                            int A = Color.alpha(pixel);
                                            int R = Color.red(pixel);
                                            int G = Color.green(pixel);
                                            int B = Color.blue(pixel);

                                            // convert into single value
                                            B = (int) (0.299 * R + 0.587 * G + 0.114 * B);
                                            G = B;
                                            R = G;
                                            bitmap.setPixel(x, y, Color.argb(A, R, G, B));
                                            // Удаление шумов
                                            //130 верхняя граница
                                            //107 нижняя граница
                                            if (R > 110 && G > 110 && B > 110)
                                                bitmap.setPixel(x, y, Color.WHITE);
                                            else if (R < 110 && G < 110 && B < 110)
                                                bitmap.setPixel(x, y, Color.BLACK);
                                        }
                                    }

                                    final File croppedImage = utils.createImageFile(1);

                                    final CircleButton cropButton = rootView.findViewById(R.id.cropButton);
                                    cropButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            flag[0] = true;
                                            if (!croppedImage.exists()) {
                                                try {
                                                    croppedImage.createNewFile();
                                                } catch (IOException e) {
                                                    utils.showSnackBar(getView(), R.string.errorH + ": " + e.getMessage());
                                                }
                                            }

                                            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                                            //bitmap = utils.RotateBitmap(bitmap, 90);

                                            try (FileOutputStream out = new FileOutputStream(croppedImage)) {
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

                                                photoURI = Uri.fromFile(croppedImage);
                                                photoPath = croppedImage.getAbsolutePath();

                                            } catch (IOException e) {
                                                utils.showSnackBar(getView(), R.string.errorH + ": " + e.getMessage());
                                            }

                                            imageView.setImageBitmap(bitmap);


                                            UCrop.Options options = new UCrop.Options();
                                            options.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                                            options.setToolbarColor(getResources().getColor(R.color.colorPrimary));
                                            options.setToolbarTitle(getResources().getString(R.string.image_editor_title));
                                            options.setToolbarWidgetColor(Color.parseColor("#ffffff"));
                                            options.useSourceImageAspectRatio();
                                            options.setCompressionQuality(100);
                                            options.setFreeStyleCropEnabled(true);
                                            options.setCropFrameColor(Color.BLACK);
                                            options.setHideBottomControls(false);

                                            startActivityForResult(UCrop.of(photoURI, Uri.fromFile(croppedImage))
                                                    .withOptions(options)
                                                    .getIntent(getContext()), UCrop.REQUEST_CROP);
                                        }
                                    });


                                    final CircleButton nextStepButton = rootView.findViewById(R.id.nextStepButton);
                                    nextStepButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Spinner2 lang = rootView.findViewById(R.id.lang);
                                            String selectedLang = lang.getSelectedItem().toString();

                                            if(!flag[0])
                                            {
                                                File imageFile = utils.createImageFile(0);
                                                try {
                                                    imageFile.createNewFile();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }

                                                bitmap = getResizedBitmap(bitmap,w,h);
                                                int w = bitmap.getWidth();
                                                int h = bitmap.getHeight();

                                                utils.saveBitmap(bitmap, imageFile.getAbsolutePath());

                                                photoURI = Uri.fromFile(imageFile);
                                                photoPath = imageFile.getAbsolutePath();
                                            }
                                            if(flag[0])
                                            {
                                                Bitmap b = null;
                                                try {
                                                    b = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), photoURI);
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }

                                                int w = bitmap.getWidth() * 4;
                                                int h = bitmap.getHeight() * 4;

                                                bitmap = getResizedBitmap(b,w,h);

                                                utils.saveBitmap(bitmap, croppedImage.getAbsolutePath());

                                            }


                                            final Fragment OCRFragment = ru.shkolaandstudents.OCR.OCRFragment.newInstance();
                                            OCRFragment.setArguments(utils.createBundle(photoPath, photoURI, selectedLang, 0, false, true));
                                            utils.switchFragment(getActivity(), OCRFragment);
                                        }
                                    });

                                    final CircleButton prevStepButton = rootView.findViewById(R.id.prevStepButton);
                                    prevStepButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Fragment homeFragment = HomeFragment.newInstance();
                                            utils.switchFragment(getActivity(), homeFragment);
                                        }
                                    });
                                }
                            }, 300);
                        }

                        @Override
                        public void onError(Exception e) {
                            progressDialog.dismiss();

                            new AlertDialog.Builder(getContext())
                                    .setTitle(R.string.errorH)
                                    .setMessage(R.string.load_image_error_short + ": " + e.getMessage())
                                    .setCancelable(false)
                                    .setNegativeButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            Fragment homeFragment = HomeFragment.newInstance();
                                            utils.switchFragment(getActivity(), homeFragment);
                                        }
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();
                        }
                    });
        } else {
            utils.showSnackBar(getView(), getResources().getString(R.string.load_image_error_short));
        }

        return rootView;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    /**
     * Метод получения и обработки данных, полученных из других активити
     * (в данном случае, из активити кадрирования изображения).
     *
     * @param requestCode - параметр, определяющий то, откуда получать результат.
     * @param resultCode  - статус получения данных (успешно или нет).
     * @param data        - данные.
     */


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
            photoURI = UCrop.getOutput(data);
            photoPath = utils.getRealPathFromURI(getContext(), photoURI);

            Picasso.get()
                    .load(photoURI)
                    .into(imageView);

        } else if (resultCode == UCrop.RESULT_ERROR) {
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.errorH)
                    .setMessage(R.string.crop_error)
                    .setCancelable(false)

                    .setNegativeButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })

                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    @Override
    public void onBackPressed() {
        utils.switchFragment(getActivity(), new HomeFragment());
    }
}

