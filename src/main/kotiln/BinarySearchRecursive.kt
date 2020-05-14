object BinarySearch {

    /**
     * @Param begin inclusive
     * @Param end inclusive
     */
    fun search(needle: Int, haystack: Array<Int>): Int {
        if (haystack.isEmpty()) {
            return -1
        }

        var begin = 0
        var end = haystack.size - 1

        do {
            val rangeSize = end - begin
            val middle = begin + rangeSize / 2
            val value = haystack[middle]

            // println("[$begin $end]")

            if (value == needle) {
                for (i in (middle downTo 0)) {
                    if (value != haystack[i]) { // walk backwards to ensure we find first element
                        return i + 1 // revert to previous
                    }
                }
                return 0
            }

            if (rangeSize == 0) { -1 }

            //println(begin.toString() + " > " + middle + " < " + end)

            when {
                needle < value -> {
                    end = middle - 1
                }
                needle > value -> {
                    begin = middle + 1
                }
            }

        } while (rangeSize > 0)

        return -1
    }

}


// jvm args for assertions -ea
fun main() {
    val arr1 = arrayOf<Int>(1, 1, 2, 3, 3, 4, 4, 8, 8)
    val arr2 = arrayOf<Int>(3, 3, 7, 7, 10, 11, 11)

    assert(-1 == BinarySearch.search(1, emptyArray()))

    assert(0 == BinarySearch.search(1, arr1))
    assert(2 == BinarySearch.search(2, arr1))
    assert(3 == BinarySearch.search(3, arr1))
    assert(5 == BinarySearch.search(4, arr1))
    assert(7 == BinarySearch.search(8, arr1))
    assert(-1 == BinarySearch.search(0, arr1))
    assert(-1 == BinarySearch.search(10, arr1))

    assert(0 == BinarySearch.search(3, arr2))
    assert(2 == BinarySearch.search(7, arr2))
    assert(4 == BinarySearch.search(10, arr2))
    assert(5 == BinarySearch.search(11, arr2))
    assert(-1 == BinarySearch.search(2, arr2))
    assert(-1 == BinarySearch.search(12, arr2))
}