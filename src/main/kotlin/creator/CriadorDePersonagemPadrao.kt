package creator

import model.Personagem
import model.Raca

// Implementação padrão do criador de personagens, define como o personagem é criado
class CriadorDePersonagemPadrao : CriadorDePersonagem {
        override fun criarPersonagem(raca: Raca): Personagem {
            // Começa com os atributos básicos, tudo com 8
            val atributos = mutableMapOf(
                "Força" to 8,
                "Destreza" to 8,
                "Constituição" to 8,
                "Inteligência" to 8,
                "Sabedoria" to 8,
                "Carisma" to 8
            )
            // Cria o personagem com esses atributos e a raça escolhida
            val personagem = Personagem(atributos, raca)
            // Aplica os bônus da raça nos atributos
            personagem.aplicarBonusDeRaca()

            // Define que o usuário tem 27 pontos pra distribuir
            val pontos = 27
            personagem.distribuirPontos(pontos)

            return personagem
        }
    }




