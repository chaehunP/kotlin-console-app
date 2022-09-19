package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

/*
Step 1. 화면 이동을 관리하는 Stack
Step 2. 장바구니 이전화면 이동 구현
 */

class ShoppingHome : Screen() {
    fun start() {
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        ScreenStack.push(this) // showWelcomeMessage 함수가 호출 되었을 때 이 화면에 진입했다고 생각
        println("안녕하세요, Shoppi 에 오신 것을 환영합니다!")
        println("쇼핑을 계속 하시려면 이름을 입력해주세요 :) ")
        print("이름: ")

        val name = readLine().getNotEmptyString()  // readLine()는 nullable String이기 때문에 String? 형태인 getNotEmptyString() 사용 가능
        println(
            """
            
            감사합니다. 반갑습니다. $name 님
            원하시는 카테고리를 입력해주세요.
            $LINE_DIVIDER
        """.trimIndent()
        )  // .trimIndent()는 문자열 출력 시 자동으로 모든 입력 라인의 공통 최소 들여쓰기를 감지하고 모든 라인에서 그만큼 제거하는 기능
        // 다시 말해 현재 코드에 작성된 문자열은 앞에 띄어쓰기가 되어있는데 trimIndent()를 사용하지 않으면 출력시 문자열 앞이 띄어진 채로 출력됨
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()  // 쇼핑카테고리의 인스턴스 생성
        shoppingCategory.showCategories()

    }
}