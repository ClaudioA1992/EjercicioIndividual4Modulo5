package cl.awakelab.ejercicioindividual4modulo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.awakelab.ejercicioindividual4modulo5.databinding.FragmentFirstBinding;
import cl.awakelab.ejercicioindividual4modulo5.databinding.FragmentRightBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RightFragment extends Fragment {

    FragmentRightBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RightFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RightFragment newInstance(String param1, String param2) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("name");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRightBinding.inflate(getLayoutInflater());
        String text = binding.textViewWin.getText().toString();
        text = text.replace("1", mParam1);
        binding.textViewWin.setText(text);
        binding.buttonRightTry.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", mParam1);
            Navigation.findNavController(getView()).navigate(R.id.action_rightFragment_to_triviaFragment, bundle);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}