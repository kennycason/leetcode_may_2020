object Solution2 {
    fun numJewelsInStones(j: String, s: String): Int {
        val jSet: Set<Char> = j.map { c -> c }.toSet()

        return s.filter(jSet::contains).length
    }
}


fun main() {
    assert(0 == Solution2.numJewelsInStones("z", "ZZ"))
    assert(3 == Solution2.numJewelsInStones("aA", "aAAbbbbb"))
}