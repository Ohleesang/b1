class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        val regex = Regex("[{}]+")
        var stringBuilder = StringBuilder()
        val list = mutableListOf<String>()

        s.forEach {
            stringBuilder.append(it)
            if (it == '}') {
                var temp = stringBuilder.replace(regex,"")

                list.add(temp)
                stringBuilder.clear()
            }
        }

        return answer
    }
}

fun main() {

    val a = Solution()
    a.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")//2,1,3,4
    a.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")//2,1,3,4
    a.solution("{{20,111},{111}}")//111,20
    a.solution("{123}")//123
    a.solution("{4,2,3},{3},{2,3,4,1},{2,3}")//3,2,4,1
}