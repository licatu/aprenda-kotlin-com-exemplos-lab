enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {

    // Criando conteúdos
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 90)
    val pooKotlin = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 120)
    val colecoesKotlin = ConteudoEducacional("Trabalhando com Coleções em Kotlin", 100)

    // Criando formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        
        conteudos = listOf(kotlinBasico, pooKotlin, colecoesKotlin)
    )

    // Criando usuários
    val usuario1 = Usuario("Ana")
    val usuario2 = Usuario("Carlos")

    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("\n--- Resumo da Formação ---")
    println("Nome: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach { println("- ${it.nome} (${it.duracao} min)") }

    println("\nAlunos matriculados:")
    formacaoKotlin.inscritos.forEach { println("- ${it.nome}") }
}
