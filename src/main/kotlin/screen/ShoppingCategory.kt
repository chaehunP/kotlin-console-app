package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

class ShoppingCategory : Screen() {
    fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물 용품", "주방용품")
        for (category in categories) {
            print("          ")
            println(category)
        }
        println("$LINE_DIVIDER")
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
        println("$LINE_DIVIDER")
        showCategories()
    }
}