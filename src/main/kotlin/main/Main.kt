package main

import model.Anao
import model.Elfo
import model.Halfling
import model.Humano
import creator.CriadorDePersonagemPadrao
import creator.CriadorDePersonagem

    fun main() {
        // Mapeando os nomes das raças para as classes correspondentes
        val racas = mapOf(
            "Humano" to Humano(),
            "Elfo" to Elfo(),
            "Anão" to Anao(),
            "Halfling" to Halfling()
        )

        // Mostrar as opções de raças pro usuário escolher
        println("Selecione a raça:")
        racas.keys.forEach { println(it) }

        // Pega a escolha do usuário e ajusta a primeira letra pra maiúscula
        val racaSelecionada = readLine()?.capitalize() ?: ""

        // Verifica se a raça escolhida existe no mapa
        if (!racas.containsKey(racaSelecionada)) {
            println("Raça inválida.")
            return
        }

        // Pega a instância da raça escolhida
        val raca = racas[racaSelecionada]!!
        // Usa o criador de personagem padrão pra criar o personagem com a raça escolhida
        val criador: CriadorDePersonagem = CriadorDePersonagemPadrao()
        val personagem = criador.criarPersonagem(raca)

        // Mostra os atributos já com os bônus da raça aplicados
        println("Atributos com aplicação de bônus de raça:")
        personagem.atributos.forEach { (atributo, valor) ->
            println("$atributo: $valor")
        }

        // Calcula e mostra os pontos de vida do personagem
        val pontosDeVida = personagem.calcularPontosDeVida()
        println("Pontos de vida: $pontosDeVida")
    }

