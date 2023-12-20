class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        val regex = Regex("\\{(\\d+(?:,\\d+)*)\\}")
        //  \{ ( \d+ (?:, \d+ )*) \}
        // (A+B*)
        //A : \d+ -> 하나이상의 숫자
        //B : (?:,A) -> ,로 시작하고 그뒤에 하나이상의 숫자가 올경우
        //  (?:X) --> 찾지만 그룹에 포함시키지 않음 ..{1,2,3} 을 원하지 {1,2,3},{2,3} 꼴을 원하진 않음
        //B* : B가 0번이상 발생할수 있음
        // '\{' -->'\{' 이스케이프!


        var matches = regex.findAll(s)
        //groupValues[0] : 전체 정규표현식에 일치하는 부분 '(\d+(?:,\d+)*)'
        //groupValues[1] : 첫번째 그룹에 해당되는 값 ,(?:X) 가 적용된 값들이 들어감.
        var result = matches.map{it.groupValues[1].split(',').map(String::toInt)}.toMutableList()
        result.sortBy{it.size}

        //작은 숫자 부터 입력
        var resultSet = mutableSetOf<Int>()
        result.forEach{
            it.forEach{ value ->
                resultSet.add(value)
            }
        }
        answer = resultSet.toIntArray()
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