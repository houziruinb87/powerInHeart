//IntArray类型和Array<Int>类型   是不一样的需要注意
//kotlin中的位运算:异或为xor,与为and,或为or
fun main(args: Array<String>) {

    val array: IntArray = intArrayOf(
        1,
        44,
        55,
        6,
        77,
        1123,
        456,
        567,
        2,
        54,
        67,
        7,
        8,
        45,
        7,
        54,
        6,
        456,
        45,
        645,
        63,
        5,
        6,
        3456,
        3,
        562,
        57
    )
//    val array3: Array<Int> = arrayOf(1, 2, 3)
//    val thisIsIntArray: IntArray = intArrayOf()
//    thisIsIntArray[0] = 1
//    var arrayAny: Array<Any>

//    arrayAny = array3 as Array<Any>

    println("原始数据${array.contentToString()}")
    println("选择算法升序数据:${insertToSort(array).contentToString()}")
    println("冒泡算法升序数据:${bubbleToSort(array).contentToString()}")


}

fun insertToSort(intArray: IntArray): IntArray {
    for (i in intArray.indices) {
        // 使用 until关键字,避免自己手写length-1
        for (j in i until intArray.size) {
            if (intArray[j] < intArray[i]) {
                swap(intArray, i, j)
            }
        }
    }
    return intArray
}
fun swap(intArray: IntArray, i: Int, j: Int): IntArray {
    intArray[i] = intArray[i] xor intArray[j]
    intArray[j] = intArray[i] xor intArray[j]
    intArray[i] = intArray[i] xor intArray[j]
    return intArray
}

fun bubbleToSort(array: IntArray):IntArray{
    var arrayLength :Int = array.size
    for (i in 0 until arrayLength){
        for (j in 0 until arrayLength-1){
            if(array[j]<array[j+1]){
                swap(array,j,j+1)
            }
        }
    }
    return array
}