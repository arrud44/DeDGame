package creator

import model.Personagem
import model.Raca

// Interface que define como criar um personagem, meio que uma receita que pode ter várias versões
interface CriadorDePersonagem {
    fun criarPersonagem(raca: Raca): Personagem
}


