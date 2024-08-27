package model


class Personagem(val atributos: MutableMap<String, Int>, val raca: Raca) {
    // Aplica os bônus da raça nos atributos do personagem
    fun aplicarBonusDeRaca() {
        raca.bonus.forEach { (atributo, bonus) ->
            atributos[atributo] = atributos[atributo]!! + bonus
        }
    }

    //Método que deixa o usuário distribuir os 27 pontos entre os atributos
    fun distribuirPontos(pontos: Int) {
        var pontosRestantes = pontos
        while (pontosRestantes > 0) {
            println("Você tem $pontosRestantes pontos sobrando.")
            println("Atributos:")
            atributos.forEach { (atributo, valor) ->
                println("$atributo: $valor")
            }

            println("Informe o atributo que deseja aumentar:")
            val atributo = readLine()?.capitalize() ?: ""
            if (!atributos.containsKey(atributo)) {
                println("Atributo não existe.")
                continue
            }

            println("Quantos pontos para o atributo $atributo?")
            val pontosEntrada = readLine()?.toIntOrNull()

            if (pontosEntrada == null || pontosEntrada <= 0) {
                println("Entrada inválida.")
                continue
            }

            // Verifica se os pontos podem ser distribuídos e se não passam de 15
            if (pontosRestantes >= pontosEntrada && (atributos[atributo]!! + pontosEntrada) <= 15) {
                atributos[atributo] = atributos[atributo]!! + pontosEntrada
                pontosRestantes -= pontosEntrada
            } else {
                println("Sem pontos suficientes ou limite (15) alcançado.")
            }
        }
    }

    // Calcula os pontos de vida com base na constituição
    fun calcularPontosDeVida(): Int {
        val constituicao = atributos["Constituição"] ?: 0
        val modificadorConstituicao = (constituicao - 10) / 2
        return 10 + modificadorConstituicao
    }
}

