package com.example.myapplication.Views

import android.animation.LayoutTransition
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySelectedInfoBinding
import com.example.myapplication.databinding.ActivitySelectionMenuBinding

class SelectedInfoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySelectedInfoBinding.inflate(layoutInflater)
    }

    private lateinit var information1:TextView
    private lateinit var layout1: LinearLayout
    private lateinit var expandable1: CardView

    private lateinit var information2:TextView
    private lateinit var layout2: LinearLayout
    private lateinit var expandable2: CardView

    private lateinit var information3:TextView
    private lateinit var layout3: LinearLayout
    private lateinit var expandable3: CardView

    private lateinit var information4:TextView
    private lateinit var layout4: LinearLayout
    private lateinit var expandable4: CardView

    private lateinit var information5:TextView
    private lateinit var layout5: LinearLayout
    private lateinit var expandable5: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setImageResource(R.drawable.image2)


        information1 = findViewById(R.id.information1)
        layout1 = findViewById(R.id.layouts1)
        expandable1 = findViewById(R.id.expandable1)

        layout1.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable1.setOnClickListener {
            val v = if (information1.visibility == View.GONE) View.VISIBLE else View.GONE
            information1.visibility = v
        }

        information2 = findViewById(R.id.information2)
        layout2 = findViewById(R.id.layouts2)
        expandable2 = findViewById(R.id.expandable2)

        layout2.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable2.setOnClickListener {
            val v = if (information2.visibility == View.GONE) View.VISIBLE else View.GONE
            information2.visibility = v
        }

        information3 = findViewById(R.id.information3)
        layout3 = findViewById(R.id.layouts3)
        expandable3 = findViewById(R.id.expandable3)

        layout3.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable3.setOnClickListener {
            val v = if (information3.visibility == View.GONE) View.VISIBLE else View.GONE
            information3.visibility = v
        }

        information4 = findViewById(R.id.information4)
        layout4 = findViewById(R.id.layouts4)
        expandable4 = findViewById(R.id.expandable4)

        layout4.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable4.setOnClickListener {
            val v = if (information4.visibility == View.GONE) View.VISIBLE else View.GONE
            information4.visibility = v
        }

        information5 = findViewById(R.id.information5)
        layout5 = findViewById(R.id.layouts5)
        expandable5 = findViewById(R.id.expandable5)

        layout5.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expandable5.setOnClickListener {
            val v = if (information5.visibility == View.GONE) View.VISIBLE else View.GONE
            information5.visibility = v
        }

        setupClickableText()
    }

    private fun setupClickableText() {
        // Example: Making a specific word in information1 clickable
        val textView = findViewById<TextView>(R.id.information2)
        val text = "Jovens à procura do primeiro emprego ou desempregados, com idade entre os 18 e os 35 anos, em situação de desemprego involuntário ou inscritos há mais de 9 meses. \n\nTens de estar inscrito no IEFP. \n\nConsulta aqui."

        val spannableString = SpannableString(text)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iefp.pt/empreendedorismo?tab=criacao-proprio-emprego"))
                startActivity(intent)
            }

            override fun updateDrawState(ds: android.text.TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = ContextCompat.getColor(this@SelectedInfoActivity,R.color.dark_blue)
            }
        }

        val start = text.indexOf("aqui")
        val end = start + "aqui".length
        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.highlightColor = Color.TRANSPARENT

        val textView3 = findViewById<TextView>(R.id.information5)
        val text3 = "Jovens até aos 29 anos com especiais dificuldades de acesso ao mercado de trabalho e em risco de exclusão social, que possuam uma ideia de negócio viável, perfil de empreendedor e formulem e apresentem projetos viáveis para criar postos de trabalho.\n\nMais informações, candidaturas aqui."

        val spannableString3 = SpannableString(text3)
        val clickableSpan3 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iefp.pt/empreendedorismo?tab=microcredito"))
                startActivity(intent)
            }

            override fun updateDrawState(ds: android.text.TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = ContextCompat.getColor(this@SelectedInfoActivity, R.color.dark_blue)
            }
        }

        val start3 = text3.indexOf("aqui")
        val end3 = start3 + "aqui".length
        spannableString3.setSpan(clickableSpan3, start3, end3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView3.text = spannableString3
        textView3.movementMethod = LinkMovementMethod.getInstance()
        textView3.highlightColor = Color.TRANSPARENT


    }

}