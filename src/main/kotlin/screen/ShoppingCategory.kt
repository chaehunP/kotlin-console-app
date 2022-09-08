package screen

import extensions.getNotEmptyString

/*
Step 1. 장바구니에 추가한 상품 관리
Step 2. 사용자 입력값 요청 처리 공통화
Step 3. 프로젝트 전역에서 참조하는 상수
 */

class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물 용품", "주방용품")
        for (category in categories) {
            print("          ")
            println(category)
        }
        println("***=============================***")
        println("==> 장바구니로 이동하시려면 #을 입력해주세요")

        val selectedCategory = readLine().getNotEmptyString()
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.ShowCartItems()
        }else {
            if(categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()  // 상품리스트 인스턴스 생성
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMesage(selectedCategory)
            }
        }
    }

    private fun showErrorMesage(selectedCategory: String) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        println("***=============================***")
        showCategories()
    }
}