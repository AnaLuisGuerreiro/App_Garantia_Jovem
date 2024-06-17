package com.example.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWhereAreWeBinding

class WhereAreWe : Fragment() {

    private var _binding: FragmentWhereAreWeBinding? = null
    private val binding get() = _binding!!

    val listaConselho = arrayOf("Concelhos","Abrantes", "Águeda", "Aguiar da Beira", "Alandroal", "Albergaria-a-Velha", "Albufeira", "Alcácer do Sal", "Alcanena", "Alcobaça", "Alcochete", "Alcoutim", "Alenquer", "Alfândega da Fé", "Alijó", "Aljezur", "Aljustrel", "Almada", "Almeida", "Almeirim", "Almodôvar", "Alpiarça", "Alter do Chão", "Alvaiázere", "Alvito", "Amadora", "Amarante", "Amares", "Anadia", "Ansião", "Arcos de Valdevez", "Arganil", "Armamar", "Arouca", "Arraiolos", "Arronches", "Arruda dos Vinhos", "Aveiro", "Avis", "Azambuja", "Baião", "Barcelos", "Barrancos", "Barreiro", "Batalha", "Beja", "Belmonte", "Benavente", "Bombarral", "Borba", "Boticas", "Braga", "Bragança", "Cabeceiras de Basto", "Cadaval", "Caldas da Rainha", "Caminha", "Campo Maior", "Cantanhede", "Carrazeda de Ansiães", "Carregal do Sal", "Cartaxo", "Cascais", "Castanheira de Pera", "Castelo Branco", "Castelo de Paiva", "Castelo de Vide", "Castro Daire", "Castro Marim", "Castro Verde", "Celorico da Beira", "Celorico de Basto", "Chamusca", "Chaves", "Cinfães", "Coimbra", "Condeixa-a-Nova", "Constância", "Coruche", "Covilhã", "Crato", "Cuba", "Elvas", "Entroncamento", "Espinho", "Esposende", "Estarreja", "Estremoz", "Évora", "Fafe", "Faro", "Felgueiras", "Ferreira do Alentejo", "Ferreira do Zêzere", "Figueira da Foz", "Figueira de Castelo Rodrigo", "Figueiró dos Vinhos", "Fornos de Algodres", "Freixo Espada à Cinta", "Fronteira", "Fundão", "Gavião", "Góis", "Golegã", "Gondomar", "Gouveia", "Grândola", "Guarda", "Guimarães", "Idanha-a-Nova", "Ílhavo", "Lagoa", "Lagos", "Lamego", "Leiria", "Lisboa", "Loulé", "Loures", "Lourinhã", "Lousã", "Lousada", "Mação", "Macedo de Cavaleiros", "Mafra", "Maia", "Mangualde", "Manteigas", "Marco de Canaveses", "Marinha Grande", "Marvão", "Matosinhos", "Mealhada", "Meda", "Melgaço", "Mértola", "Mesão Frio", "Mira", "Miranda do Corvo", "Miranda do Douro", "Mirandela", "Mogadouro", "Moimenta da Beira", "Moita", "Monção", "Monchique", "Mondim de Basto", "Monforte", "Montalegre", "Montemor-o-Novo", "Montemor-o-Velho", "Montijo", "Mora", "Mortágua", "Moura", "Mourão", "Murça", "Murtosa", "Nazaré", "Nelas", "Nisa", "Óbidos", "Odemira", "Odivelas", "Oeiras", "Oleiros", "Olhão", "Oliveira de Azeméis", "Oliveira de Frades", "Oliveira do Bairro", "Oliveira do Hospital", "Ourém", "Ourique", "Ovar", "Paços de Ferreira", "Palmela", "Pampilhosa da Serra", "Paredes", "Paredes de Coura", "Pedrógão Grande", "Penacova", "Penafiel", "Penalva do Castelo", "Penamacor", "Penedono", "Penela", "Peniche", "Peso da Régua", "Pinhel", "Pombal", "Ponte da Barca", "Ponte de Lima", "Ponte de Sôr", "Portalegre", "Portel", "Portimão", "Porto", "Porto de Mós", "Póvoa de Lanhoso", "Póvoa de Varzim", "Proença-a-Nova", "Redondo", "Reguengos de Monsaraz", "Resende", "Ribeira de Pena", "Rio Maior", "Sabrosa", "Sabugal", "Salvaterra de Magos", "Santa Comba Dão", "Santa Maria da Feira", "Santa Marta de Penaguião", "Santarém", "Santiago do Cacém", "Santo Tirso", "São Brás de Alportel", "São João da Madeira", "São João da Pesqueira", "São Pedro do Sul", "Sardoal", "Sátão", "Seia", "Seixal", "Sernancelhe", "Serpa", "Sertã", "Sesimbra", "Setúbal", "Sever do Vouga", "Silves", "Sines", "Sintra", "Sobral Monte Agraço", "Soure", "Sousel", "Tábua", "Tabuaço", "Tarouca", "Tavira", "Terras de Bouro", "Tomar", "Tondela", "Torre de Moncorvo", "Torres Novas", "Torres Vedras", "Trancoso", "Trofa", "Vagos", "Vale de Cambra", "Valença", "Valongo", "Valpaços", "Vendas Novas", "Viana do Alentejo", "Viana do Castelo", "Vidigueira", "Vieira do Minho", "Vila de Rei", "Vila do Bispo", "Vila do Conde", "Vila Flor", "Vila Franca de Xira", "Vila Nova da Barquinha", "Vila Nova de Cerveira", "Vila Nova de Famalicão", "Vila Nova de Foz Côa", "Vila Nova de Gaia", "Vila Nova de Paiva", "Vila Nova de Poiares", "Vila Pouca de Aguiar", "Vila Real", "Vila Real de Santo António", "Vila Velha de Ródão", "Vila Verde", "Vila Viçosa", "Vimioso", "Vinhais", "Viseu", "Vizela", "Vouzela")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWhereAreWeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapa: ImageView = binding.mapa
        mapa.setImageResource(R.drawable.mapa)

        val spinner = binding.spinner
        val arrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaConselho)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (listaConselho[position] != "Concelhos") {
                    Toast.makeText(requireContext(), "Concelho selecionado: " + listaConselho[position], Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}