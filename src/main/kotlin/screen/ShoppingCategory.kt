package screen

class ShoppingCategory {
    fun showCategories() {
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
        }else {
            if(categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMesage(selectedCategory)
            }
        }
    }

    private fun showErrorMesage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        println("***=============================***")
        showCategories()
    }
}