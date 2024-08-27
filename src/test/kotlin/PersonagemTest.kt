
    package model

    import org.junit.jupiter.api.Assertions.*
    import org.junit.jupiter.api.Test

    class PersonagemTest {

        @Test
        fun `deve distribuir 27 pontos corretamente`() {
            // Passo 1: Criar atributos iniciais
            val atributos = mutableMapOf(
                "Força" to 8,
                "Destreza" to 8,
                "Constituição" to 8,
                "Inteligência" to 8,
                "Sabedoria" to 8,
                "Carisma" to 8
            )

            // Passo 2: Criar a raça e o personagem
            val raca = Humano()
            val personagem = Personagem(atributos, raca)

            // Passo 3: Distribuir os 27 pontos
            personagem.distribuirPontos(27)

            // Passo 4: Verificar se os pontos foram distribuídos corretamente
            val totalPointsSpent = personagem.atributos.values.sum() - 6 * 8 // 6 atributos, 8 pontos iniciais
            assertEquals(27, totalPointsSpent)

            // Passo 5: Verificar se nenhum atributo ultrapassou o limite de 15 pontos
            personagem.atributos.values.forEach { valor ->
                assertTrue(valor in 8..15, "O valor de um atributo ultrapassou o limite de 15: $valor")
            }
        }
    }

