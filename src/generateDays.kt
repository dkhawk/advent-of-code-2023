import java.io.File

fun main() {
    val baseDir = File("/Users/dkhawk/IdeaProjects/advent-of-code-2023/src") // Base directory for source files
    val inputsDir = File("/Users/dkhawk/IdeaProjects/advent-of-code-2023/src/inputs") // Directory for input files

    // Create base directory if it doesn't exist
    if (!baseDir.exists()) {
        baseDir.mkdirs()
    }
    if (!inputsDir.exists()) {
        inputsDir.mkdirs()
    }

    for (day in 1..25) {
        val dayString = day.toString().padStart(2, '0')
        val dayDir = File(baseDir, "day$dayString")

        if (!dayDir.exists()) {
            dayDir.mkdirs()
        }

        val ktFile = File(dayDir, "Day${dayString}.kt")
        if (!ktFile.exists()) {
            ktFile.createNewFile()
            ktFile.writeText(generateKotlinFileContent(dayString))
        }
    }

    println("Advent of Code file structure generated successfully!")
}

fun generateKotlinFileContent(day: String): String {
    return """
        package day$day

        import utils.*

        val testInput = ${"\"\"\""}

        ${"\"\"\""}.trimIndent().lines()

        fun main() {
            check(part1(testInput) == 0)
            check(part2(testInput) == 0)

            val input = readLines("inputs/$day")
            println(part1(input))
            println(part2(input))
        }

        private fun part1(input: List<String>): Int {
            return -1
        }

        private fun part2(input: List<String>): Int {
            return -1
        }
    """.trimIndent()
}
