package extensions

// 파일로 만든 이유는 top-level의 함수로 확장 함수를 추가하기 위해

// 카테고리명, *, # 등을 입력하라고 요청했을 때 사용자가 빈값, 혹은 공백을 입력하지 않도록 확인하는 용도로 사용
fun String?.getNotEmptyString(): String {
    var input = this  // this는 String? 을 가리킴
    while(input.isNullOrBlank()) {
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.trim()
}

// 시용자에게 상품 번호를 입력받을 때 그 값이 Int 타입으로 변환할 수 있는 값인지 확인하는 용도로 사용
fun String?.getNotEmptyInt(): Int {
    var input = this?.trim()
    while(input.isNullOrEmpty() || input.toIntOrNull() == null) {
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.toInt()
}

