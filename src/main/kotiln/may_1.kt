abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean {
        return version >= 4
    }
}


class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var begin = 1
        var end = n
        var lastBadVersion = -1

        do {
            val rangeSize = end - begin
            //println(rangeSize.toString() + " [" + begin + ", " + end + "]")
            if (rangeSize == 0) {
                if (isBadVersion(begin)) {
                    lastBadVersion = begin
                }
                return lastBadVersion
            }

            val middle = begin + rangeSize / 2

            //println(begin.toString() + " > " + middle + " < " + end)

            val isBadVersion = isBadVersion(middle)
            //println("bad? $middle -> $isBadVersion")
            if (!isBadVersion) {
                begin = middle + 1
            } else {
                lastBadVersion = middle
                end = middle - 1
            }

        } while (rangeSize >= 0)

        return lastBadVersion
    }
}

fun main() {
    val solution = Solution()
    println(solution.firstBadVersion(5))
}