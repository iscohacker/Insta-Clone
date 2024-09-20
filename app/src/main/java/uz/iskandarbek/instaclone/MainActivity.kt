package uz.iskandarbek.instaclone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uz.iskandarbek.instaclone.databinding.ActivityMainBinding
import uz.iskandarbek.instaclone.fragments.AccountFragment
import uz.iskandarbek.instaclone.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        binding.homeyes.setOnClickListener {
            replaceFragment(HomeFragment())
            binding.homeyes.setImageResource(R.drawable.homeyes)
            binding.doira.visibility = View.GONE

        }

        binding.mypic.setOnClickListener {
            replaceFragment(AccountFragment())
            if (binding.doira.visibility == View.GONE) {
                binding.doira.visibility = View.VISIBLE
            } else {
                binding.doira.visibility = View.GONE
            }
            binding.homeyes.setImageResource(R.drawable.homeno)

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}