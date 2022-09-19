package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

class ShoppingCart : Screen() {
    private val products = CartItems.products

    fun showCartItems() {
        ScreenStack.push(this)
        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString( // products의 키에 따라 해당 상품의 수량을 표시
                    separator = ", \n",
                    prefix = """
                    $LINE_DIVIDER
                    장바구니에 담은 상품 목록 입니다.
                    
                    """.trimIndent()
                ) { product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"
                }
            )
        } else {
            println(
                """
                장바구니에 담긴 상품이 없습니다.
            """.trimIndent()
            )
        }
        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption() {
        println(
            """
            $LINE_DIVIDER
            이전 화면으로 돌아가시겠습니까? (y/n)
        """.trimIndent()
        )
        when (readLine().getNotEmptyString()) {
            "y" -> {
                moveToPreviousScreen()
            }

            "n" -> {
                showCartItems()
            }

            else -> {
                // TODO 재입력 요청
                println("y 또는 n 둘 중 하나만 입력해주세요.")
                showPreviousScreenOption()
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop() // 이전화면으로 벗어나려면 pop 함수를 호출해야 함
        when (val previousScreen = ScreenStack.peek()) { // 이전 화면으로 이동했을 때 진입했을 때와 동일한 동작을 해야하므로 이전 화면에 대한 참조가 필요하기 때문에 peek함수 호출
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList -> {
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {
                // 아무 것도 하지 않음
            }
            else -> {}
        }
    }
}
