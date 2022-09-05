package screen

class ShoppingHome {
    fun start() {
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        println("안녕하세요, Shoppi 에 오신 것을 환영합니다!")
        println("쇼핑을 계속 하시려면 이름을 입력해주세요 :) ")
        print("이름: ")

        val name = readLine()
        println(
            """
            
            감사합니다. 반갑습니다. $name 님
            원하시는 카테고리를 입력해주세요.
            ***==============================***
        """.trimIndent()
        )  // .trimIndent()는 문자열 출력 시 자동으로 모든 입력 라인의 공통 최소 들여쓰기를 감지하고 모든 라인에서 그만큼 제거하는 기능
        // 다시 말해 현재 코드에 작성된 문자열은 앞에 띄어쓰기가 되어있는데 trimIndent()를 사용하지 않으면 출력시 문자열 앞이 띄어진 채로 출력됨
    }

    private fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물 용품")
        for (category in categories) {
            print("          ")
            println(category)
        }
        println("***=============================***")
        println("==> 장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("유효한 값을 입력해주세요")
            selectedCategory = readLine()
        }

        if (selectedCategory == "#") {
            //TODO 1. 장바구니 이동
        } else {
            //TODO 2. 카테고리 상품 목록 보여주기
            //TODO 3. 카테고리 목록에 없는 입력 값에 대한 처리
        }
    }
}