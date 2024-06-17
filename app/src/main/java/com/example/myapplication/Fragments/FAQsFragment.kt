package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapters.RecyclerViewAdapter
import com.example.myapplication.FAQ
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFaqsBinding


class FAQsFragment : Fragment() {

    private lateinit var binding: FragmentFaqsBinding

    private lateinit var questions: Array<String>
    private lateinit var answers: Array<String>

    private lateinit var recView: RecyclerView
    private lateinit var itemArrayList: ArrayList<FAQ>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFaqsBinding.inflate(inflater, container, false)
        val view = binding.root

        recView = binding.recyclerView


        questions = arrayOf(
            "O que é a Garantia Jovem?",
            "Quais os objetivos da Garantia Jovem?",
            "A quem se destina?",
            "Aplica-se às Regiões Autónomas?",
            "O que é um jovem NEET?",
            "Como se pode participar?",
            "O que acontece após o pedido de contacto no portal?",
            "Como é que a Garantia Jovem vai ser implementada em Portugal?",
            "Quais as entidades envolvidas?",
            "Como é que uma entidade pode ser parceira da Garantia Jovem?",
            "Como é que uma entidade se pode candidatar às medidas da Garantia Jovem"
        )

        answers = arrayOf(
            "É uma iniciativa dirigida a jovens com menos de 30 anos de idade com o objetivo de lhes dar uma oportunidade de educação e formação, estágio ou emprego, no prazo de 4 meses após ficarem desempregados ou terem saído do sistema educativo e formativo.",
            "A Garantia Jovem tem 3 grandes objetivos:\nAumentar as qualificações dos jovens\nFacilitar a entrada dos jovens no mercado de trabalho\nReduzir o desemprego jovem",
            "Em Portugal, a Garantia Jovem destina-se aos jovens até aos 29 anos, inclusive, que não estejam integrados em qualquer modalidade de ensino ou formação ou no mercado de trabalho.\nNo entanto, em cada medida podem existir condições de acesso específicas para os respetivos destinatários.",
            "A Garantia Jovem aplica-se a jovens residentes nas Regiões Autónomas dos Açores e da Madeira através de medidas específicas.\nConheça a Garantia Jovem – Açores e a Garantia Jovem – Madeira.",
            "Um Jovem NEET (Not in Employment Education or Training) é um jovem que não está nem a trabalhar, nem a estudar ou a frequentar qualquer tipo de formação.",
            "Para participar numa das medidas da Garantia Jovem, os jovens que não se encontrem integrados nem no sistema de educação e formação nem se encontrem inscritos nos serviços de emprego do IEFP podem:\nRegistar o seu pedido de contacto no portal da Garantia Jovem\nDirigir-se a uma das entidades parceiras que asseguram a resposta pretendida",
            "O contacto é respondido por email ou por telefone o mais rapidamente possível, por uma das entidades parceiras, com o objetivo de recolher mais informações sobre as características do jovem para o encaminhar para a resposta mais adequada.",
            "A Garantia Jovem concretiza-se através do Plano Nacional de Implementação de uma Garantia Jovem (PNI-GJ), aprovado pela Resolução de Conselho de Ministros n.º 188/2021, de 30 de dezembro. Este plano define o conjunto de medidas que enquadra a Garantia Jovem.",
            "Na Garantia Jovem estão envolvidos diversos organismos com competências nas áreas da educação, formação, emprego, segurança social e juventude, que são considerados parceiros nucleares:\nInstituto do Emprego e Formação Profissional, I.P.\nInstituto da Segurança Social, IP\nDireção-Geral da Educação\nDireção-Geral do Ensino Superior\nAgência Nacional para a Qualificação e o Ensino Profissional, IP\nInstituto Português do Desporto e Juventude, IP\nINA – Direção-Geral da Qualificação dos Trabalhadores em Funções Públicas\nDireção-Geral de Política Externa\nAICEP PORTUGAL GLOBAL, Agência para o Investimento e Comércio Externo de Portugal, EPE\nDireção-Geral das Autarquias Locais\nCASES - Cooperativa António Sérgio para a Economia Social\nA implementação da Garantia Jovem conta ainda com a participação de outros parceiros estratégicos para a atuação junto dos jovens.",
            "Uma entidade pública ou privada que, pela sua natureza, pode contribuir ao nível local para a sinalização, encaminhamento e integração dos jovens no sistema educativo/formativo, no mercado de trabalho ou numa das medidas que enquadram a Garantia Jovem pode submeter um pedido de adesão à rede de entidades parceiras através do portal, enviando um email de contacto.",
            "A Garantia Jovem não pressupõe uma candidatura específica por parte das entidades. As diversas entidades candidatam-se às medidas de formação e emprego que se enquadram nesta iniciativa junto dos organismos promotores, de acordo com a respetiva legislação e regulamentos específicos."
        )


        recView.layoutManager = LinearLayoutManager(requireContext())
        recView.setHasFixedSize(true)


        itemArrayList = arrayListOf()

        getData()

        recView.adapter = RecyclerViewAdapter(itemArrayList)

        return view


    }
    private fun getData() {

        for(i in questions.indices) {
            val faq = FAQ(questions[i], answers[i], R.drawable.cross)
            itemArrayList.add(faq)
        }
    }

}